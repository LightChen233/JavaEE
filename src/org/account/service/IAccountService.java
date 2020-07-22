package org.account.service;

import org.account.entity.Account;

import java.util.List;

public interface IAccountService {

    public int addAccount(Account account) ;

    public int deleteAccountByName(String name) ;

    public int updateAccountByName(Account account) ;

    public Account queryAccountByName(String name) ;

    public Account queryAccountToLogin(String name, String password);

    public List<Account> queryAllAccounts();


}
