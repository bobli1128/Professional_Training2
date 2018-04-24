package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.UserInfoService;
@SuppressWarnings("serial")
@WebServlet(value={"/UserEnrollApprovalShow.do"})
public class UserEnrollApprovalShowController extends HttpServlet {
private UserInfoService service=new UserInfoService();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setAttribute("user", service.getNoneAppUser());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println(service.getAlluser());
	req.getRequestDispatcher("/ManagePeople/EnrollApproval.jsp").forward(req, resp);
}

}
