package praksa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

	/**
	 * Metoda za učitavanje informacija o karakterima iz meta podataka.
	 */
	public static List<Karakter> ocitavanjeKaraktera() {
		/* Kreiranje prazne liste za skladištenje Karakter objekata */
		List<Karakter> karakteri = new ArrayList<>();

		/* Učitavanje meta podataka kao jedinstvenog stringa */
		String metaData = loadMetaData();

		/* Razdvajanje meta podataka na linije */
		String[] metaDataLines = metaData.split(System.lineSeparator());

		/* Konverzija stringova sa meta podacima */
		KarakterDeserializer karakterDeserializer = new KarakterDeserializer();

		/*
		 * Iteracija kroz linije meta podataka, počevši od druge linije (preskače se
		 * zaglavlje)
		 */
		for (int i = 1; i < metaDataLines.length; i++) {
			/* Razdvajanje trenutne linije na podatke odvojene zarezima */
			Karakter karakter = karakterDeserializer.deserializeFromString(metaDataLines[i], ", ");
			karakteri.add(karakter);
		}

		/* Vraća se lista sa učitanim informacijama o karakterima */
		return karakteri;
	}

	public static String loadMetaData() {
		StringBuffer characterData = new StringBuffer();
		File file = new File("resource/got_meta_data.txt");

		try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
			String aLine;
			while ((aLine = buffer.readLine()) != null) {
				characterData.append(aLine);
				characterData.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return characterData.toString();
	}

	public static List<String> loadMessages(String fileName) {
		List<String> messages = new ArrayList<String>();
		File file = new File("resource/message_logs/" + fileName);

		try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
			String aLine;
			while ((aLine = buffer.readLine()) != null) {
				messages.add(aLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return messages;
	}

}
