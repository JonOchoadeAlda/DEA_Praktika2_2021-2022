import java.io.IOException;
import java.util.Scanner;


public class WebAplikazioa {

	public static void main(String[] args) throws IOException {

		// SORTU ETA HASIERATU HIZTEGIA (Singleton)

		Hiztegia hiztegia = Hiztegia.getInstance();

		

		// SORTU ETA HASIERATU INTERNET (Singleton)

		Internet internet = Internet.getInstance();
		BZBHitzak zuhaitza = new BZBHitzak();
		hiztegia.setHiztegia(zuhaitza);
		
		internet.hasieratu("index", "smallpld-arc");
		hiztegia.hasieratu("wordsshuffle.txt");
		
		((BZBHitzak) hiztegia.getNireHiztegia()).bahetuHitzGakoak();

		int aukera = 1;
		Scanner sc = new Scanner(System.in);
		String hitza;
		while (aukera != 0) {
			System.out.println("Zer egin nahi duzu?");
			System.out.println("1. Web-orriak bilatu gako-hitzen bidez");
			System.out.println("0. Irten");
			aukera = Integer.parseInt(sc.nextLine());
			switch (aukera) {
			case 1:
				System.out.println("Sartu gako-hitz bat:");
				hitza = sc.nextLine();
				internet.webBilatzailea(hitza);

				break;
			default:
				break;
			}
		}
		sc.close();

	}

}
