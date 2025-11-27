package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) req).getRequestURI();

        HttpSession session = ((HttpServletRequest) req).getSession();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String path = ((HttpServletRequest) req).getServletPath();

        if (requestURI.startsWith(request.getContextPath() + "/css") ||
                requestURI.startsWith(request.getContextPath() + "/js") ||
                requestURI.startsWith(request.getContextPath() + "/images") ||
                requestURI.endsWith(".jpg")) {
            chain.doFilter(req, res);
            return;
        }

        User user = (User) session.getAttribute("user");

        if (path.equals("/main") || path.equals("/login") || path.equals("/register")) {
            chain.doFilter(req,res);
            return;
        }

        if (user == null) {
            response.sendRedirect(((HttpServletRequest) req).getContextPath() + "/register");
            return;
        }

        chain.doFilter(req,res);
    }
}
