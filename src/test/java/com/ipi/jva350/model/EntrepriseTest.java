package com.ipi.jva350.model;

import io.cucumber.java.en.When;
import jdk.vm.ci.meta.Local;
import org.assertj.core.api.Java6StandardSoftAssertionsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EntrepriseTest {


    @ParameterizedTest(name = "La date {0} est un jour férié : {1}")
    @CsvSource({
            "'2012-04-08','true'",
            "'2016-04-08', 'true'",
            "'2013-04-08', 'false'",
            "'2000-04-08', 'false'"
    })

    @Test
    void estJourFerie(String date, boolean expectedJourFerierBool)
    {
        //Given
        Entreprise entreprise = new Entreprise();
        LocalDate d = LocalDate.parse(date);

        //When
        boolean jourferier = Entreprise.estJourFerie(d);

        //Then
        Assertions.assertEquals(false, jourferier);
    }

}