package com.app.acmedelivery.controller;

import com.app.acmedelivery.domainModel.Account;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.repository.AccountRepository;
import com.app.acmedelivery.service.AccountService;
import com.app.acmedelivery.service.BaseService;
import com.app.acmedelivery.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("Accounts")
public class AccountController extends AbstractController<Account>{

    private final AccountService accountService;
	private final AccountRepository accountRepository;

    @Override
    protected BaseService<Account> getBaseService() {
        return accountService;
    }

	@CrossOrigin(origins = "*")
	@GetMapping("allAccounts")
	public List<Account> getAccounts(){
		return this.accountRepository.findAll();
	}

    @RequestMapping(params = "email")
    public ResponseEntity<ApiResponse<Account>> findByEmail(@Email @RequestParam String email) {
        final Account byEmail = accountService.findByEmail(email);
        if (byEmail == null) {
            throw new NoSuchElementException("Element not found");
        }
        return ResponseEntity.ok(ApiResponse.<Account>builder().data(byEmail).build());
    }
}
