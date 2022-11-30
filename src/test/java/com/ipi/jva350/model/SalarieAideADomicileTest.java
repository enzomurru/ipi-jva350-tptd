package com.ipi.jva350.model;

import io.cucumber.java.en.When;
import jdk.vm.ci.meta.Local;
import org.assertj.core.api.Java6StandardSoftAssertionsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

public class SalarieAideADomicileTest {

    private Java6StandardSoftAssertionsProvider Assertion;
    @ParameterizedTest(name = "entre {0} et {1}")
    @CsvSource({
            "XXXXXXXXXX, 2"
    })
    void calculeJoursDeCongeDecomptesPourPlage() {
        //Given
        SalarieAideADomicile salarie = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1),
                LocalDate.now(), 0, 0, 9, 1, 0);
        //Then
        LinkedHashSet<LocalDate> res = salarie.calculeJoursDeCongeDecomptesPourPlage(LocalDate.of(2021, 7, 1),
                LocalDate.of(2022, 7, 27));
        //When
        LinkedHashSet<LocalDate> expected = new LinkedHashSet<>();
        expected.add(LocalDate.of(2022, 7, 11));
        expected.add(LocalDate.parse("2022-07-11"));
        Assertions.assertEquals(false, res);
    }

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