package com.dh.clinicaOdonto;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.entity.UsuarioRoles;
import com.dh.clinicaOdonto.service.Impl.UsuarioServiceImpl;
import com.dh.clinicaOdonto.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ClinicaOdontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UsuarioService usuarioService){
		return args -> {
			usuarioService.salvarRole(new UsuarioRoles(null, "ROLE_USER"));
			usuarioService.salvarRole(new UsuarioRoles(null, "ROLE_ADMIN"));

			usuarioService.salvarUsuario(new UsuarioEntity("admin", "admin", "Administrador","Clinica Odonto"));

			usuarioService.addRoleToUsuario("admin", "ROLE_USER");
			usuarioService.addRoleToUsuario("admin", "ROLE_ADMIN");
		};
	}

}
