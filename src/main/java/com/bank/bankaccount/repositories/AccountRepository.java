package com.bank.bankaccount.repositories;

import com.bank.bankaccount.models.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository implements IAccountRepository {
    private static List<Account> accounts;

    static {
        accounts = new ArrayList<>() {{
            add(new Account());
        }};
    }

    @Override
    public Account findAccountById(Long id) {
        return accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }
}
