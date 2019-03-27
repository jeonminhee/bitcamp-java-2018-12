// 31단계 : Tomcat 서버 적용하기
// => 웹 브라우저와의 통신을 전문적으로 담당할 서버를 도입한다.
// => ServerApp은 Tomcat에서 호출할 수 있도록 규칙에 따라 변경한다.
//
// 작업
// 1) 톰캣 서버 설치
//    => tomcat.apache.org 사이트에서 다운로드 받는다.
//    => ~/server/$톰캣홈

// 2) 자바 웹 프로젝트로 전환
//    => build.gradle 변경
//       - 'eclipse-wtp' 플러그인과 'war' 플러그인 추가한다.
//       - 'servlet-api' 라이브러리 추가 
//    => gradle eclipse 실행
//    => 프로젝트 리프레시
//       - 이클립스 웹 프로젝트 관련 디렉토리와 파일이 추가되었다.

// 3) ServerApp 변경
//    => 'Sevlet'이라는 규칙에 따라 클래스를 변경한다.
//    => 이 규칙에 따라 작성해야만 톰캣 서버가 호출해줄 것이다.
//    => ServletRequest와 ServletResponse 클래스를 제거한다.

// 4) Command 변경
//    => ServletRequest와 ServeltResponse를
//       servlet-api에서 제공하는 인터페이스로 바꾼다.

// 5) 자바 웹 배포 파일을 생성한다.
//    => '$ gradle build'

// 6) 웹 배포 파일을 톰캣 서버에 배치한다.
//    => $톰캣홈/webapps/*.war 파일을 둔다.
//    => 톰캣 서버를 다시 실행한다.
//       '$톰캣홈/bin$ ./shutdwon.sh'
//       '$톰캣홈/bin$ ./startup.sh'
//    => 톰캣 서버를 실행하면 .war 파일이 자동으로 풀리고 서버에 설정된다.

// 7) 웹 애플리케이션 실행하기
//    => http://localhost:8080/프로젝트명/board/list

// [웹 애플리케이션 자동 배포하기]
// 1) 이클립스에 톰캣 서버 경로를 설정한다.
//    - Window/Preference 메뉴 클릭
//    - Server 노드 선택
//    - Runtime Environments 노드 선택
//    - OS 에 설치한 톰캣 서버의 경로를 등록
// 2) 웹 애플리케이션을 테스트 할 때 사용할 톰캣 배치 폴더 생성
//    - 'Servers' 뷰 선택 
//    - New/Server 메뉴 클릭
//    - 이클립스에 등록된 서버 중에서 테스트 환경을 구축할 서버 선택
//    - 서버 이름 지정한 후 확인 클릭
//    - 이클립스에 서버 테스트 환경을 다룰 'Servers' 프로젝트가 추가된다.
//      물론 기존에 있다면 테스트 환경을 위한 설정 파일을 담은 폴더만 추가된다.
//    - 생성된 배치 폴더의 경로
//      이클립스워크스페이스폴더/.metadata/.plugins/org.eclipse.wst.server.core/
// 3) 웹 애플리케이션을 테스트 용으로 만든 배치 폴더에 배포한다.
//    - 'gradle build'를 실행할 필요가 없다.
//    - 'Servers' 뷰 선택
//    - 테스트 서버에 대해 컨텍스트 메뉴 출력 
//    - 'Add and Remove...' 메뉴 선택
//    - 배포할 웹 프로젝트를 선택하여 추가하다.
//    - 외부에서 별도로 톰캣 서버를 실행했다면 종료하라!
// 4) 테스트 용으로 설정한 톰캣 서버 실행
//    - 'Servers' 뷰 선택
//    - 테스트 서버에 대해 컨텍스트 메뉴 출력
//    - Start/Stop 실행
package com.eomcs.lms;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

@WebServlet("/*")
public class ServerApp implements Servlet {
  final static Logger logger = LogManager.getLogger(ServerApp.class);

  ApplicationContext iocContainer;

  RequestMappingHandlerMapping handlerMapping;

  ServletConfig config;

  @Override
  public void init(ServletConfig config) throws ServletException {

    this.config = config;

    logger.info("Spring IoC 컨테이너 준비");// 
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    printBeans();

    logger.info("RequestMappingHandlerMapping 객체 준비");
    handlerMapping = 
        (RequestMappingHandlerMapping) iocContainer.getBean(
            RequestMappingHandlerMapping.class);
  }

  @Override
  public void service(
      javax.servlet.ServletRequest req, 
      javax.servlet.ServletResponse res)
          throws ServletException, IOException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();

    String commandPath = request.getPathInfo();
    logger.info("클라이언트 요청: " + commandPath);

    RequestMappingHandler requestHandler = handlerMapping.get(commandPath);

    if (requestHandler == null) {
      out.println("실행할 수 없는 명령입니다.");
      return;
    }

    try {
      requestHandler.method.invoke(
          requestHandler.bean,
          request, response);

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public void destroy() {
  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }

  @Override
  public String getServletInfo() {
    return "Command 요청을 받아 처리하는 서블릿";
  }

  private void printBeans() {
    logger.debug("---------------------------------------------------"); 
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)", name, 
          iocContainer.getBean(name).getClass().getName()));
    }
    logger.debug("---------------------------------------------------"); 
  }

}


