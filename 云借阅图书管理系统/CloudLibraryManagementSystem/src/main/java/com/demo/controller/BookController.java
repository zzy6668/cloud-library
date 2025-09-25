package com.demo.controller;

import com.demo.domain.Book;
import com.demo.domain.User;
import com.demo.entity.PageResult;
import com.demo.entity.Result;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.controller
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  22:01
 * @Description: TODO
 * @Version: 1.0
 */

/**
 * 图书信息Controller
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    // 注入BookService对象
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 查询最新上架的图书
     */

    @RequestMapping("/selectNewBooks")
    public ModelAndView selectNewBooks() {

        // 查询最新上架的5个图书信息 当前页码为1 页码可显示5本书
        Integer pageNum = 1;
        Integer pageSize = 5;

        // 封装查询到的数据
        PageResult pageResult = bookService.selectNewBooks(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();

        // 设置查询到的数据
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.setViewName("books_new");

        return modelAndView;

    }

    /**
     * 根据id查询图书信息
     *
     * @param id id
     * @return {@link Result}<{@link Book}>
     */
    @ResponseBody
    @RequestMapping(value = "/findById")
    public Result<Book> findBookById(String id) {
        try {
            Book book = bookService.findBookById(id);
            System.out.println(book);
            if (book != null) {
                return new Result<Book>(true, "查询图书成功!", book);
            }
            return new Result<>(false, "查询图书失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, "查询图书失败!");

        }

    }

    /**
     * 借阅图书
     *
     * @param book    借阅的书
     * @param session
     * @return {@link Result}
     */
    @ResponseBody
    @RequestMapping(value = "/borrowBook")
    public Result borrowBook(Book book, HttpSession session) {

        // 获取当前登录的用户姓名
        User name = (User) session.getAttribute("user_session");
        System.out.println(name);
        book.setBorrower(name.getName());

        try {
            // 根据图书的id和用户进行图书借阅
            Integer integer = bookService.borrowBook(book);
            System.out.println(integer);
            if (integer > 0) {
                return new Result(true, "借阅图书成功!");
            }
            return new Result(false, "借阅图书失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "借阅图书失败!");

        }

    }


    /**
     * 查询图书
     *
     * @param book     封装书的结果集
     * @param pageNum  当前页面
     * @param pageSize 页面长度
     * @param request  请求
     * @return {@link ModelAndView}
     */

    @RequestMapping(value = "/search")
    public ModelAndView search(Book book, Integer pageNum, Integer pageSize, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();


        // 判断页码是否为空
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 15;
        }

        // 封装到PageResult
        PageResult pageResult = bookService.search(book, pageNum, pageSize);

        // 跳转的页面
        modelAndView.setViewName("books");

        // 将查询到数据放在ModelAndView
        modelAndView.addObject("pageResult", pageResult);

        // 将查询的参数返回到页面 用于到查询的输入框中
        modelAndView.addObject("search", book);

        // 将当前页码返回到页面 用于显示分页插件的显示
        modelAndView.addObject("pageNum", pageNum);


        // 将当前查询的控制器路径返回到页面 页码变化时继续向该路径发送请求
        modelAndView.addObject("gourl", request.getRequestURI());

        return modelAndView;
    }

    /**
     * 添加图书
     *
     * @param book 书
     * @return {@link Result}
     */
    @ResponseBody
    @RequestMapping(value = "/addBook")
    public Result addBook(Book book) {

        try {
            Integer addBook = bookService.addBook(book);
            if (addBook > 0) {
                return new Result(true, "添加图书成功!");
            }
            return new Result(false, "添加图书失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加图书失败!");

        }
    }

    /**
     * 编辑图书
     *
     * @param book 书
     * @return {@link Result}
     */
    @ResponseBody
    @RequestMapping(value = "/editBook")
    public Result editBook(Book book) {
        try {
            Integer editBook = bookService.editBook(book);
            if (editBook > 0) {
                return new Result(true, "编辑图书成功!");
            }
            return new Result(false, "编辑图书失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑图书失败!");

        }
    }

    /**
     * 查询借阅
     *
     * @param book     书
     * @param pageNum  页码
     * @param pageSize 页面长度
     * @param request  请求对象
     * @return {@link ModelAndView}
     */
    @ResponseBody
    @RequestMapping(value = "/searchBorrowed")
    public ModelAndView searchBorrowed(Book book, Integer pageNum, Integer pageSize, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        // 判断页码的长度是否为空
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 获取当前的登录对象
        User user = (User) request.getSession().getAttribute("user_session");

        // 封装查询到的数据
        PageResult pageResult = bookService.searchBorrowed(book, user, pageNum, pageSize);

        // 设置跳转jsp
        modelAndView.setViewName("book_borrowed");

        // 将查询的数据存放到modelAndView
        modelAndView.addObject("pageResult", pageResult);

        // 将查询的参数返回到页面 用于回显到查询的输入框
        modelAndView.addObject("search", book);

        // 将当前页码返回到页面 用于分页插件显示到页面
        modelAndView.addObject("pageNum", pageNum);

        // 将当前查询到控制器路径（也就是映射地址）返回到页面 页码变化的时候继续向该路径发送请求
        modelAndView.addObject("gourl", request.getRequestURI());

        return modelAndView;


    }

    @ResponseBody
    @RequestMapping(value = "/returnBook")
    public Result returnBook(String id, HttpSession session) {

        try {
            // 获取当前的登录用户
            User user = (User) session.getAttribute("user_session");

            // 判断是否为同一个人
            Boolean flag = bookService.returnBook(id, user);

            if (flag) {

                // 等于true 是同一个人
                return new Result(true, "归还图书成功,请去图书借阅中心,等待管理员确认归还!");
            }

            return new Result(false, "归还图书失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "归还图书失败!");

        }

    }

    /**
     * 图书确认归还（管理员操作）
     *
     * @return {@link Result}
     */
    @ResponseBody
    @RequestMapping(value = "/returnConfirm")
    public Result returnConfirm(String id) {

        // 获取当前归还图书的id
        Integer i = bookService.returnConfirm(id);

        try {
            if (i > 0) {
                return new Result(true, "图书归还成功!");
            }
            return new Result(true, "图书归还失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "图书归还失败!");

        }

    }

}
