package operation;

import book.BookList;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 */
public class FindOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("search a book");
    }
}
