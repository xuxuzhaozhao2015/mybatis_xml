package top.xuxuzhaozhao.dao;

import top.xuxuzhaozhao.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户，同时获取该用户下所有的账户信息（一对多）
     * @return
     */
    List<User> GetAll();

    Integer AddUser(User user);

    User GetUser(Integer id);

    void ModifiedUser(User user);

    void DeleteUser(Integer id);

    /**
     * 根据条件查询
     * @param user
     * @return
     */
    List<User> GetUserByCondition(User user);


    List<User> GetUserByIds(List<Integer> ids);

    List<User> findAllUserRole();
}
