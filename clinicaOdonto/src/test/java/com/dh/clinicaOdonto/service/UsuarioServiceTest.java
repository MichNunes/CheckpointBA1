package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;

public class UsuarioServiceTest {


    @BeforeEach
        void beforeRun() {

        UsuarioEntity usuario001 = new UsuarioEntity("Mlfdejesus", "123456a", "Leandro", "Fonseca");
        UsuarioEntity usuario002 = new UsuarioEntity("Mbdejesus", "123456b", "Barreto", "Matheus");
        UsuarioEntity usuario003 = new UsuarioEntity("Esdejesus", "123456c", "Oliveira", "Alexandre");

    }
}
