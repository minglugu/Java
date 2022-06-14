package operation;

import book.Book;
import book.BookList;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 */
public class DisplayOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("Print books!");
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);// 书是类型，不能用bookList[i]; error
            System.out.println(book);
        }
    }
}
