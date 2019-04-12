package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class WebApplicationInitializerImpl3 
  extends AbstractDispatcherServletInitializer {
  
  @Override
  protected WebApplicationContext createRootApplicationContext() {
      return null;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    XmlWebApplicationContext iocContainer = new XmlWebApplicationContext();
    iocContainer.setConfigLocation("/WEB-INF/app8-servlet.xml");
        
      return iocContainer;
  }
  
  @Override
  protected String[] getServletMappings() {
      return new String[] { "/app8/*" };
  }
  
  @Override
  protected String getServletName() {
    return "app8";
  }
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("WebApplicationInitializerImpl3.onStartup(). . . 호출됨!");
    super.onStartup(servletContext);
  }

}
