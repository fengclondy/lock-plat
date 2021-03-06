package com.mvc.ethereum.visitor;

import com.mvc.ethereum.model.Account;
import com.mvc.ethereum.model.Method;

import java.util.Optional;

/**
 * @author qyc
 */
public class VisitorFactory {

    public static Method buildMethod(final Optional<String> name, final Optional<Object[]> args) {
        return Method.builder().name(name.isPresent() ? name.get() : null).args(args.isPresent() ? args.get() : null).build();
    }

    public static <T> AbstractBlockchainVisitor build(final String contractAddress, final String accountAddress, final String pwd, final String name, final String content, final T model, Method method) {
        Account account = Account.builder().address(accountAddress).passphrase(pwd).build();

        AbstractBlockchainVisitor visitor = new AbstractBlockchainVisitor(method) {

            @Override
            public String getContent() {
                return content;
            }

            @Override
            public String getName() {
                return name;
            }
        };
        visitor.setAccount(account);
        visitor.setModel(model);
        visitor.setAddress(contractAddress);
        return visitor;
    }
}
