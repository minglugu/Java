package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since yyyy-mm-dd
 */
public class DelOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("Delete a book!\nPlease enter the book name");
        //1. find the book index
        Scanner kb = new Scanner(System.in);
        String bookName = kb.nextLine();
        int usedSize = bookList.getUsedSize();
        int index = 0;
        int i = 0;
        for (; i < usedSize; i++) {
            Book book = bookList.getPos(i);
            // 2. found the book' index
            if(bookName.equals(book.getName())) {
                index = i;
                break;
            }
        }
        if (i >= usedSize) {
            System.out.println("Book is not found");
            return;
        }
        for (int j = 0; j < usedSize-1; j++) {
            // error: bookList[i] = bookList[i + 1];
            Book bookNext = bookList.getPos(j+1);
            bookList.setBooks(j, bookNext);
        }
        bookList.setBooks(usedSize, null); // 防止内存泄露
        bookList.setUsedSize(usedSize-1);
        System.out.println("Book is deleted");
    }
}
