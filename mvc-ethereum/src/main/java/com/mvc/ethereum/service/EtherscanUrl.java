package com.mvc.ethereum.service;

public interface EtherscanUrl {

    public final static String TXLIST = "?module=account&action=txlist&startblock=0&endblock=99999999&sort=asc&address=%s";
}
