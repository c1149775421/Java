package com.atguigu.web;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数 pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2.调用BookService.page(pageNo,pageSize) 返回Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");

        //3.保存Page对象到Requset域中
        req.setAttribute("page",page);

        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    /**
     * 添加图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //1.获取请求的参数=>封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2.调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3.跳转到图书列表页面  /manager/bookServlet?action=list
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        //注意：请求转发会有重复提交表单的bug，使用重定向解决这个问题
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    /**
     * 删除图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数，id编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2.调用bookService.deleteBookById() 删除图书
        bookService.deleteBookById(id);
        System.out.println("图书["+id+"]删除成功");
        //3.重定向回到图书列表管理页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    /**
     * 修改图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数，封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2.调用bookService.updateBook(book) 修改图书
        bookService.updateBook(book);
        System.out.println("成功修改为："+book);
        //3.重定向回到图书列表管理页面(工程名+/manager/bookServlet?action=list)
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    /**
     * 查询图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数，图书编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2.调用bookService.queryBookById() 查询图书
        Book book = bookService.queryBookById(id);
        System.out.println("查询修改值："+book);
        //3.保存图书到Request域中
        req.setAttribute("book",book);
        //4.请求转发到pages/manager/book_edit.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    /**
     * 查询全部图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到Request域中
        req.setAttribute("books",books);
        //3.请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

}
