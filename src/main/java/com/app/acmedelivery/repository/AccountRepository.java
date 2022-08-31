package com.app.acmedelivery.repository;

import com.app.acmedelivery.domainModel.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByEmail(String email);

    Account findByMobilePhone(String mobilePhone);
}
