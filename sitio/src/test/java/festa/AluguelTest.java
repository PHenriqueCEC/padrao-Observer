package festa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AluguelTest {

    @Test
    void deveNotificarLocatario() {
        Sitio sitio = new Sitio("Vivendas", "Juiz de Fora", 400.0f, 80);
        Locatario loc = new Locatario("Pedro");
        loc.addObserver(sitio);
        sitio.getSitio();
        assertEquals("Pedro, sítio disponível para alugar: Sítio{nome='Vivendas', endereço='Juiz de Fora', preço=400.0, capacidade=80}", loc.getUltimaAtualizacao());
    }

    @Test
    void deveNotificarLocatarios() {
        Sitio sitio = new Sitio("Vivendas", "Juiz de Fora", 400.0f, 80);
        Locatario loc = new Locatario("Pedro");
        Locatario loc2 = new Locatario("Lucas");
        loc.addObserver(sitio);
        loc2.addObserver(sitio);
        sitio.getSitio();
        assertEquals("Pedro, sítio disponível para alugar: Sítio{nome='Vivendas', endereço='Juiz de Fora', preço=400.0, capacidade=80}", loc.getUltimaAtualizacao());
        assertEquals("Lucas, sítio disponível para alugar: Sítio{nome='Vivendas', endereço='Juiz de Fora', preço=400.0, capacidade=80}", loc2.getUltimaAtualizacao());
    }


    @Test
    void naoDeveNotificarLocatario() {
        Sitio sitio = new Sitio("Vivendas", "Juiz de Fora", 400.0f, 80);
        Locatario loc = new Locatario("Pedro");
        loc.addObserver(sitio);
        assertEquals(null, loc.getUltimaAtualizacao());
    }

    @Test
    void deveNotificarLocatariosDiferentes() {
        Sitio sitio = new Sitio("Vivendas", "Juiz de Fora", 400.0f, 80);
        Sitio sitio2 = new Sitio("Palmares", "Juiz de Fora", 500.0f, 80);
        Locatario loc = new Locatario("Pedro");
        Locatario loc2 = new Locatario("Lucas");
        loc.addObserver(sitio);
        loc2.addObserver(sitio2);
        sitio.getSitio();
        assertEquals("Pedro, sítio disponível para alugar: Sítio{nome='Vivendas', endereço='Juiz de Fora', preço=400.0, capacidade=80}", loc.getUltimaAtualizacao());
        assertEquals(null, loc2.getUltimaAtualizacao());
    }

}
