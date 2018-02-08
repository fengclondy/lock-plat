package com.mvc.ethereum.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author qyc
 */
@Data
public class SendTransactionDTO {

    private String pass;
    private String from;
    private String to;
    private BigInteger gas;
    private BigInteger gasPrice;
    private BigDecimal value;
    private String data;
    private BigInteger nonce;

}