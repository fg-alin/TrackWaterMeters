//# This program keeps a simple track of water meter readings for a customer.

package myPack;

//import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Reading cit1 = new Reading(1999, "ian", 23, 17);
		Reading cit2 = new Reading(2000, "fEbruarie", 33, 22);
		Reading cit3 = new Reading(2001, "Martie", 43, 27);

		Reading cit4 = new Reading(2002, "ian", 53, 32);
		Reading cit5 = new Reading(1999, "mar", 64, 33);

		cit1.addReading();
		cit2.addReading();
		cit3.addReading();

		cit4.addReading();
		cit5.addReading();

		// #Experimental:
		
//		  { Scanner scan = new Scanner(System.in);
//		  
//		  System.out.print("Introduceti anul: "); int an = scan.nextInt();
//		  System.out.print("Introduceti luna: "); String lun = scan.next();
//		  System.out.print("Introduceti indicatia pentru apa rece: "); int apaR =
//		  scan.nextInt();
//		  System.out.print("Introduceti indicatia pentru apa calda: "); int apaC =
//		  scan.nextInt();
//		  
//		  Reading citX = new Reading(an, lun, apaR, apaC); citX.addReading();
//		  
//		  scan.close(); }
//		 
		
		Reading.removeReading(2002, "ian");
		Reading.removeReading(2001, "mar");

		cit1.showConsumption();

	}
}
