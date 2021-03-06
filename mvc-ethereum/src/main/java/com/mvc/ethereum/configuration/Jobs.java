package com.mvc.ethereum.configuration;

import com.mvc.common.constant.CommonConstants;
import com.mvc.ethereum.service.TransationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author qyc
 * transfer token to the super account
 */
@Component
public class Jobs {

    @Value("${job.limit}")
    private BigInteger limit;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TransationService transationService;
    @Autowired
    private WalletConfig walletConfig;

    /**
     * transfer gas
     */
    @Scheduled(cron = "${job.interval.gas}")
    public void transferGas() {
        // find all accounts if balance is out of limit
        Long size = redisTemplate.opsForList().size(CommonConstants.LIMIT_LIST);
        for (Long i = size - 1; i >= 0; i--) {
            String addr = (String) redisTemplate.opsForList().index(CommonConstants.LIMIT_LIST, i);
            Boolean result = transationService.sendGas(addr);
        }
    }

    /**
     * transfer token
     */
    @Scheduled(cron = "${job.interval.token}")
    public void transferToken() {
        // find all accounts if balance is out of limit
        Long size = redisTemplate.opsForList().size(CommonConstants.LIMIT_LIST);
        for (Long i = size - 1; i >= 0; i--) {
            String addr = (String) redisTemplate.opsForList().index(CommonConstants.LIMIT_LIST, i);
            Boolean result = transationService.sendToken(addr);
            if (result) {
                redisTemplate.opsForList().remove(CommonConstants.LIMIT_LIST, 1, addr);
            }
        }
    }




    /**
     * unlock token
     */
    @Scheduled(cron = "${job.interval.lock}")
    public void transferLock() {
        transationService.unlock();
    }
}