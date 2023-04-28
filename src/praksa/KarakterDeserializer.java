package praksa;

public class KarakterDeserializer implements StringDeserializer<Karakter> {
	// Metoda vraća objekat tipa Karakter dobijen deserijalizacijom stringa
	@Override
	public Karakter deserializeFromString(String entity, String fieldSeparator) {
		String[] data = entity.split(fieldSeparator);

		// Učitavanje informacija o karakteru iz niza podataka
		String ime = data[0];
		String pripadnost = data[1];
		String datotekaPoruka = data[2];

		// Kreiranje novog Karakter objekta sa učitanim informacijama i vraćanje istog
		return new Karakter(ime, pripadnost, datotekaPoruka);
	}
}
