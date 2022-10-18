import java.util.ArrayList;

/**
 * Date: 2022/2/27
 */
public enum TestEnum {

    RED("red",1),BLACK("black",3),GREEN("green",8),
    WHITE("white",2);

    public String color;
    public int ordinal;

    TestEnum(String color,int ordinal) {
        //super();
        this.color = color;
        this.ordinal = ordinal;
    }

   /*TestEnum() {

    }*/

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(20);
    }


    public static void main3(String[] args) {
        //把字符串 变成对应的枚举对象
        TestEnum testEnum =  TestEnum.valueOf("RED");
        System.out.println(testEnum);

        System.out.println(RED.compareTo(GREEN));

        System.out.println(BLACK.compareTo(RED));
    }


    public static void main2(String[] args) {
        TestEnum[] testEnums = TestEnum.values();
        for (int i = 0; i < testEnums.length; i++) {
            System.out.println(testEnums[i]+" ->" + testEnums[i].ordinal());
        }
    }

    public static void main1(String[] args) {
        TestEnum testEnum2 = TestEnum.BLACK;
        switch (testEnum2) {
            case RED:
                System.out.println("red");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case WHITE:
                System.out.println("WHITE");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
            default:
                break;
        }
    }
}