package bitcamp.app1;

import java.sql.Date;

public class Car {
  
  protected String model;
  protected String Maker;
  protected Boolean auto;
  protected int capacity;
  protected Date createDate;
  protected Engine engine;
  
  @Override
  public String toString() {
    return "Car [model=" + model + ", Maker=" + Maker + ", auto=" + auto + ", capacity=" + capacity
        + ", createDate=" + createDate + ", engine=" + engine + "]";
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public String getMaker() {
    return Maker;
  }
  public void setMaker(String maker) {
    Maker = maker;
  }
  public Boolean getAuto() {
    return auto;
  }
  public void setAuto(Boolean auto) {
    this.auto = auto;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public Engine getEngine() {
    return engine;
  }
  public void setEngine(Engine engine) {
    this.engine = engine;
  }
  
  
}
