// join() - 해당 스레드가 종료될 때까지 현재 스레드를 기다리게 한다.
package ch24.c;

public class Test04 {
  
  public static void main(String[] args) throws Exception {
    
  Thread t =  new Thread(){
      @Override
      public void run() {
        for(int i = 0; i < 1000; i++) {
          System.out.printf("스레드  ===> %d\n", i);
        }
        try {
        sleep(5000); // 현재 스레드를 5초 동안 Not Runnable 상태에 둔다.
        } catch (Exception e) {}
      }
    }; // 스레드 객체 생성 => 준비 상태
    t.start();// Running 상태
    
    // t 스레드가 dead 상태가 될 때까지 기다린다.
    t.join();
    
    for(int i = 0; i < 1000; i++) {
      System.out.printf("main() ~~~> %d\n", i);
    }
    // main() 메서드의 코드를 모두 실행했다고 해서 JVM이 종료되는것은 아니다.
    // 다른 스레드의 실행이 모두 끝나야만 JVM이 종료된다.
  }
}

