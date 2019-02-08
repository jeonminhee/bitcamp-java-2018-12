package design_pattern.observer.after2;

public class SunroofCloseCarObserver extends AbstractCarObserver{

  @Override
  public void carStopped() {
    System.out.println("썬루프를 닫는다.");
  }

}
