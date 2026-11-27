package com.sultan.pbo.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class FlashSession {
    public static void ParseFlashSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String errors = null;
        if (session != null) {
            errors = (String) session.getAttribute("errors");
            if (errors != null) {
                session.removeAttribute("errors");
            }
        }
        req.setAttribute("errors", errors);
    }
}
