package exercise2;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeometricProgression progressionOne = new GeometricProgression(10);
		progressionOne.printProgression(10);
		
		ArithmeticProgression progressionTwo = new ArithmeticProgression(10);
		progressionTwo.printProgression(10);
		
		FibonacciProgression progressionThree = new FibonacciProgression(10,100);
		progressionThree.printProgression(10);
	}

}
