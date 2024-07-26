package es.tfg.hospital;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.tfg.hospital.modelo.beans.Cita;
import es.tfg.hospital.modelo.beans.Diagnostico;
import es.tfg.hospital.modelo.beans.Informacion;
import es.tfg.hospital.modelo.beans.Usuario;
public class UsuarioTest {

    private Usuario usuario;
    private Cita cita;
    private Diagnostico diagnostico;
    private Informacion informacion;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
        cita = new Cita();
        diagnostico = new Diagnostico();
        informacion = new Informacion();

        // Inicializar las listas
        usuario.setCitas(new ArrayList<>());
        usuario.setDiagnosticos(new ArrayList<>());
        usuario.setInformacions(new ArrayList<>());
    }

    @Test
    public void testGettersAndSetters() {
        usuario.setDni("12345678A");
        usuario.setApellido("García");
        usuario.setDireccion("Calle Falsa 123");
        usuario.setEmail("test@example.com");
        usuario.setEnabled(1);
        usuario.setImgurl("http://example.com/image.jpg");
        usuario.setNombre("Juan");
        usuario.setOnlineusu(1);
        usuario.setPassword("password");
        usuario.setTelefono("123456789");

        assertEquals("12345678A", usuario.getDni());
        assertEquals("García", usuario.getApellido());
        assertEquals("Calle Falsa 123", usuario.getDireccion());
        assertEquals("test@example.com", usuario.getEmail());
        assertEquals(1, usuario.getEnabled());
        assertEquals("http://example.com/image.jpg", usuario.getImgurl());
        assertEquals("Juan", usuario.getNombre());
        assertEquals(1, usuario.getOnlineusu());
        assertEquals("password", usuario.getPassword());
        assertEquals("123456789", usuario.getTelefono());
    }

    @Test
    public void testAddAndRemoveCita() {
        usuario.addCita(cita);
        assertTrue(usuario.getCitas().contains(cita));

        usuario.removeCita(cita);
        assertFalse(usuario.getCitas().contains(cita));
    }

    @Test
    public void testAddAndRemoveDiagnostico() {
        usuario.addDiagnostico(diagnostico);
        assertTrue(usuario.getDiagnosticos().contains(diagnostico));

        usuario.removeDiagnostico(diagnostico);
        assertFalse(usuario.getDiagnosticos().contains(diagnostico));
    }

    @Test
    public void testAddAndRemoveInformacion() {
        usuario.addInformacion(informacion);
        assertTrue(usuario.getInformacions().contains(informacion));

        usuario.removeInformacion(informacion);
        assertFalse(usuario.getInformacions().contains(informacion));
    }

    @Test
    public void testEqualsAndHashCode() {
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();

        usuario1.setDni("12345678A");
        usuario2.setDni("12345678A");

        assertEquals(usuario1, usuario2);
        assertEquals(usuario1.hashCode(), usuario2.hashCode());

        usuario2.setDni("87654321B");
        assertNotEquals(usuario1, usuario2);
        assertNotEquals(usuario1.hashCode(), usuario2.hashCode());
    }
}
