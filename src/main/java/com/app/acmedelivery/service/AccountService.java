package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Account;

public interface AccountService extends BaseService<Account> {

    Account findByEmail(final String email);
}
