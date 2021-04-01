package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class GeoServiceImplTest {

    private static final List<Location> locations = new ArrayList<>();
    private static GeoService geoService;

    @BeforeAll
    static void setLocations() {
        locations.add(new Location(null, null, null, 0));
        locations.add(new Location("Moscow", RUSSIA, "Lenina", 15));
        locations.add(new Location("New York", USA, " 10th Avenue", 32));
        locations.add(new Location("Moscow", RUSSIA, null, 0));
        locations.add(new Location("New York", USA, null,  0));
    }

    @BeforeAll
    static void setGeoService() {
        geoService = new GeoServiceImpl();
    }

    @Test
    void checkLocalhostIp() {
        final String ip = "127.0.0.1";
        final Location expected = locations.get(0);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkMoscowIp() {
        final String ip = "172.0.32.11";
        final Location expected = locations.get(1);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkNewYorkIp() {
        final String ip = "96.44.183.149";
        final Location expected = locations.get(2);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkRussiaIp() {
        final String ip = "172.5.29.13";
        final Location expected = locations.get(3);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkUsaIp() {
        final String ip = "96.123.57.8";
        final Location expected = locations.get(4);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

}