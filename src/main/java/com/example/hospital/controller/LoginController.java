package com.example.hospital.controller;

import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nome, @RequestParam String senha, HttpSession session) {
        if (usuarioService.autenticarUsuario(nome, senha)) {
            Usuario user = usuarioService.getUsuarioPorNome(nome);
            session.setAttribute( "user", user);

            return "redirect:/";
        } else {
            return "loginPage";
        }
    }
}
