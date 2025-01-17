package exercise1;

public class main {

	public static void main(String[] args) {
		// create new PredatoryCreditCard  newCard
		PredatoryCreditCard newCard = new PredatoryCreditCard("Michael", "Payday", "1111 1111 1111 1111", 2500, 0, 0.0825);
		// charge 1000 to newCard
		newCard.charge(1000);
	    CreditCard.printSummary(newCard);
	}

}
