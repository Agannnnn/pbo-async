package com.sultan.pbo.controller;

import com.sultan.pbo.dto.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("loggedIn") == null || !session.getAttribute("loggedIn").equals(true)) {
            resp.sendRedirect("/login");
            return;
        }

        String no = req.getParameter("no");
        if (no == null) {
            req.getSession().setAttribute("errors", "no cannot be empty.");
            resp.sendRedirect("/");
            return;
        }

        String name = req.getParameter("name");
        if (name == null) {
            req.getSession().setAttribute("errors", "name cannot be empty.");
            resp.sendRedirect("/");
            return;
        }

        int qty = 0;
        try {
            qty = Integer.parseInt(req.getParameter("qty"));
        } catch (NumberFormatException e) {
            req.getSession().setAttribute("errors", "invalid qty.");
            resp.sendRedirect("/");
            return;
        }

        double price = 0;
        try {
            price = Double.parseDouble(req.getParameter("price"));
        } catch (NumberFormatException e) {
            req.getSession().setAttribute("errors", "invalid price.");
            resp.sendRedirect("/");
            return;
        }

        try {
            ProductRepository productRepository = new ProductRepository();
            productRepository.create(no, name, qty, price);
        } catch (Exception e) {
            req.getSession().setAttribute("errors", "unable to save new product.");
        } finally {
            resp.sendRedirect("/");
        }
    }

}
