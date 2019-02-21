package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {

  void ContextInitialize(Map<String, Object> context) throws ApplicationContextException;
  void ContextDestroyed(Map<String, Object> context) throws ApplicationContextException;
}
