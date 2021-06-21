package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        //调用userService.existsUsername();判断用户名是否可用
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成为Map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        //创建Gson对象
        Gson gson = new Gson();
        //转换为json字符串
        String json = gson.toJson(resultMap);
        //通过输出流响应给客户端
        resp.getWriter().write(json);
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁Session中的用户登录信息，或者销毁Session
        req.getSession().invalidate();
        //2.重定向到首页，或者登录页面
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用userService.login()处理登录业务
        User loginUser = userService.login(new User(null, username, password, null));
        //3.判断是否登录成功
        if(loginUser == null){
            System.out.println("用户["+username+"]登录失败");
            //把错误信息和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误!");
            req.setAttribute("username",username);

            //请求转发回到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("用户["+username+"]登录成功");
            //保存用户登录信息到Session域中
            req.getSession().setAttribute("user",loginUser);
            req.getSession().setAttribute("username",username);
            //请求转发到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * 注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        User user = new User();
//        WebUtils.copyParamToBean(req.getParameterMap(),user);
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2.检查验证码是否正确  (目前先把验证码固定为abcde，因为还不知道怎么自动生成)
        if(token != null && token.equalsIgnoreCase(code)){
            //3.检查用户名是否可用
            if(userService.existsUsername(username)){
                //把回显信息，保存到Request域中
                req.setAttribute("msg","用户名已存在!");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                System.out.println("用户名["+username+"]已存在");
                //用户名不可用，跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                System.out.println("用户["+username+"]注册成功");
                //用户名可用，调用Service保存到数据库
                userService.registUser(new User(null,username,password,email));
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            //把回显信息，保存到Request域中
            req.setAttribute("msg","验证码错误!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码["+code+"]错误");
            //请求转发，跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}
