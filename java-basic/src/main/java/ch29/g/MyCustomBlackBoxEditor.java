package ch29.g;

import java.beans.PropertyEditorSupport;

public class MyCustomBlackBoxEditor extends PropertyEditorSupport {

  // 스프링 IoC 컨테이너는 String을 ch29.g.BlackBox 클래스로 바꾸기 위해 이 메서드를 먼저 호출한다.
  // 그리고 getValue()를 호출하여 변환된 값을 꺼내 쓴다.
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    System.out.printf("MyCustomBlackBoxEditor.setAsText(%s)\n", text);

    // XML 파일에 입력한 문자열 값을 분석하여 
    String[] input = text.split(",");

    // 바꾸고자 하는 객체로 만든다.
    BlackBox blackBox = new BlackBox();
    blackBox.setMaker(input[0]);
    blackBox.setModel(input[1]);
    
    // 내부에 저장한다.
    this.setValue(blackBox);
  }

}
