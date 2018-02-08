package com.mvc.ethereum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author qyc
 */
@Builder(builderClassName = "Builder", toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EthTransaction {
    private String data;
    private String from;
    private String to;
    private long gas;
    private long gasPrice;
    private long value;
//    private long nonce;
}
