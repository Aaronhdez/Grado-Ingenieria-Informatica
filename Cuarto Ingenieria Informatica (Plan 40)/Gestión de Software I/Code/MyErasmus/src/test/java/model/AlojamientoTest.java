package model;

import es.ulpgc.gs1.model.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AlojamientoTest {
    private Alojamiento alojamiento;

    Lugar lugar;
    Arrendador arrendador;

    @Before
    public void SetUp(){
        UserData userData = new UserData("pepe","pepe@pepe","12345","ciudad","student");
        arrendador = new Arrendador(userData);

        this.lugar = new Lugar("Calle Pepito Galdos", "Las Palmas de Gran Canaria");

        this.alojamiento = new Alojamiento("1", "Piso increible", "Casa preciosa sin datos",arrendador,2,"120",lugar);
    }

    @Test
    public void test_if_alojamiento_is_equal_to_another_alojamiento(){
        Alojamiento alojamientoTest = new Alojamiento("1", "Piso increible", "Casa preciosa sin datos",arrendador,2,"120",lugar);

        assertEquals(this.alojamiento, alojamientoTest);
    }

    @Test
    public void test_set_duration_alojamiento(){
        Alojamiento sinDuration = alojamiento;
        alojamiento.setDuration("5");

        assertEquals(alojamiento.getDuration(), "5");
    }
}