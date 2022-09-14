package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Account;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public interface AccountService extends BaseService<Account> {

    Account findByEmail(final String email);
}
