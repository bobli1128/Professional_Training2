package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.UserInfoService;
@SuppressWarnings("serial")
@WebServlet(value={"/show.Enroll"})
public class UserEnrollShowController extends HttpServlet {
private UserInfoService service=new UserInfoService();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setAttribute("list", service.getAllUser());
	} catch (Exception e) {
		e.printStackTrace();
	}
	req.getRequestDispatcher("/Center.jsp").forward(req, resp);
}

}
