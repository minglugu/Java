package user;

import operation.*;

import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since yyyy-mm-dd
 */
public class NormalUser extends User {

    public NormalUser(String name) {
        super(name);
        iOperations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    public int menu() {
        System.out.println("===== A list for a normal user =====");
        System.out.println("Hello " + this.name + " welcome to the library!");
        System.out.println(" 1. Search a book\n 2. borrow a book\n 3. Return a book\n 0. Exit the program");
        System.out.println("====================================\n");

        Scanner kb = new Scanner(System.in);
        int choice = kb.nextInt();
        return choice;
    }
}
