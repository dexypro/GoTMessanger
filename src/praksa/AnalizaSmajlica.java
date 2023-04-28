package praksa;

import java.util.List;

public class AnalizaSmajlica {
	/* Liste srecnih i tužnih smajlija iz enumeracije */
	static List<String> srecniSmajlici = VrstaSmajlija.SRECAN.dohvatiSmajlice();
	static List<String> tuzniSmajlici = VrstaSmajlija.TUZAN.dohvatiSmajlice();

	/* Metoda za prebrojavanje pojavljivanja odredjenog smajlija u poruci */
	public static int brojPojavljivanjaSmajlica(String poruka, String smajlic) {
		int brojac = 0;
		int pozicija = poruka.indexOf(smajlic);

		while (pozicija != -1) {
			brojac++;
			pozicija = poruka.indexOf(smajlic, pozicija + smajlic.length());
		}

		return brojac;
	}

	/* Metoda za analizu smajlija u porukama */
	public static void analizaSmajlica(List<Karakter> karakteri) {
		for (Karakter karakter : karakteri) {
			List<String> poruke = karakter.dohvatiPoruke();
			int brojSrecnihSmajlica = 0;
			int brojTuznihSmajlica = 0;

			/* Prebrojavanje srecnih i tužnih smajlija u porukama */
			for (String poruka : poruke) {
				brojSrecnihSmajlica += brojPojavljivanjaSmajlica(poruka, "😄");
				brojSrecnihSmajlica += brojPojavljivanjaSmajlica(poruka, "🙂");
				brojSrecnihSmajlica += brojPojavljivanjaSmajlica(poruka, "😊");
				brojSrecnihSmajlica += brojPojavljivanjaSmajlica(poruka, "😍");
				brojTuznihSmajlica += brojPojavljivanjaSmajlica(poruka, "😞");
				brojTuznihSmajlica += brojPojavljivanjaSmajlica(poruka, "😢");
				brojTuznihSmajlica += brojPojavljivanjaSmajlica(poruka, "😭");
				brojTuznihSmajlica += brojPojavljivanjaSmajlica(poruka, "👿");
			}

			/* Postavljanje broja srecnih i tužnih smajlija */
			karakter.postaviBrojSrecnihSmajlija(brojSrecnihSmajlica);
			karakter.postaviBrojTuznihSmajlija(brojTuznihSmajlica);
		}
	}

	/*
	 * Metoda za stampanje karaktera sa najpozitivnijom i najnegativnijom
	 * dispozicijom.
	 */
	public static void stampanjeAnalizeDispozicije(List<Karakter> karakteri) {
		AnalizaSmajlica.analizaSmajlica(karakteri);
		Karakter najpozitivnijaOsoba = null;
		Karakter najnegativnijaOsoba = null;

		/* Pronalaženje karaktera sa najpozitivnijom i najnegativnijom dispozicijom */
		for (Karakter karakter : karakteri) {
			if (najpozitivnijaOsoba == null
					|| karakter.dohvatiBrojSrecnihSmajlija() > najpozitivnijaOsoba.dohvatiBrojSrecnihSmajlija()) {
				najpozitivnijaOsoba = karakter;
			}
			if (najnegativnijaOsoba == null
					|| karakter.dohvatiBrojTuznihSmajlija() > najnegativnijaOsoba.dohvatiBrojTuznihSmajlija()) {
				najnegativnijaOsoba = karakter;
			}
		}

		/*
		 * Štampanje poglavlja sa tekstom petog zadatka kao i stampanje izlaznog
		 * rezultata
		 */
		System.out.println("  \n\n5. Одштампати карактер који има најпозитивнију и најнегативнију диспозицију.");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		System.out.println("Osoba sa najnegativnijom dispozicijom:");
		System.out.println("Ime: " + najpozitivnijaOsoba.dohvatiIme());
		System.out.println("Pripadnost: " + najpozitivnijaOsoba.dohvatiPripadnost());
		System.out.println("Broj srecnih smajlija: " + najpozitivnijaOsoba.dohvatiBrojSrecnihSmajlija());

		System.out.println("\nOsoba sa najpozitivnijom dispozicijom:");
		System.out.println("Ime: " + najnegativnijaOsoba.dohvatiIme());
		System.out.println("Pripadnost: " + najnegativnijaOsoba.dohvatiPripadnost());
		System.out.println("Broj tužnih smajlija: " + najnegativnijaOsoba.dohvatiBrojTuznihSmajlija());
	}

	/* Metoda za analizu smajlija u porukama karaktera i stampanje rezultata. */
	public static void analizaSmajlicaIStampanje(List<Karakter> karakteri) {

		System.out.println(" \n\n4a. Uraditi analizu karaktera, brojeci njihovu upotrebu smajlija:");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		for (Karakter karakter : karakteri) {
			int happyCount = brojacEmojis(karakter.dohvatiPoruke(), srecniSmajlici);
			int sadCount = brojacEmojis(karakter.dohvatiPoruke(), tuzniSmajlici);

			System.out.println(
					karakter.dohvatiIme() + ": Srecni smajlici: " + happyCount + ", Tužni smajlici: " + sadCount);
		}
	}

	/* Metoda za brojanje odredjenih smajlija u listi poruka. */
	static int brojacEmojis(List<String> poruke, List<String> smajlics) {
		int brojac = 0;
		for (String poruka : poruke) {
			for (String smajlic : smajlics) {
				brojac += poruka.split(smajlic).length - 1;
			}
		}
		return brojac;

	}

	/*
	 * Metoda za odredjivanje dispozicije i stampanje rezultata.
	 */
	public static void odrediDispozicijuIStampaj(List<Karakter> karakteri) {
		int ukupanBrojSrecnihSmajlija = 0;
		int ukupanBrojTuznihSmajlija = 0;

		/* Računanje ukupnog broja srecnih i tužnih smajlija */
		for (Karakter karakter : karakteri) {
			int brojacSrecnih = brojacEmojis(karakter.dohvatiPoruke(), srecniSmajlici);
			int sadCount = brojacEmojis(karakter.dohvatiPoruke(), tuzniSmajlici);
			ukupanBrojSrecnihSmajlija += brojacSrecnih;
			ukupanBrojTuznihSmajlija += sadCount;
		}

		/* Štampanje teksta četvrtog A zadatka kao i stampanje izlaznog rezultata */

		System.out
				.println(" \n\n4b. Proveriti da li „SAD“ ima pozitivnu dispoziciju (da li je vise srecan ili tužan).");
		System.out.println("----------------------------------------------------------------------------------------");
		if (ukupanBrojSrecnihSmajlija > ukupanBrojTuznihSmajlija) {
			System.out.println("Pozitivna dispozicija sa " + ukupanBrojSrecnihSmajlija + " srecnih smajlica i "
					+ ukupanBrojTuznihSmajlija + " tužnih smajlica.");
		} else if (ukupanBrojSrecnihSmajlija < ukupanBrojTuznihSmajlija) {
			System.out.println("Negativna dispozicija sa " + ukupanBrojTuznihSmajlija + " tužnih smajlica " + " i "
					+ ukupanBrojSrecnihSmajlija + " srecnih smajlica.");
		} else {
			System.out.println("Neutralna dispozicija sa " + ukupanBrojTuznihSmajlija + " tužnih smajlica " + " i "
					+ ukupanBrojSrecnihSmajlija + " srecnih smajlica.");
		}
	}

	/* Metoda za brojanje ljubavnih smajlica u poruci */
	public static int ukupnoLjubavnihSmajlica(String poruka) {
		String[] lovingEmojis = { "😍", "😘" };
		int brojac = 0;

		/* Brojanje ljubavnih smajlica u poruci */
		for (String smajlic : lovingEmojis) {
			int index = poruka.indexOf(smajlic);
			while (index != -1) {
				brojac++;
				index = poruka.indexOf(smajlic, index + 1);
			}
		}

		return brojac;
	}

	/* Metoda za uporedjivanje ljubavnih smajlica izmedju Jona i Deneris. */
	public static void uporedjivanjeLjubavnihSmajlica(List<Karakter> karakteri) {
		int jonLovingCount = 0;
		int danyLovingCount = 0;

		/* Prebrojavanje ljubavnih smajlica za Jon Snow i Daenerys Stormborn */
		for (Karakter karakter : karakteri) {
			if (karakter.dohvatiIme().equals("Jon Snow") || karakter.dohvatiIme().equals("Daenerys Stormborn")) {
				for (String poruka : karakter.dohvatiPoruke()) {
					int lovingEmojiCount = ukupnoLjubavnihSmajlica(poruka);
					if (karakter.dohvatiIme().equals("Jon Snow")) {
						jonLovingCount += lovingEmojiCount;
					} else {
						danyLovingCount += lovingEmojiCount;
					}
				}
			}
		}
		/* Uporedjivanje ljubavnih smajlica i stampanje rezultata */

		System.out.println(" \n\n6. Da li Jon voli Deneris vise nego sto ona voli njega?");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		if (jonLovingCount > danyLovingCount) {
			System.out.println("Jon voli Deneris vise jer joj je on poslao " + (jonLovingCount - danyLovingCount)
					+ " ljubavni smajlic vise.");
		} else if (jonLovingCount < danyLovingCount) {
			System.out.println("Deneris voli Jona vise jer mu je ona poslala" + +(danyLovingCount - jonLovingCount)
					+ " ljubavni smajlic vise.");
		} else {
			System.out.println("Jon i Deneris se vole JEDNAKO!");
		}
	}
}
