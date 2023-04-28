package praksa;

//Interfejs definisan za generički tip
public interface StringDeserializer<T> {

	// Konstanta za zarez koji se koristi kao separator polja
	public static final String COMMA = ",";
	// Konstanta za razmak koji se koristi kao separator polja
	public static final String SPACE = " ";

	// Metoda vraća objekat tipa T dobijen deserijalizacijom entity stringa
	public T deserializeFromString(String entity, String fieldSeparator);
}