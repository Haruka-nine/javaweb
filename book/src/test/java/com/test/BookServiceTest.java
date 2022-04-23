package com.test;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥在手，天下我有！","1125",new BigDecimal(10000000),100000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);

    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"社会积极","1125",new BigDecimal(999),100000,0,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void page()
    {
        Page<Book> page = bookService.page(1, Page.PAGE_SIZE);
        System.out.println(page);
    }
    @Test
    public void pageByPrice()
    {
        Page<Book> page = bookService.pageByPrice(1, Page.PAGE_SIZE,10,50);
        System.out.println(page);
    }

}