package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 * @description: add to last at default
 */
public class AddOperation implements IOperation{

    public void work(BookList bookList) {
        System.out.println("Add a new book!");
        System.out.println("Please add a book's name:");
        Scanner kb = new Scanner(System.in);
        String name = kb.nextLine();

        System.out.println("Please add a book's author:");
        String author = kb.nextLine();

        System.out.println("Please add a book's type:");
        String type = kb.nextLine();

        System.out.println("Please add a book's price:");
        int price = kb.nextInt();

        Book book = new Book(name, author, price, type, false);
        int listSize = bookList.getUsedSize();
        bookList.setBooks(listSize, book);

        bookList.setUsedSize(listSize+1);

        System.out.println("Added successfully!");;


    }
}
