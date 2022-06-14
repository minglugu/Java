package user;

import book.Book;
import book.BookList;
import operation.IOperation;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since yyyy-mm-dd
 */
public abstract class User {
    protected String name;

    protected IOperation[] iOperations;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doWork(int choice, BookList bookList) {
        iOperations[choice].work(bookList);
    }

}
