package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Account;
import com.app.acmedelivery.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account>{

    private final AccountRepository accountRepository;

    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }

    public Account findByEmail(final String email){
        return accountRepository.findByEmail(email);
    }

    public Account findByMobilePhone(final String mobilePhone){
        return accountRepository.findByMobilePhone(mobilePhone);
    }
}
