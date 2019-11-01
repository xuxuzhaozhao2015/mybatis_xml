package top.xuxuzhaozhao.dao;

import top.xuxuzhaozhao.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户，同时查询该账户对应的用户信息（1对1）
     * @return
     */
    List<Account> GetAll();

    List<Account> findAccountByUid(Integer uid);
}
