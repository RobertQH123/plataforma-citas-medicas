package es.tfg.hospital;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.tfg.hospital.modelo.beans.HistorialClinico;
import es.tfg.hospital.modelo.beans.Medicina;
import es.tfg.hospital.modelo.beans.Tipo;

public class MedicinaTest {

    private Medicina medicina;
    private HistorialClinico historialClinico;
    private Tipo tipo;

    @BeforeEach
    public void setUp() {
        medicina = new Medicina();
        historialClinico = new HistorialClinico();
        tipo = new Tipo();

        // Inicializar las listas
        medicina.setHistorialClinicos(new ArrayList<>());
    }

    @Test
    public void testGettersAndSetters() {
        medicina.setCodMed(1);
        medicina.setActivo("Sí");
        medicina.setCantidad(100);
        medicina.setFechaFin(new Date());
        medicina.setFechaInicio(new Date());
        medicina.setNombreMed("Aspirina");
        medicina.setTipo(tipo);

        assertEquals(1, medicina.getCodMed());
        assertEquals("Sí", medicina.getActivo());
        assertEquals(100, medicina.getCantidad());
        assertNotNull(medicina.getFechaFin());
        assertNotNull(medicina.getFechaInicio());
        assertEquals("Aspirina", medicina.getNombreMed());
        assertEquals(tipo, medicina.getTipo());
    }

    @Test
    public void testAddAndRemoveHistorialClinico() {
        medicina.addHistorialClinico(historialClinico);
        assertTrue(medicina.getHistorialClinicos().contains(historialClinico));

        medicina.removeHistorialClinico(historialClinico);
        assertFalse(medicina.getHistorialClinicos().contains(historialClinico));
    }
}
