package praksa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 1. Креирајте класу карактера која садржи податке за сваки карактер у got_meta_data.txt фајлу. */
public class Karakter implements StringDeserializer<Karakter> {
	/* Polja klase */
	private String ime;
	private String pripadnost;
	private String datotekaChata;
	private List<String> poruke;
	private int ukupanBrojSrecnihSmjalija;
	private int ukupanBrojTuznihSmajlija;

	/* Podrazumevani konstuktor */
	public Karakter() {
		this.ime = "";
		this.pripadnost = "";
		this.datotekaChata = "";
		this.poruke = null;

	}

	/* Parametarizovan konstruktor klase */
	public Karakter(String ime, String pripadnost, String datotekaChata) {
		this.ime = ime;
		this.pripadnost = pripadnost;
		this.datotekaChata = datotekaChata;
		this.poruke = new ArrayList<>();
	}

	/* Getteri i Setteri */
	public String dohvatiIme() {
		return ime;
	}

	public String dohvatiPripadnost() {
		return pripadnost;
	}

	public String dohvatiDatotekuChata() {
		return datotekaChata;
	}

	public List<String> dohvatiPoruke() {
		return poruke;
	}

	/* Hvatanje broja poruka */
	public int dohvatiBrojPoruka() {
		int brojac = 0;

		// Kreiranje mape za povezivanje imena karaktera i njihovih nadimaka
		Map<String, String> imeNaNadimak = new HashMap<>();
		imeNaNadimak.put("Daenerys Stormborn", "DANY");
		imeNaNadimak.put("Jon Snow", "JON");
		imeNaNadimak.put("Tyrion Lannister", "TYRION");
		imeNaNadimak.put("Cersei Lannister", "CERSEI");

		// Dobijanje nadimka koji odgovara imenu karaktera
		String nadimak = imeNaNadimak.get(ime);

		for (String poruka : poruke) {
			/*
			 * Izbegavanje prvog reda jer to nije poruka vec nadimak, kao i praznih redova
			 */
			if (!poruka.equals(nadimak) && !poruka.trim().isEmpty()) {
				brojac++;
			}
		}
		return brojac;
	}

	public void postaviPoruke(List<String> poruke) {
		this.poruke = poruke;
	}

	public int dohvatiBrojSrecnihSmajlija() {
		return ukupanBrojSrecnihSmjalija;
	}

	public void postaviBrojSrecnihSmajlija(int ukupanBrojSrecnihSmjalija) {
		this.ukupanBrojSrecnihSmjalija = ukupanBrojSrecnihSmjalija;
	}

	public int dohvatiBrojTuznihSmajlija() {
		return ukupanBrojTuznihSmajlija;
	}

	public void postaviBrojTuznihSmajlija(int ukupanBrojTuznihSmajlija) {
		this.ukupanBrojTuznihSmajlija = ukupanBrojTuznihSmajlija;
	}

	/**
	 * Metoda za kreiranje liste Karakter objekata sa učitanim porukama.
	 */
	public static List<Karakter> kreirajNizKaraktera() {
		/* Učitavanje informacija o karakterima iz meta podataka */
		List<Karakter> characters = FileHelper.ocitavanjeKaraktera();

		/* Iteracija kroz listu Karakter objekata */
		for (Karakter character : characters) {
			/* Učitavanje poruka za trenutni karakter iz datoteke chata */
			List<String> messages = FileHelper.loadMessages(character.dohvatiDatotekuChata());

			/* Učitavanje poruka za trenutni karakter iz datoteke chata */
			character.postaviPoruke(messages);
		}

		/* Povratna lista Karakter objekata sa učitanim porukama */
		return characters;
	}

	/**
	 * Metoda za ispis informacija o karakterima u listi.
	 */
	public static void ispisInformacija(List<Karakter> listaKaraktera) {
		/* Prikaz informacija o karakterima u konzoli */
		System.out.println(
				" \n1. Креирајте класу карактера која садржи податке за сваки карактер у got_meta_data.txt фајлу.");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		for (Karakter character : listaKaraktera) {
			System.out.println("Ime: " + character.dohvatiIme());
			System.out.println("Pripadnost: " + character.dohvatiPripadnost());
			System.out.println("Datoteka chata: " + character.dohvatiDatotekuChata());
			System.out.println();
		}
	}

	@Override
	public Karakter deserializeFromString(String entity, String fieldSeparator) {
		// TODO Auto-generated method stub
		return null;
	}

}
