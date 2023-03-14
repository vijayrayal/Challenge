package com.dws.challenge.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.challenge.domain.Account;
import com.dws.challenge.repository.AccountsRepository;

import lombok.Getter;
import lombok.Synchronized;

@Service
public class AccountsService {

	@Getter
	private final AccountsRepository accountsRepository;

	@Autowired
	public AccountsService(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	public void createAccount(Account account) {
		this.accountsRepository.createAccount(account);
	}

	public Account getAccount(String accountId) {
		return this.accountsRepository.getAccount(accountId);
	}

	@Synchronized
	public Boolean transferAmountBetweenAccounts(Account fromAccount, Account toAccount, BigDecimal amount) {
		fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
		this.accountsRepository.updateAccount(fromAccount);
		toAccount.setBalance(toAccount.getBalance().add(amount));
		this.accountsRepository.updateAccount(toAccount);
		return Boolean.TRUE;
	}

}
