package com.web;

import com.google.gson.Gson;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.test.UserServletTest;
import com.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User login = userService.login(new User(null, username, password, null));
        if (login==null)
        {
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或者密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }
        else {
            System.out.println("登陆成功");
            //保存用户登陆后的信息到Session域中
            req.getSession().setAttribute("user",login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

/*        User user =WebUtils.copyParamToBean(req.getParameterMap(),new User());*/

        //检查 验证码是否正确 ==这里先写死
        if(token!=null&&token.equalsIgnoreCase(code))
        {
            //检查用户名是否正确
            if (userService.existsUsername(username))
            {
                req.setAttribute("msg","用户名已存在！！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                //用户名不可用
                System.out.println("用户名["+username+"]已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }
            else
            {
                //可用，保存到数据库
                User user = new User(null,username,password,email);
                User user1 = userService.registUser(user);
                req.getSession().setAttribute("user",user1);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }

        }
        else {
            req.setAttribute("msg","验证码错误！！！！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            //不正确，跳回注册页面
            System.out.println("验证码["+code+"]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //销毁Session中用户的登陆的信息（或者销毁Session）
        req.getSession().invalidate();
        //重定向到首页（或登陆页面）
        resp.sendRedirect(req.getContextPath());
    }
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        Map<String,Object> map = new HashMap<>();
        map.put("existsUsername",existsUsername);
        Gson gson =new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }

}
