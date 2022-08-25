import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Internet {

	private static Internet instance;
	private WebenLista nireInternet;

	private Internet() {
		nireInternet = new WebenLista();
	}

	public static Internet getInstance() {
		if (instance == null) {
			instance = new Internet();
		}
		return instance;
	}

	/**
	 * Pasatako fitxategian dauden webak kargatzen ditu
	 * 
	 * @param fitxIzena: webak dauzkan fitxategiaren izena
	 */
	private void webakKargatu(String fitxIzena) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fitxIzena));
			String line;
			while ((line = br.readLine()) != null) {
				String[] arrayPuntuak = line.trim().split("\\s+");
				Web weba = new Web(Integer.parseInt((arrayPuntuak[1])), arrayPuntuak[0]);
				nireInternet.webaErantsi(weba);

			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	/**
	 * Pasatako fitxategian dauden estekak kargatzen ditu
	 * 
	 * @param fitxIzena: estekak dauzkan fitxategiaren izena
	 */
	private void estekakKargatu(String fitxIzena) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fitxIzena));
			String line;
			while ((line = br.readLine()) != null) {
				String[] arrayPuntuak = line.trim().split("\\s+");
				this.nireInternet.estekaErantsi(Integer.parseInt(arrayPuntuak[0]), Integer.parseInt(arrayPuntuak[1]));

			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	/**
	 * Klasea hasieratzen du: horretarako web-orriak eta estekak kargatzen ditu
	 * 
	 * @param webenFitxIzena:   webak dauzkan fitxategiaren izena
	 * @param estekenFitxIzena: estekak dauzkan fitxategiaren izena
	 */
	public void hasieratu(String webenFitxIzena, String estekenFitxIzena) {
		Internet.getInstance().webakKargatu(webenFitxIzena);
		Internet.getInstance().estekakKargatu(estekenFitxIzena);

	}

	/**
	 * Hitz bati dagokion stringa emanda, pantailan inprimatzen ditu gako-hitz hori
	 * duten webak
	 * 
	 * @param s: hitzari dagokion stringa
	 */
	public void webBilatzailea(String s) {
		Hiztegia hiztegia = Hiztegia.getInstance();
		Hitza h = hiztegia.hitzaBilatu(s);
		int n = 1;
		if (h != null) {
			for (Web w : h.getLista().getLista()) {
				System.out.println(n + "- " + w.getUrl());
				n++;
			}
		} else {
			System.out.println("HITZ HORI EZ DAGO HIZTEGIAN");
		}
	}

	public WebenLista getNireInternet() {
		return nireInternet;
	}

	public void setNireInternet(WebenLista nireInternet) {
		this.nireInternet = nireInternet;
	}

}
