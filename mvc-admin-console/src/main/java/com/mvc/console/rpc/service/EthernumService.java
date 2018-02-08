package com.mvc.console.rpc.service;

import com.mvc.api.vo.log.LogInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qyc
 */
@FeignClient("mvc-etherenum")
public interface EthernumService {
    /**
     * saveLog
     *
     * @param info
     */
    @RequestMapping(value = "/api/log/save", method = RequestMethod.POST)
    public void saveLog(LogInfo info);

}
