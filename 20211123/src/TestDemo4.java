/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-23
 * @exercises of exception
 * */

class MyException3 extends Exception{
    public MyException3(String msg) {
        super(msg);
    }
}

public class TestDemo4 {
    public static void main1(String[] args) throws Exception {
        try{
            throw new MyException3("异常的处理");
        } catch (MyException3 e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally执行了");
        }
    }

    // 使用while循环建立类似”恢复模型“的异常处理行为，它将不断重复，知道异常不再抛出
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            try {
                if (i < 10) {
                    throw new MyException3("异常的处理");
                }
            }catch (MyException3 e) {
                e.printStackTrace();
                System.out.println("尝试连接网络第"+i+"次");
                i++;
            }
        }
        System.out.println("终于有网了！");
    }
}
