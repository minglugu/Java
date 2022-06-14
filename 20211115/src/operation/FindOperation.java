package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 */
public class FindOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("search a book\nPlease enter a book name:");
        Scanner kb = new Scanner(System.in);
        String bookName = kb.nextLine();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);
            if(bookName.equals(book.getName())) {
                System.out.println("Book is found. Information is as follows:\n" + book);
                return;
            }
        }
        System.out.println("Book is not found");
    }
}
