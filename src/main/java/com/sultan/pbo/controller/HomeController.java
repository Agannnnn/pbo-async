package com.sultan.pbo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * HomeController
 */
@WebServlet(urlPatterns = "/")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("loggedIn") == null || !session.getAttribute("loggedIn").equals(true)) {
            resp.sendRedirect("/login");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }

}
