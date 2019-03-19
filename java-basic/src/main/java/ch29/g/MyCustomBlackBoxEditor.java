package ch29.g;

import java.beans.PropertyEditorSupport;

public class MyCustomBlackBoxEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    System.out.printf("MyCustomBlackBoxEditor.setAsText(%s)\n", text);
    BlackBox blackBox = new BlackBox();
    String[] input = text.split(",");
    blackBox.setMaker(input[0]);
    blackBox.setModel(input[1]);
    
    this.setValue(blackBox);
  }
  
}
