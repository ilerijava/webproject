package com.tutev.personelozluk.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.service.LoginServis;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginServis loginServis = new LoginServis();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String kullaniciAdi = request.getParameter("kullaniciAdi");
		String sifre = request.getParameter("sifre");

		Kisi kisi = loginServis.login(kullaniciAdi, sifre);

		if (kisi != null) {
			request.getSession().setAttribute("kisi", kisi);
			response.sendRedirect("index.jsp");
		} else {
			request.getSession().setAttribute("kisi", null);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
