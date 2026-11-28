package com.sultan.pbo.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.sultan.pbo.dto.ProductRepository;
import com.sultan.pbo.model.Product;
import com.sultan.pbo.utils.FlashSession;

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

        ProductRepository productRepository = new ProductRepository();
        ArrayList<Product> products = productRepository.findAll();

        String query = req.getParameter("q");
        if (query != null) {
            products.removeIf((t) -> {
                return (!t.getName().toLowerCase().contains(query.toLowerCase()) && !t.getNo().toLowerCase().contains(query.toLowerCase()));
            });
        }

        FlashSession.ParseFlashSession(req);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }

}
