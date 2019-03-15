package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 특정 패키지를 탐색하여 @Component 애노테이션이 붙은 클래스에 대해 인스턴스를 생성하게 만드는 애노테이션
@ComponentScan(basePackages = "com.eomcs.lms")

// .properties 파일을 로딩시키는 애노테이션
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")

// Spring의 트랜잭션 관리자를 활성화시킬 때 사용한다.
@EnableTransactionManagement

// mybatis에서 DAO 구현체를 자동 생성하게 할 때 사용한다.
@MapperScan("com.eomcs.lms.dao") // DAO 인터페이스가 있는 패키지를 지정한다.
public class AppConfig {
  
  @Autowired Environment env;
  
  @Bean
  public DataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(env.getProperty("jdbc.driver"));
    ds.setUrl(env.getProperty("jdbc.url"));
    ds.setUsername(env.getProperty("jdbc.username"));;
    ds.setPassword(env.getProperty("jdbc.password"));
    return ds;
  }
  
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  // SqlSessionFactory를 생성하는 메서드
  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext appCtx) throws Exception{
    // mybatis에서 SqlSessionFactory를 생성할 때 사용하라고 제공하는 객체이다.
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    
    // SqlSessionFactory 객체를 생성하는데 필요한 객체를 주입한다.
    factoryBean.setDataSource(dataSource);
    
    // 도메인 클래스의 별명을 자동으로 생성하도록 도메인 클래스가 들어있는 패키지를 지정한다.
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    
    // SQL 매퍼 파일이 있는 패키지를 등록한다.
    factoryBean.setMapperLocations(
        appCtx.getResources("classpath:/com/eomcs/lms/mapper/*"));
    
    return factoryBean.getObject();
  }

  
  /*
  // DAO 구현체 자동 생성하기1 : 
  // => mybatis에서 Spring과 함께 사용하라고 제공해주는 SqlSessionTemplate을 사용한다.
  // => @MapperScan 애노테이션을 사용하면 더 간단히 DAO 구현체를 자동생성 할 수 있다.
  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
  
  @Bean
  public BoardDao boardDao(SqlSessionTemplate sqlSessionTemplate) throws Exception {
    return sqlSessionTemplate.getMapper(BoardDao.class);
  }
  
  @Bean
  public MemberDao memberDao(SqlSessionTemplate sqlSessionTemplate) {
    return sqlSessionTemplate.getMapper(MemberDao.class);
  }
  
  @Bean
  public LessonDao lessonDao(SqlSessionTemplate sqlSessionTemplate) {
    return sqlSessionTemplate.getMapper(LessonDao.class);
  }
  
  @Bean
  public PhotoBoardDao photoBoardDao(SqlSessionTemplate sqlSessionTemplate) {
    return sqlSessionTemplate.getMapper(PhotoBoardDao.class);
  }
  
  @Bean
  public PhotoFileDao photoFileDao(SqlSessionTemplate sqlSessionTemplate) {
    return sqlSessionTemplate.getMapper(PhotoFileDao.class);
  }
*/
  
}
