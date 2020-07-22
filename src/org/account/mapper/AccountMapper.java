package org.account.mapper;

import java.util.List;

import org.account.entity.Account;
//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
//	@Insert(" insert into logindata(name,password,email) values(#{name},#{password},#{email}) ") 
	void addAccount(Account account);
//	@Delete("delete from logindata where name=#{name}")
	void deleteAccountByName(String name);
//	@Update("update logindata set password=#{password} , email=#{email} where name=#{name}")
	void updateAccountByName(Account account);
//	@Select(" select * from logindata where name = #{name} ")
	Account queryAccountByName(String name);
//	@Select("select * from logindata")
	List<Account> queryAllAccounts();
//	@Select("select * from logindata where name= #{name} and password= #{password}")
	Account queryAccountToLogin(Account account);
}
