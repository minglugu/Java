package user;

import operation.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since yyyy-mm-dd
 */
public class Admin extends User{

    public Admin(String name) {
        super(name);
        iOperations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }

    // print the menu for administrator
    public int menu() {
        System.out.println("===== A list for administrator =====");
        System.out.println("Hello " + this.name + " welcome to the library!");
        System.out.println(" 1. Search a book\n 2. Add a new book\n 3. Delete a book\n " +
                            "4. Display books\n 0. Exit the program");
        System.out.println("====================================\n");

        Scanner kb = new Scanner(System.in);
        int choice = kb.nextInt();
        return choice;
    }
}
