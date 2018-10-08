package test.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.mapper.UserMapper;
import test.model.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    public static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws IOException {
        firstLevelCache();
//        secondLevelCache();
    }

    public static void init(String where) {
        String resource = where;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(resource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //从 XML 中构建 SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void firstLevelCache() {
        init("mybatis-config.xml");

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.selectByPrimaryKey(1);
        System.out.println(u);

        User u2 = mapper.selectByPrimaryKey(1);
        System.out.println(u2);
        session.close();

        System.out.println("==============session2==============");

        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User u3 = mapper2.selectByPrimaryKey(1);
        System.out.println(u3);
        session2.close();

    }

    public static void secondLevelCache() {
        init("mybatis-config2.xml");

        SqlSession session = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.selectByPrimaryKey(1);
        System.out.println(u);
        session.close();

        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User u3 = mapper2.selectByPrimaryKey(1);
        System.out.println(u3);
        session2.close();
    }
}
