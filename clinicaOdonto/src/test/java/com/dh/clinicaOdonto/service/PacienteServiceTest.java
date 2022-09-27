package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.PacienteEntity;
import org.junit.jupiter.api.BeforeEach;

public class PacienteServiceTest {

    @BeforeEach
    void beforeRun() {

        PacienteEntity paciente001 = new PacienteEntity(null, "123456");
        PacienteEntity paciente002 = new PacienteEntity(null, "741258");
        PacienteEntity paciente003 = new PacienteEntity(null, "987654");
    }
}
