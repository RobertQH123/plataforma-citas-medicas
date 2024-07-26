package es.tfg.hospital;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.tfg.hospital.modelo.beans.Cita;
import es.tfg.hospital.modelo.beans.HistorialClinico;

class CitaTest {

    private Cita cita;

    @BeforeEach
    void setUp() {
        cita = new Cita();
        cita.setHistorialClinicos(new ArrayList<>()); // Inicializar la lista de historiales
    }

    @Test
    void testSettersAndGetters() {
        cita.setIdCita(1);
        assertEquals(1, cita.getIdCita());

        cita.setDireccionCentrosalud("Calle Falsa 123");
        assertEquals("Calle Falsa 123", cita.getDireccionCentrosalud());

        cita.setEstado("Pendiente");
        assertEquals("Pendiente", cita.getEstado());

        Date fecha = new Date();
        cita.setFechaCita(fecha);
        assertEquals(fecha, cita.getFechaCita());

        cita.setHoraCita("10:00");
        assertEquals("10:00", cita.getHoraCita());

        cita.setNombreMedico("Dr. House");
        assertEquals("Dr. House", cita.getNombreMedico());

        cita.setNombrePaciente("John Doe");
        assertEquals("John Doe", cita.getNombrePaciente());

        cita.setSintomas("Dolor de cabeza");
        assertEquals("Dolor de cabeza", cita.getSintomas());
    }

    @Test
    void testAddAndRemoveHistorialClinico() {
        HistorialClinico historialClinico = new HistorialClinico();
        cita.addHistorialClinico(historialClinico);
        List<HistorialClinico> historiales = cita.getHistorialClinicos();
        assertEquals(1, historiales.size());
        assertEquals(historialClinico, historiales.get(0));

        cita.removeHistorialClinico(historialClinico);
        historiales = cita.getHistorialClinicos();
        assertEquals(0, historiales.size());
        assertNull(historialClinico.getCita());
    }
}
