package praksa;

import java.util.List;

import javax.swing.SwingUtilities;

public class Main {

	/* Pokretanje programa 😁 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MenadzerGUI.kreirajPrikaziGUI();
		});
	}

	static void izvrsavanjeProgramskeLogike() {
		// 1. Креирајте класу карактера која садржи податке за сваку особу
		List<Karakter> characters = Karakter.kreirajNizKaraktera();
		Karakter.ispisInformacija(characters);

		// 2. Одштампајте све поруке особе Daenerys.
		StampanjePoruka.stampanjePorukaKaraktera(characters, MenadzerGUI.izborOsobe());

		// 3. Обавештење које приказује број порука који je свакa особа послала.
		StampanjePoruka.prikaziBrojPoruka(characters);

		// 4a. Урадити анализу карактера, бројећи њихову употребу смајлија:
		AnalizaSmajlica.analizaSmajlicaIStampanje(characters);

		// 4b. Проверити да ли „SAD“ има позитивну диспозицију
		AnalizaSmajlica.odrediDispozicijuIStampaj(characters);

		// 5. Одштампати карактер који има најпозитивнију и најнегативнију диспозицију.
		AnalizaSmajlica.stampanjeAnalizeDispozicije(characters);

		// 6. Да ли Jon воли Daenerys више него што она воли њега.
		AnalizaSmajlica.uporedjivanjeLjubavnihSmajlica(characters);
	}
}
