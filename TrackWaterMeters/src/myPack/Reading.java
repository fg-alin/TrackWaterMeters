package myPack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reading {

	private static List<Reading> listOfReadings = new ArrayList<>();

	private int year;
	private Months month;
	private int coldWater;
	private int hotWater;

	public Reading(int year, String month, int coldWater, int hotWater) throws Exception {
		this.month = Months.monthValidation(month);
		this.year = Reading.yearValidation(year);
		this.coldWater = coldWater;
		this.hotWater = hotWater;
	}

	public void addReading() throws Exception {

		if ((Reading.findReading(this.year, this.month.toString())).size() > 0) {
			throw new Exception("There is already a reading for this month!");
		}

		if (listOfReadings.stream().anyMatch(cit -> (cit.coldWater > this.coldWater || cit.hotWater > this.hotWater))) {
			throw new Exception("Check again the values!");
		}

		listOfReadings.add(this);
	}

	public static int yearValidation(int an) throws Exception {

		if (an < 1999 || an > 2099) {
			throw new Exception("Invalid year!");
		}
		return an;
	}

	public static List<Reading> findReading(int year, String month) throws Exception {

		List<Reading> listaGasite = new ArrayList<>();

		int validatedYear = Reading.yearValidation(year);

		Months validatedMonth = Months.monthValidation(month);

		listaGasite = listOfReadings.stream().filter(cit -> (cit.year == validatedYear && cit.month == validatedMonth))
				.collect(Collectors.toList());

		return listaGasite;
	}

	public static void removeReading(int year, String month) throws Exception {

		if ((Reading.findReading(year, month)).size() < 1)
			throw new Exception("Reading not found! No change was done.");

		else {
			listOfReadings.removeAll(Reading.findReading(year, month));
			System.out.println("Removed.");
		}

	}

	public void showConsumption() {// Shows the last 2 added months

		if (listOfReadings.size() >= 2) {
			Reading ultima, penultima;

			ultima = listOfReadings.get(listOfReadings.size() - 1);
			penultima = listOfReadings.get(listOfReadings.size() - 2);

			System.out.println("\n\t\t" + penultima.month + " " + penultima.year + "\t" + ultima.month + " " + ultima.year
					+ "\t Consum \n");
			System.out.println("Apa calda" + "\t   " + penultima.hotWater + "\t\t   " + ultima.hotWater + "\t\t   "
					+ (ultima.hotWater - penultima.hotWater));
			System.out.println("Apa rece" + "\t   " + penultima.coldWater + "\t\t   " + ultima.coldWater + "\t\t   "
					+ (ultima.coldWater - penultima.coldWater));

		}
	}

	public void exit() {
		System.exit(0);
	}

}
