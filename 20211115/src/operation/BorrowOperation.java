package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 */
public class BorrowOperation implements IOperation{
    public void work(BookList bookList) {
        System.out.println("Borrowed a book!\nPlease enter a book name:");

        Scanner kb = new Scanner(System.in);
        String bookName = kb.nextLine();
        int size = bookList.getUsedSize();
        int i = 0;
        for (; i < size; i++) {
            Book book = bookList.getPos(i);
            if(bookName.equals(book.getName())) {
                book.setBorrowed(true);
                System.out.println("Book is successfully borrowed!");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book is not found!");
    }
}
