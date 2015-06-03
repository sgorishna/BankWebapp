package com.webapp.dao;

import java.math.BigDecimal;
import java.util.List;

import com.webapp.model.Account;

public interface AccountDao extends IEntityDao<Account> {

	List<Account> getAccountByIdCustomer(long idCustomer);

	void topUpBalance(Account account, BigDecimal amount);

	Account getAccountByAccountNumber(long accountNumber);

}
