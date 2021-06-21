package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "hello", "world", new BigDecimal(200), 110, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"hi","world",new BigDecimal(100),110,10,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println("总记录数："+bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println("总记录数："+bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItems() {
        for(Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageItemsByPrice() {
        for(Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)){
            System.out.println(book);
        }
    }

}