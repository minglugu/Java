package demo2;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 */

abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void func();

    public String getName() {
        return this.name;
    }
}

class Admin extends User {

    public Admin(String name) {
        super(name);
    }

    @Override
    public void func() {

    }

}
public class Test2 {
    public static void main(String[] args) {
        User user = new Admin("bit");
        System.out.println(user.getName());
    }
}