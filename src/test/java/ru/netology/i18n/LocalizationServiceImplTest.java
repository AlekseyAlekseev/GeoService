package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.*;

class LocalizationServiceImplTest {

    @Test
    void checkRussiaLocalization() {
        final String expected = "Добро пожаловать";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(RUSSIA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkUsaLocalization() {
        final String expected = "Welcome";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(USA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkGermanyLocalization() {
        final String expected = "Welcome";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(GERMANY);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkBrazilLocalization() {
        final String expected = "Welcome";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(BRAZIL);
        Assertions.assertEquals(expected, result);
    }
}