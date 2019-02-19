// 스레드 우선 순위
package ch24.b;

public class Test07 {

  public static void main(String[] args) {

    // 스레드의 우선 순위는 1 ~ 10이다.
    // 기본 우선순위는 5이다.
    //
    Thread mainThread = Thread.currentThread();
    System.out.println(mainThread.getPriority());

    System.out.printf("우선순위 범위 : %d ~ %d\n", 
        Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);
  }
}
// JVM의 스레드 계층도:
// system(TG)
//   ==> Reference Handler(T)
//   ==> Finalizer(T)
//   ==> Signal Dispatcher(T)
//   main(TG)
//     ==> main(T) : main() 메서드를 호출한다.
//   InnocuousThreadGroup(TG)
//     ==> Common-Cleaner(T)
