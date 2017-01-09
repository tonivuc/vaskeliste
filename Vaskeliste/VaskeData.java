
//////////////////////////////////
/*
- Programmets form�l:
	-Generere en vaskeliste for et kollektiv.
*/
/////////////////////////////////

class VaskeData {

	/* Hver uke:
	Dass ved kj�kkenet
	Dass 1 ved n�dutgang
	Dass 2 ved n�dutgang
	Kj�kkenet
	Gangen skal st�vsuges

	Anenhver uke:
	Bad midt i huset
	Bad bakerst i huset

	Hver 4. Uke
	Gangen skal vaskes [IKKE INTEGRERT, M� LEGGES TIL SENERE]
	*/

	//Globale variabler, ogs� arrayen med data
	private String kollektivNavn = ""; //Konstrukt�ren setter dette

	private String[] BEBOERE = {"Fredrik","August","Li","Joakim","Toni","Sigbj�rn","Torjus","Reso"};
	private String[] BEBOERE2 = {"Toni","Sigbj�rn","Torjus","Reso","Fredrik","August","Li","Joakim"}; //Hver array er alltid 4 bak den forrige

	private final String[] PARTALLSUKE = {"Vaske kj�kkenet","Vaske de to toalettene ved n�dutgangen","St�vsuge gangen/inngangspariet","Vaske badet og toalettet ved kj�kkenet"};
	private final String[] ODDETALLSUKE = {"Vaske kj�kkenet","Vaske de to toalettene ved n�dutgangen","St�vsuge gangen/inngangspartiet","Vaske badet midt i huset og toalettet ved kj�kkenet"};
	private int antallBeboere = BEBOERE.length;
	private int ukeN�; //Uken vi starter med

	String[] beboereNy; //Array vi jobber med
	String[] beboereNy2; //Enda en array pga. at vi jobber annenhver uke

	//Konstrukt�r
	public VaskeData(String kollektivNavn,int ukeStart) {
		this.kollektivNavn = kollektivNavn;
		ukeN� = ukeStart;
		beboereNy = new String[antallBeboere];
		beboereNy2 = new String[antallBeboere];

		for (int i = 0; i < antallBeboere; i++) {
			beboereNy[i] = new String(BEBOERE[i]);
			beboereNy2[i] = new String(BEBOERE2[i]);
		}
	}

	//Immutable Get-Metoder
	public String arrayTilString(String[] tabell) {
		String output = "";
		for (int i = 0; i < tabell.length; i++) {
			output = output + tabell[i] + "\n";
		}
		return output;
	}

	public String skrivUtBeboere() {
		return arrayTilString(beboereNy);
	}

	public String skrivUtOppgaver() {
		return arrayTilString(PARTALLSUKE);
	}

	//Mutable metoder
	public String[] flyttFolkFram(String[] beboerTabell) { //Denne metoden beveger alle i arrayet beboereNy ett hak frem, eventuelt tilbake helt bakerst i tabellen.
		//Dyp kopi av tabell
		String[] arbeidsTabell = new String[antallBeboere];
		for (int i = 0; i < antallBeboere; i++) {
			arbeidsTabell[i] = beboerTabell[i];
		}

		for (int i = 0; i<antallBeboere; i++) {

			if (i < (antallBeboere-1)) {
				arbeidsTabell[i+1] = beboerTabell[i];
			}

			else if (i == (antallBeboere -1)) {
				arbeidsTabell[0] = beboerTabell[i];
			}
		}
		//beboereNy = arbeidsTabell; //Ikke helt bra dette, men greit nok for n� (Burde vel kopieres skikkelig?)
		return arbeidsTabell;
	}

	public String skrivUtUke() { //Bruker de arraysene som ligger i klassen
		String output = "";
		for (int i = 0; i < 4; i++) {
			if ((ukeN� % 2) == 0) { //Partallsuke
				output = output + beboereNy[i] + ": " + PARTALLSUKE[i] + "\n";
			}
			else  {//Oddetallsuke
				output = output + beboereNy2[i] + ": " + ODDETALLSUKE[i] + "\n";
			}
		}
		return output;
	}

	public String skrivUtUker(int uker) {
		String output = "";
		for (int i = ukeN�; ukeN� < uker+1; ukeN�++) {
			output = output + "\n" + "Uke: " + ukeN� + "\n" + skrivUtUke();
			if ((ukeN� % 2) == 0) { //Partallsuke
				beboereNy = flyttFolkFram(beboereNy);
			}
			else {
				beboereNy2 = flyttFolkFram(beboereNy2);
			}
		}
		return output;
	}
}