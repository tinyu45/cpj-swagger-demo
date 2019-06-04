package com.tinuyu.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpj.swagger.annotation.APIs;
import com.alibaba.fastjson.JSONWriter;
import com.cpj.swagger.annotation.API;
import com.cpj.swagger.annotation.Param;

@APIs("/demo")
@WebServlet(name = "demoServlet", urlPatterns = { "/demo" })
@MultipartConfig()
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@API(value="", summary="示例1", method="GET",  parameters={
			@Param(name="username", description="用户名", type="string"),
			@Param(name="password", description="密码", type="string", format="password")
	})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());
		Map<String, String> user = new HashMap<String, String>();
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		user.put("username", username);
		user.put("password", pwd);
		writer.writeObject(user);
		writer.flush();
		writer.close();
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print(request.getParameter("username"));;
	}

}
