package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import java.util.HashMap;
import java.util.Map;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class MessageSenderTest {

    @Test
    void MessageSenderRussia() {
        final Location location = new Location("Moscow", RUSSIA, "Lenina", 15);
        final Map<String, String> headers = new HashMap<>();
        final String ip = "172.112.27.16";
        final String expected = "Добро пожаловать";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(RUSSIA)).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        final String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);

    }

    @Test
    void MessageSenderUSA() {
        final Location location = new Location("New York", USA, " 10th Avenue", 32);
        final Map<String, String> headers = new HashMap<>();
        final String ip = "96.49.143.132";
        final String expected = "Welcome";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(USA)).thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        final String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);
    }
}