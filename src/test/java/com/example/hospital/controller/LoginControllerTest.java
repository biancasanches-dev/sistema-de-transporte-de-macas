package com.example.hospital.controller;

import com.example.hospital.model.usuario.Maqueiro;
import com.example.hospital.model.usuario.Usuario;
import com.example.hospital.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebFluxTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UsuarioServiceImpl usuarioService;

    @Test
    public void testLoginSuccess() {
        Usuario mockUsuario = new Maqueiro();
        mockUsuario.setNome("user");
        mockUsuario.setSenha("password");

        when(usuarioService.autenticarUsuario(anyString(), anyString())).thenReturn(true);
        when(usuarioService.getUsuarioPorNome(anyString())).thenReturn(mockUsuario);

        webTestClient.post()
                .uri("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("nome=user&senha=password")
                .exchange()
                .expectStatus().is3xxRedirection()
                .expectHeader().valueEquals("Location", "/dashboard");
    }

    @Test
    public void testLoginFailure() {
        when(usuarioService.autenticarUsuario(anyString(), anyString())).thenReturn(false);

        webTestClient.post()
                .uri("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("nome=invalid&senha=invalid")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("loginPage");
    }
}
