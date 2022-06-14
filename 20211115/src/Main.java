import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 * @Description main class for using the library system
 */
public class Main {

    // return a user object
    public static User login() {
        System.out.println("Please enter your name: ");
        Scanner kb = new Scanner(System.in);
        String name = kb.nextLine();
        System.out.println("Please enter your id: 1 for admin, 0 for user");
        int choice = kb.nextInt();

        if (choice == 1) {
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login(); // 向上转型这个user引用，会引用哪个对象，就取决于你返回哪个对象。
        while(true) {
            int choice = user.menu(); // dynamic binding at runtime ->polymorphism
            // based on the choice, call the corresponding operation
            user.doWork(choice, bookList);
        }

    }

}
