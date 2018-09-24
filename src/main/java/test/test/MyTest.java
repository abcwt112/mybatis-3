package test.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.mapper.UserMapper;
import test.model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = new FileInputStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User u = mapper.selectByPrimaryKey(1);
            System.out.println(u);

            User u2 = mapper.selectByPrimaryKey(1);
            System.out.println(u2);

            SqlSession session2 = sqlSessionFactory.openSession();
            UserMapper mapper2 = session2.getMapper(UserMapper.class);
            User u3 = mapper2.selectByPrimaryKey(1);
            System.out.println(u3);
        } finally {
            session.close();
        }
    }
}
