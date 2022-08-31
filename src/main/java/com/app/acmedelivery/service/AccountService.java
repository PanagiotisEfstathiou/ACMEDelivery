package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Account;

public interface AccountService extends BaseService<Account> {

    Account create(Account account);

    void update(Account account);

    void delete(Account entity);
}
