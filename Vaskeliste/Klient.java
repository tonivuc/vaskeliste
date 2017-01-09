class Klient {
	public static void main(String[]args) {
	VaskeData penthouse = new VaskeData("The Pent House",2);

	System.out.println("Beboere:\n"+penthouse.skrivUtBeboere());
	System.out.println("\n"+penthouse.skrivUtOppgaver());

	System.out.println(penthouse.skrivUtUker(23));


	}
}