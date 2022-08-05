@Builder
@Getter
public class Test{
    @Builder.Default
    private Integer number = 2;
    
    @Builder.Default
    private String str = "default";
}

public class TestMain{
   @Test
   void test1(){
       Test test1 = Test.builder()
                       .str("test")
                       .build();
       System.out.println("test1 output : " + test1.getNumber() + " " + test1.getStr());
       Test test2 = Test.builder()
                       .number(1)
                       .build();
       System.out.println("test2 output : " + test2.getNumber() + " " + test2.getStr());
   }
}