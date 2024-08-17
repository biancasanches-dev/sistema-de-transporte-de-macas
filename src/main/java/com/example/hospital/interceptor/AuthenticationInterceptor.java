package com.example.hospital.interceptor;

import com.example.hospital.model.usuario.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("user") : null;

        if (usuario == null) {
            response.sendRedirect("/login");
            return false;
        }
        request.setAttribute("user", usuario);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Usuario usuario = (Usuario) request.getAttribute("user");

        if (modelAndView != null && usuario != null) {
            modelAndView.addObject("usuario", usuario);
        }
    }

}
