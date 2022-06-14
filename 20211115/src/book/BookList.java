package book;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 * @description: CRUD is written as individual classes in the operation package
 */
public class BookList {
    private Book[] books = new Book[10];
    private int usedSize;
    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 15, "小说", false);
        books[1] = new Book("西游记", "吴承恩", 15, "小说", false);
        books[2] = new Book("水浒传", "施耐庵", 15, "小说", false);
        this.usedSize = 3;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
    /**
     * get a book at index pos
     * @param pos
     * @return book
     */
    public Book getPos(int pos) {
        // check if pos is valid
        return this.books[pos];
    }

    /**
     * set a book at index pos to add a book
     * @param pos
     * @param book
     */
    public void setBooks(int pos, Book book) {
        books[pos] = book;
    }
}
