package top.xuxuzhaozhao.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xuxuzhaozhao.dao.IUserDao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream inputStream;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
//        session = factory.openSession(true);// 自动提交
        session = factory.openSession();

        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public void TestGetAll(){
        List<User> users = userDao.GetAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void TestFindAllUserRole() {
        List<User> users = userDao.findAllUserRole();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void TestAddUser() throws Exception {
        User user = new User();
        user.setUsername("suche");
        user.setSex("f");
        user.setBirthday(new Date());
        user.setAddress("sichuang chengdu.");

        userDao.AddUser(user);

        System.out.println(user);
    }

    @Test
    public void TestGetUser() throws Exception {
        User user = userDao.GetUser(11);

        System.out.println(user);
    }

    @Test
    public void TestModifiedUser() throws Exception {
        User user = userDao.GetUser(11);
        user.setUsername("cheng xi.");

        userDao.ModifiedUser(user);

        System.out.println(user);
    }

    @Test
    public void TestDeleteUser() {
        userDao.DeleteUser(11);
    }

    @Test
    public void TestGetUserByCondition() {
        User user = new User();
        user.setUsername("xu");
        user.setSex("m");

        List<User> users = userDao.GetUserByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void TestGetUserByIds() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<User> users = userDao.GetUserByIds(ids);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
