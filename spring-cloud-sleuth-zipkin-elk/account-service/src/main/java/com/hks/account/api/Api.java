package com.hks.account.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hks.account.gateway.MybatisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hks.account.model.Account;

@RestController
public class Api {

	private List<Account> accounts;
	
	protected static Logger logger = LoggerFactory.getLogger(Api.class.getName());

	@Autowired
	MybatisClient mybatisClient;
	
	public Api() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111"));
		accounts.add(new Account(2, 2, "222222"));
		accounts.add(new Account(3, 3, "333333"));
		accounts.add(new Account(4, 4, "444444"));
		accounts.add(new Account(5, 1, "555555"));
		accounts.add(new Account(6, 2, "666666"));
		accounts.add(new Account(7, 2, "777777"));
	}
	
	@RequestMapping("/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		Account a = accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
		logger.info(String.format("Account.findByNumber: %s", a));
		return a;
	}

	@RequestMapping("/accounts/database")
	public String database() {
		logger.info(String.format("Account.database()"));
		String database = mybatisClient.consumer();
		logger.info(String.format("Account.database: %s", database));
		return database;
	}
	
	@RequestMapping("/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		List<Account> as = accounts.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
		logger.info(String.format("Account.findByCustomer: %s", as));
		return as;
	}
	
	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		logger.info(String.format("Account.findAll: %s", accounts));
		return accounts;
	}
	
}
