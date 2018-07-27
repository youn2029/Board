package kr.or.ddit.mybatis;

import java.io.IOException;
import java.io.InputStream;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static{
		
		try {
			
			String resource = "kr/or/ddit/mybatis/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
