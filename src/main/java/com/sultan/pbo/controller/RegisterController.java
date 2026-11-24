package com.sultan.pbo.controller;

import java.io.IOException;

import com.sultan.pbo.dto.UserRepository;
import com.sultan.pbo.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserRepository userRepository = new UserRepository();

        try {
            User user = userRepository.find(email, password);
            if (user != null) {
                throw new Exception("user already exist.");
            }

            userRepository.create(email, password);

            req.getSession().setAttribute("message", "berhasil mendaftarkan akun.");
            resp.sendRedirect("/login");
        } catch (Exception e) {
            req.getSession().setAttribute("errors", e.getMessage());
            resp.sendRedirect("/register");
        }
    }
}
