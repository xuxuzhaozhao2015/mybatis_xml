package top.xuxuzhaozhao.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xuxuzhaozhao.dao.IAccountDao;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream inputStream;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public void TestGetAll() {
        List<Account> accounts = accountDao.GetAll();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
