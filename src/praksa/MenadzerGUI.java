package praksa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MenadzerGUI {
	private static String izabranaOsoba = "Daenerys";

	static void kreirajPrikaziGUI() {
		// Kreiranje korisničkog interfejsa
		JFrame frame = new JFrame("JAVA IT PRAKSA");

		// Ukoliko se klikne na X onda se zatvara aplikacija
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Postavljanje širine i visine prozora programa
		frame.setSize(800, 650);

		// Dohvatanje dimenzije monitora
		Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();

		// Računanje pozicije prozora na osnovu veličine monitora i veličine prozora,
		// tako da prozor bude pozicioniran u sredini monitora.
		int xPos = (velicinaEkrana.width - frame.getWidth()) / 2;
		int yPos = (velicinaEkrana.height - frame.getHeight()) / 2;

		// Postavljanje pozicije prozora na izračunatu poziciju.
		frame.setLocation(xPos, yPos);

		// Logo Game of Thrones
		JPanel prostorZaLogo = new JPanel();
		prostorZaLogo.setLayout(new GridLayout());
		ImageIcon imageIcon = new ImageIcon("logoGoTB.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		prostorZaLogo.add(imageLabel);

		// Površina za ispisivanje texta
		JTextArea povrsinaZaText = new JTextArea();
		povrsinaZaText.setBackground(Color.BLACK);
		povrsinaZaText.setForeground(Color.WHITE);
		JScrollPane prostorZaKlizac = new JScrollPane(povrsinaZaText);
		prostorZaKlizac.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		prostorZaKlizac.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		prostorZaKlizac.setBorder(new EmptyBorder(0, 0, 0, 0)); // Remove border

		// Customize scrollbars
		prostorZaKlizac.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = new Color(0xf9d09c);
				this.trackColor = Color.DARK_GRAY;
			}
		});
		prostorZaKlizac.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = new Color(0xf9d09c);
				this.trackColor = Color.DARK_GRAY;
			}
		});
		// Segment sa dugmicima
		JPanel buttonPanel = new JPanel();
		JButton dugmeZaKonzolu = new JButton("Štampa u konzoli");
		JButton dugmeZaEkran = new JButton("Štampa na ekranu");

		String[] opcije = { "Daenerys", "John", "Tyrion", "Cersei" };
		JComboBox<String> padajuciMeni = new JComboBox<>(opcije);

		buttonPanel.add(dugmeZaKonzolu);
		buttonPanel.add(dugmeZaEkran);
		buttonPanel.add(padajuciMeni);

		// JPanel with version label
		JPanel versionPanel = new JPanel();
		JLabel versionLabel = new JLabel("Copyright @ 2023 | Misanu | Verzija 1.1");
		versionPanel.add(versionLabel);

		// JPanel with buttons, padajuciMeni and version label
		JPanel prostorDonji = new JPanel(new BorderLayout());
		prostorDonji.add(buttonPanel, BorderLayout.CENTER);
		prostorDonji.add(versionPanel, BorderLayout.SOUTH);

		// Set background color of each panel to black
		prostorZaLogo.setBackground(Color.BLACK);
		buttonPanel.setBackground(Color.BLACK);
		versionPanel.setBackground(Color.BLACK);
		prostorDonji.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);

		// Add panels to frame
		frame.add(prostorZaLogo, BorderLayout.PAGE_START);
		frame.add(prostorZaKlizac, BorderLayout.CENTER);
		frame.add(prostorDonji, BorderLayout.SOUTH);

		// Postavljanje vidljivosti prozora
		frame.setVisible(true);

		// Postavljanje akcije koja će se desiti kada se klikne na dugme "Štampa u
		// konzoli" - u ovom slučaju, pozivanje metode izvrsavanjeProgramskeLogike().
		dugmeZaKonzolu.addActionListener((ActionEvent e) -> {
			Main.izvrsavanjeProgramskeLogike();
		});

		// Postavljanje akcije koja će se desiti kada se klikne na dugme "Štampa na
		// ekranu" - u ovom slučaju, pozivanje metode izvrsavanjeProgramskeLogike().
		dugmeZaEkran.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(baos);
				PrintStream oldOut = System.out;
				System.setOut(printStream);
				System.setErr(printStream);

				Main.izvrsavanjeProgramskeLogike();

				System.setOut(oldOut);

				String izlazniRezultatKonzole = new String(baos.toByteArray(), StandardCharsets.UTF_8);
				povrsinaZaText.setText(izlazniRezultatKonzole);
				povrsinaZaText.setCaretPosition(0);
			}
		});
		// Dodavanje akcije na JComboBox
		padajuciMeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Promena izabrane osobe
				izabranaOsoba = (String) padajuciMeni.getSelectedItem();
			}
		});

	}

	public static String izborOsobe() {
		return izabranaOsoba;
	}
}
