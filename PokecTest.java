package Poke;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PokecTest {

	@Test
	 public void testPokec() {
		assertEquals("Black wins",Pokec.Pokec("2H 2D 2S 5D 6S", "2H 6D 7C 3H AH"));
	}

}
