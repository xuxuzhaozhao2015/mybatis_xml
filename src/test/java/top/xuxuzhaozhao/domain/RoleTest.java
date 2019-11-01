package top.xuxuzhaozhao.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xuxuzhaozhao.dao.IRoleDao;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    InputStream inputStream;
    SqlSession session;
    IRoleDao roleDao;

    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        session = factory.openSession();

        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public void TestFindAll() {
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }
}
