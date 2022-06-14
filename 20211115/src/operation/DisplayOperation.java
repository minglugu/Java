package operation;

import book.BookList;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 */
public class DisplayOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("Print books!");
    }
}
