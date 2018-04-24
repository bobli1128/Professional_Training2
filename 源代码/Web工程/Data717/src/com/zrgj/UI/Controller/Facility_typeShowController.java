package com.zrgj.UI.Controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.Facility_typeService;


@SuppressWarnings("serial")
@WebServlet(value={"/Facility_type/show.do"})
public class Facility_typeShowController extends HttpServlet{
	private  Facility_typeService service=new  Facility_typeService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", service.getAllFacility_type());
		req.getRequestDispatcher("/show.jsp").forward(req, resp);
	}
}
