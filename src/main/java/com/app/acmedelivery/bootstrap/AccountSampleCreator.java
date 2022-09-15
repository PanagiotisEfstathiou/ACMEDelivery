package com.app.acmedelivery.bootstrap;

import com.app.acmedelivery.base.BaseComponent;
import com.app.acmedelivery.domainModel.Account;
import com.app.acmedelivery.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("generateSampleData")
@RequiredArgsConstructor
public class AccountSampleCreator extends BaseComponent implements CommandLineRunner {

	private final AccountService accountService;

	@Override
	public void run(final String... args) throws Exception {

		List<Account> customers = List.of(
				Account.builder().firstName("nick").lastName("Jones").mobilePhone("2322242411").address("addr").email("smth@email.com").password("daasdad").build(),
				Account.builder().firstName("nick2").lastName("Jones").mobilePhone("2322242410").address("addr").email("smth2@email.com").password("daasdad").build(),
				Account.builder().firstName("nick3").lastName("Jones").mobilePhone("2322242419").address("addr").email("smth3@email.com").password("daasdad").build(),
				Account.builder().firstName("nick4").lastName("Jones").mobilePhone("2322242418").address("addr").email("smth4@email.com").password("daasdad").build(),
				Account.builder().firstName("nick5").lastName("Jones").mobilePhone("2322242417").address("addr").email("smth5@email.com").password("daasdad").build(),
				Account.builder().firstName("nick6").lastName("Jones").mobilePhone("2322242416").address("addr").email("smth6@email.com").password("daasdad").build(),
				Account.builder().firstName("nick7").lastName("Jones").mobilePhone("2322242415").address("addr").email("smth7@email.com").password("daasdad").build(),
				Account.builder().firstName("nick8").lastName("Jones").mobilePhone("2322242414").address("addr").email("smth8@email.com").password("daasdad").build(),
				Account.builder().firstName("nick9").lastName("Jones").mobilePhone("2322242413").address("addr").email("smth9@email.com").password("daasdad").build(),
				Account.builder().firstName("nick10").lastName("Jones").mobilePhone("2322242412").address("addr").email("smth10@email.com").password("sdasdas").build()
										 );



		logger.info("Created {} accounts" , accountService.createAll(customers).size());
	}
}
