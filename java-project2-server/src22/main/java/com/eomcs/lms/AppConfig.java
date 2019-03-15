package com.eomcs.lms;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactory;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

// SqlSessionFactoryProxy 객체를 만들어 주는 팩토리 역할을 수행하는 메서드
@ComponentScan(basePackages = "com.eomcs.lms")
public class AppConfig {

  @Bean
  public BoardDao boardDao(DaoFactory daoFactory) {
    return daoFactory.create(BoardDao.class);
  }
  
  @Bean
  public MemberDao memberDao(DaoFactory daoFactory) {
    return daoFactory.create(MemberDao.class);
  }
  
  @Bean
  public LessonDao lessonDao(DaoFactory daoFactory) {
    return daoFactory.create(LessonDao.class);
  }
  
  @Bean
  public PhotoBoardDao photoBoardDao(DaoFactory daoFactory) {
    return daoFactory.create(PhotoBoardDao.class);
  }
  
  @Bean
  public PhotoFileDao photoFileDao(DaoFactory daoFactory) {
    return daoFactory.create(PhotoFileDao.class);
  }
  
  @Bean
  public SqlSessionFactoryProxy sqlSessionFactoryProxy() throws Exception {
    return new SqlSessionFactoryProxy(
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml")));
  }

  // TransactionManager 객체를 만들어주는 메서드
  @Bean
  public TransactionManager tranactionManager(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    return new TransactionManager(sqlSessionFactoryProxy);
  }

  // DaoFactory 객체를 만들어주는 메서드
  @Bean
  public DaoFactory daoFactory(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    return new DaoFactory(sqlSessionFactoryProxy);
  }
  
}
