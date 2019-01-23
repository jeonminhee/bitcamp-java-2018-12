package design_pattern.template_method;

public class Test01 {

  public static void main(String[] args) {
    
    // 예 : 스타크래프트에서 건물 짓기
    
    // 식당 짓기
    Restaurant u1 = new Restaurant();
    u1.setName("군인식당");
    u1.setArea(50);
    u1.setType(Unit.GENERAL_BUILDING);
    u1.build(); // 수퍼 클래스에서 상속 받은 메서드를 호출한다.
    
    System.out.println("----------------------------");
    
    // 훈련소 짓기
    TrainingCenter u2 = new TrainingCenter();
    u2.setName("훈련소");
    u2.setArea(500);
    u2.setType(Unit.GENERAL_BUILDING);
    u2.build();

  }

}
