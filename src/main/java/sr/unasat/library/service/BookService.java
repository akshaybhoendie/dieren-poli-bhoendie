package sr.unasat.library.service;

import sr.unasat.library.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private static List<Book> bookList;
    private static Long bookId;

    public BookService() {
        if (bookList == null) {
            bookId = 0L;
            bookList = new ArrayList<>();
            bookList.add(new Book(++bookId, "Harry Potter", "Jk", "HP12345"));
            bookList.add(new Book(++bookId, "Book2", "author2", "B@456"));
            bookList.add(new Book(++bookId, "Book3", "author3", "B#@443"));
        }
    }

    public List<Book> findAll() {
        return bookList;
    }

    public Book add(Book book) {
        book.setId(++bookId);
        bookList.add(book);
        return book;
    }

    public Book getBook(Book book) {
        Book foundBook = new Book();

        for (int i = 0;i< bookList.size();i++) {
            if(bookList.get(i).getId() == book.getId())
            {
                foundBook = bookList.get(i);
                break;
            }
        }

        return foundBook;
    }

    public Book update(Book book) {
        for (int i = 0;i< bookList.size();i++) {
            if(bookList.get(i).getId() == book.getId())
            {
                bookList.set(i, book);
                break;
            }
        }

        return book;
    }

    public Book delete(Book book) {
       int index = -1;

        for (int i = 0;i< bookList.size();i++) {
            if(bookList.get(i).getId() == book.getId())
            {
                index = i;
                break;
            }
        }
        Book bookTemp = new Book();
        bookTemp = bookList.get(index);

        bookList.remove(index);
        return bookTemp;
    }

}

