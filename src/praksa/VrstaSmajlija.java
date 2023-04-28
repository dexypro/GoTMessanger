package praksa;

import java.util.Arrays;
import java.util.List;

/*
 * Enumeracija za vrste smajlija - SRECAN i TUZAN.
 * */
public enum VrstaSmajlija {
	/* Definisanje vrsta smajlija sa listama pripadajućih emotikona */
	SRECAN(Arrays.asList("😄", "🙂", "😍", "😊")), TUZAN(Arrays.asList("😞", "😢", "😭", "👿"));

	/* Atribut koji sadrži listu smajli kodova za svaku vrstu smajlija */
	private final List<String> smajlici;

	/* Konstruktor za enumeraciju VrstaSmajlija */
	VrstaSmajlija(List<String> smajlici) {
		this.smajlici = smajlici;
	}

	/* Metoda za dohvatanje liste smajli kodova za odgovarajuću vrstu smajlija */
	public List<String> dohvatiSmajlice() {
		return smajlici;
	}
}