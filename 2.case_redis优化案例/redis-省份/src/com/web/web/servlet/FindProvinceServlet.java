package com.web.web.servlet;

import com.web.service.ProvinceService;
import com.web.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

         /*//1.调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();

        //2.序列化list为JSON
        ObjectMapper mapper = new ObjectMapper();
        String JSON = mapper.writeValueAsString(list);
        System.out.println(JSON);*/

         //1.调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        //响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
