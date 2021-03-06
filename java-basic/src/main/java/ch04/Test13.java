// 비트 연산자 : &, |, ^, ~
// => 용도 : 이미지 프로세싱 분야에서 사용
package ch04;

public class Test13 {
  public static void main(String[] args) {
    
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
    
    System.out.println(a & b); //0x42
                      // 0000 0000 0000 0000 0000 0000 0100 0010
    System.out.println(a | b); //0xee
                      // 0000 0000 0000 0000 0000 0000 1110 1110
   
    // ^ => 두 개의 비트가 다르면 결과는 1이다.
    System.out.println(a ^ b); // 0xac
                      // 0000 0000 0000 0000 0000 0000 1010 1100
    
    // ~ => 모든 비트를 반대 값으로 바꾼다.
    System.out.println(~a); //0xffffff35 = -203
                       // 1111 1111 1111 1111 1111 1111 0101 0011 = -203됨
                       // 0000 0000 0000 0000 0000 0000 1100 1011 = 203
    
    int data = 0b1111_1001_0111_1111;
    System.out.println(Integer.toBinaryString(data & 0b0000_1111_1100_0000));
    //  1111_1001_0111_1111
    //& 0000_1111_1100_0000
    //  0000_1001_0100_0000
    
    // 예) 그림의 한 픽셀에서 빨강 색을 제거하고 싶다.
    int pixel = 0x003f4478; // 각 바이트의 값이 '00RRGGBB'이라 가정하자.
    System.out.println(pixel & 0x0000ffff);
    // pixel = 00000000_00111111(R)_01000100(G)_01111000(B)
    //       & 00000000_00000000(R)_11111111(G)_11111111(B)
    //       = 00000000_00000000(R)_01000100(G)_01111000(B)
  }
}