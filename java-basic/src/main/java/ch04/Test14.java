// 비트 이동 연산자 : >>, >>>, <<
package ch04;

public class Test14 {
  public static void main(String[] args) {
    // >> : 오른쪽으로 비트를 이동시킨다. 경계를 넘어가는 값은 버린다. 왼쪽 빈 자리는 부호비트로 채운다.
    int a = 0xca; // 202
    System.out.println(Integer.toHexString(a >> 4));//16진수로 출력, 0xc
    System.out.println(a >> 4);
    // 00000000_00000000_00000000_11001010
    // 00000000_00000000_00000000_00001100 | 1010
    
    System.out.println(Integer.toHexString(a >> 3)); // 0x19
    System.out.println(a >> 3);
    // 00000000_00000000_00000000_11001010
    //    00000_00000000_00000000_00011001_010
    // 00000000_00000000_00000000_00011001 | 010
    
    System.out.println(Integer.toHexString(a >> 2)); // 0x32
    System.out.println(a >> 2);
    
    System.out.println(Integer.toHexString(a >> 1)); // 0x65
    System.out.println(a >> 1);
    
    a = -202; // 11111111_11111111_11111111_00110110 = 0xff_ff_ff_36
    System.out.println(a >> 1);
              // 11111111_11111111_11111111_10011011됨 => 0xff_ff_ff_9b
    System.out.println(a >> 2); // -51
    System.out.println(a >> 3); // -26
    System.out.println(a >> 4); // -13 반올림 
    
    

  }
}