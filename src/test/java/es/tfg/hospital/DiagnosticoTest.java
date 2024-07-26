package es.tfg.hospital;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.tfg.hospital.modelo.beans.Diagnostico;
import es.tfg.hospital.modelo.beans.Usuario;


class DiagnosticoTest {

    private Diagnostico diagnostico;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();  // Suponiendo que tienes una clase Usuario.
        diagnostico = new Diagnostico("Polen", "Asma", "Apendicectomía", "Inhalador", usuario);
    }

    @Test
    void testSettersAndGetters() {
        diagnostico.setIdDiag(1);
        assertEquals(1, diagnostico.getIdDiag());

        diagnostico.setAlergias("Polen");
        assertEquals("Polen", diagnostico.getAlergias());

        diagnostico.setEnfermedades("Asma");
        assertEquals("Asma", diagnostico.getEnfermedades());

        diagnostico.setOperaciones("Apendicectomía");
        assertEquals("Apendicectomía", diagnostico.getOperaciones());

        diagnostico.setTratamiento("Inhalador");
        assertEquals("Inhalador", diagnostico.getTratamiento());

        diagnostico.setUsuario(usuario);
        assertEquals(usuario, diagnostico.getUsuario());
    }

    @Test
    void testDefaultConstructor() {
        Diagnostico emptyDiagnostico = new Diagnostico();
        assertNull(emptyDiagnostico.getAlergias());
        assertNull(emptyDiagnostico.getEnfermedades());
        assertNull(emptyDiagnostico.getOperaciones());
        assertNull(emptyDiagnostico.getTratamiento());
        assertNull(emptyDiagnostico.getUsuario());
    }
}
