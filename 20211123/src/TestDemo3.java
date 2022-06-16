/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-23
 * @description checked exception and unchecked exception
 */
// checked exception
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}
// unchecked exception
class MyException2 extends RuntimeException {
    public MyException2(String msg) {
        super(msg);
    }
}

public class TestDemo3 {
    // 只有在runtime的时候，才抛出异常，所以如果在signature里面没有写 throws... 那么不会画红线警告
    public static void func3(int x){
        /*
        * Exception in thread "main" MyException2: heihei
        * at TestDemo3.func3(TestDemo3.java:26)
        * at TestDemo3.main(TestDemo3.java:52)

        * Process finished with exit code 1*/
        // 此处的异常，是被JVM处理的，请见上面的运行结果
        if(x == 0) {
            // 调用func1(),异常处理成功，会打印dkddk
            throw new MyException2("heihei"); // 需要在MyException class里面提供构造方法
        }

    }

    public static void func1(int x) {
/*        // 默认情况下是受查异常，所以需要用try catch
        if(x == 0) {
            throw new MyException();
        }*/
        try{
            if(x == 0) {
                // 调用func1(),异常处理成功，会打印dkddk
                throw new MyException("dkddk"); // 需要在MyException class里面提供构造方法
            }
        }catch (MyException e) {
            e.printStackTrace();
        }
    }
    // 或者可以这么写
    public static void func2(int x) throws MyException {
        if(x == 0) {
            throw new MyException("dlldjf"); // add throws in the method signature
        }
    }
    public static void main(String[] args) {
        func3(0);
    }
}
