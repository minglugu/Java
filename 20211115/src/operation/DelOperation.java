package operation;

import book.BookList;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since yyyy-mm-dd
 */
public class DelOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("Delete a book!");
    }
}
