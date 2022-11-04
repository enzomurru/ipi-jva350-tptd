package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SalarieAideADomicileTest {
    @Test
    void aLegalementDroitADesCongesPayesMoinsDe10() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne",
                LocalDate.now(), LocalDate.now(), 0, 0, 5, 1, 0);
        //When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false, res);
    }
    @Test
    void aLegalementDroitADesCongesPayesCasAuxLimites9() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne",
                LocalDate.now(), LocalDate.now(), 0, 0, 9, 1, 0);
        //When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false, res);

        //Given
        aide.setJoursTravaillesAnneeNMoins1(10);
        //When, Then
        res = aide.aLegalementDroitADesCongesPayes();
        Assertions.assertEquals(true, res);
    }

    @Test
    void aLegalementDroitADesCongesPayesFalse() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        //When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false, res);
    }
}