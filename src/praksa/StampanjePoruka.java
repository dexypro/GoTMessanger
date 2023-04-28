package praksa;

import java.util.List;

public class StampanjePoruka {
	/* Metoda za štampanje poruka Daenerys iz liste karaktera. */
	public static void stampanjePorukaKaraktera(List<Karakter> characters, String imeKaraktera) {
		/* Za odredjivanje pozicije u listi */
		int adapterKoda;
		/* Utvrdjivanje nadimka parametarizovanog karaktera */
		String nadimak = "";
		switch (imeKaraktera) {
		case "Daenerys":
			/* Daenerys se nalazi na prvom mestu u listi karaktera */
			adapterKoda = 0;
			nadimak = "DANY";
			break;
		case "John":
			/* Jon se nalazi na prvom mestu u listi karaktera */
			adapterKoda = 1;
			nadimak = "JON";
			break;
		case "Tyrion":
			/* Tyrion se nalazi na prvom mestu u listi karaktera */
			adapterKoda = 2;
			nadimak = "TYRION";
			break;
		case "Cersei":
			/* Cersei se nalazi na prvom mestu u listi karaktera */
			adapterKoda = 3;
			nadimak = "CERSEI";
			break;
		default:
			adapterKoda = 0;
		}

		Karakter karakter = characters.get(adapterKoda);

		/* Ispisivanje zaglavlja drugog zadatka */
		System.out.println(" \n\n2. Odštampajte sve poruke osobe " + imeKaraktera + ".");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		/*
		 * Iteracija kroz sve poruke koje je poslala Daenerys
		 */
		for (String message : karakter.dohvatiPoruke()) {
			/* Prvi red nije poruka već nadimak osobe */
			if (!message.equals(nadimak)) {
				/* Ispisivanje poruke u konzoli */
				System.out.println(message);
			}
		}
	}

	public static void prikaziBrojPoruka(List<Karakter> listaKaraktera) {
		/*
		 * Metoda za prikaz broja poruka koje je svaki GOT karakter poslao
		 */

		System.out.println(" \n\n3. Креирајте обавештење које приказује број порука који се сваки карактер послао.");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		for (Karakter character : listaKaraktera) {
			System.out.println(character.dohvatiIme() + " je poslao/la " + character.dohvatiBrojPoruka() + " poruka.");
		}
	}
}
