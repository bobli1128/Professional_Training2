package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
@WebServlet(value={"/Check.Enroll"})
public class UserEnrollCheckController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JOptionPane.showMessageDialog(null, "用户已存在，请重新注册！");
		req.getRequestDispatcher("/Enroll.jsp").forward(req, resp);
	}
	}
