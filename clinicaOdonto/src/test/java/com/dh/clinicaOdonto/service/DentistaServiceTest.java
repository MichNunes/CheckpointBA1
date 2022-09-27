package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import org.junit.jupiter.api.BeforeEach;

public class DentistaServiceTest {
    @BeforeEach
    void beforeRun() {

        DentistaEntity dentista001 = new DentistaEntity(null, 321);
        DentistaEntity dentista002 = new DentistaEntity(null, 654);
        DentistaEntity dentista003 = new DentistaEntity(null, 789);

    }

}
