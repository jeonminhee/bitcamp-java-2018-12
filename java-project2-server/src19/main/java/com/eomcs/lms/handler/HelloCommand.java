package com.eomcs.lms.handler;

import com.eomcs.lms.context.Component;

@Component("/hello")
public class HelloCommand extends AbstractCommand {

  public HelloCommand() {
  }

  public void execute(Response response) throws Exception {
        response.println("안녕하세요!");
  }
}
