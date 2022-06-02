/**
 * @author Minglu Gu
 * @version 1.0
 * @since 20211031
 */
class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return num1+num2;
    }
    public int sub() {
        return num1-num2;
    }
    public int mul() {
        return num1*num2;
    }

    public double dev() {
        return num1*1.0/num2;
    }

}

class MyValue {
    public int val;
}

public class TestDemo {

    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 1;

    }


    public static void swap(MyValue myV1,MyValue myV2) {
        int tmp = myV1.val;
        myV1.val = myV2.val;
        myV2.val = tmp;
    }

    public static void main2(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;

        MyValue myValue2 = new MyValue();
        myValue2.val = 20;

        swap(myValue1,myValue2);

        System.out.println(myValue1.val+" " +myValue2.val);
    }


    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(1);
        calculator.setNum2(2);
        System.out.println(calculator.add());
    }
}