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
import java.util.List;

public class SecondCacheTest {

    private InputStream inputStream;
    private SqlSessionFactory factory;

    @Before
    public void Init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
    }

    @After
    public void destory() throws Exception {
        inputStream.close();
    }

    @Test
    public void TestSecondCache(){
        SqlSession session1 = factory.openSession();
        IUserDao userDao1 = session1.getMapper(IUserDao.class);
        User user1 = userDao1.GetUser(1);
        session1.close();

        SqlSession session2 = factory.openSession();
        IUserDao userDao2 = session2.getMapper(IUserDao.class);
        User user2 = userDao2.GetUser(1);
        session2.close();
    }
}
