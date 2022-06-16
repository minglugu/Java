/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-23
 * @description 自定义异常通常会继承自Exception或者RuntimeException
 *              继承自Exception的异常默认是受查异常（checked，会画红线警告）
 *              继承自RuntimeException的异常默认是非受查异常
 */
// 可以自定义异常,需要继承Throwable，比如果其下的RuntimeException
class NameException extends RuntimeException {
    public NameException(String msg) {
        super(msg);
    }
}
class PasswordException extends RuntimeException {
    public PasswordException(String msg) {
        super(msg);
    }
}

public class TestDemo2 {
    private static final String name = "bit";
    private static final String password = "123";

    public static void login(String name, String password) throws NameException, PasswordException{
        if(!TestDemo2.name.equals(name)) {
            //System.out.println("用户名错误！");
            throw new NameException("用户名错误！");
        }
        if(!TestDemo2.password.equals(password)) {
            //System.out.println("Password错误！");
            throw new PasswordException("密码错误！");
        }
    }

    public static void main(String[] args) {
        // main()可以这么写了
        try{
            login("bit", "1234");
        }catch (NameException | PasswordException e) {
            e.printStackTrace();
            System.out.println("用户名错误或密码错误！");
        }finally {
            System.out.println("finally执行了");
        }
    }
}
