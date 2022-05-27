package myPack;

public enum Months {

	IAN("IAN"), FEB("FEB"), MAR("MAR"), APR("APR"), MAI("MAI"), IUN("IUN"), IUL("IUL"), AUG("AUG"), SEP("SEP"),
	OCT("OCT"), NOI("NOI"), DEC("DEC");

	private Months(String denumire) {
		this.denumire = denumire;
	}

	private String denumire;

	public static Months findMonth(String nume) {
		for (Months luna : Months.values()) {
			if (luna.denumire.equals(nume)) {
				return luna;
			}
		}
		return null;
	}

	public static Months monthValidation(String luna) throws Exception {

		if ((luna.length() < 3) || Months.findMonth(luna.substring(0, 3).toUpperCase()) == null) {
			throw new RuntimeException("Check the name of the month!");
		}
		return Months.findMonth(luna.substring(0, 3).toUpperCase());

	}
}
