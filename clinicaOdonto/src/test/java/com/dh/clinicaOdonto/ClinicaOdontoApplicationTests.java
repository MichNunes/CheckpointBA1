//package com.dh.clinicaOdonto;
//
//import com.dh.clinicaOdonto.controller.EnderecoController;
//import com.dh.clinicaOdonto.entity.DentistaEntity;
//import com.dh.clinicaOdonto.entity.EnderecoEntity;
//import com.dh.clinicaOdonto.entity.PacienteEntity;
//import com.dh.clinicaOdonto.entity.UsuarioEntity;
//import com.dh.clinicaOdonto.repository.IAgendaRepository;
//import com.dh.clinicaOdonto.repository.IDentistaRepository;
//import com.dh.clinicaOdonto.service.AgendaService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(EnderecoController.class)
//@SpringBootTest
//@AutoConfigureMockMvc(addFilters = false)
//
//class ClinicaOdontoApplicationTests {
//	@Autowired
//	private MockMvc mockMVC;
//	@Test
//	void listarEnderecosAPI() throws Exception {
//		mockMVC.perform(MockMvcRequestBuilders.get("/endereco")
//				.accept(MediaType.APPLICATION_JSON))
//				.andDo(MockMvcResultHandlers.print())
//				.andExpect(MockMvcResultMatchers.status().isOk());
//
//	}
//
//
////	@Test
////	void testInsertAgenda(){
////		IAgendaRepository agendaRepository;
////		AgendaService agendaService = new AgendaService(agendaRepository);
////	}
//
//
////	public void agendaVaziaTeste(){
////		AgendaService agenda = new AgendaService();
////
////		 agenda.listarConsultas();
////
////
////		Assertions.assertEquals(null,);
////	}
//}
