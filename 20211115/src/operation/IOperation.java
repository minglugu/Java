package operation;

import book.BookList;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 * @Interface IOperation can use all CRUD objects
 */
public interface IOperation {
    void work(BookList bookList);

}
