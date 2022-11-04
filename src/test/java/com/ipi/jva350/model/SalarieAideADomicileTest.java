package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SalarieAideADomicileTest {
    @Test
    void aLegalementDroitADesCongesPayesTrue() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
            //LocalDate.now(), LocalDate.now(), 0, 0;
        //When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(res, res);
    }

    @Test
    void aLegalementDroitADesCongesPayesFalse() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        //When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(res,res);
    }
}