package ch29.h;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// Spring IoC Container에 객체 생성 완료를 보고 받고 싶다면
// BeanPostProcessor 규칙에 따라 Class를 정의한 후
// Spring IoC Contaioner에 등록하라!
// => 옵저버 디자인패턴이 적용된 대표적인 예이다.
//
// BeanPostProcessor
// => Spring IoC Container는 Bean을 생성하고 세터를 모두 호출한 후
//    이 구현체에게 보고한다.
//
public class MyBeanPostProcessor implements BeanPostProcessor {
  
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("MyBeanPostProcessor.postProcessAfterInitialization()");
    System.out.printf("    => %s : %s\n", beanName, bean.toString());
    return bean;
  }
  
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization()");
    System.out.printf("    => %s : %s\n", beanName,  bean.toString());
    return bean;
  }
  
  
}
