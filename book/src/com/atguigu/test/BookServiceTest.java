package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook(){
        bookService.addBook(new Book(null,"国歌","乐师",new BigDecimal(100),1000,1,null));
    }

    @Test
    public void deleteBookById(){
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook(){
        bookService.updateBook(new Book(22,"国歌","乐府",new BigDecimal(99),999,1,null));
    }

    @Test
    public void queryBookById(){
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks(){
        for (Book queryBook : bookService.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}