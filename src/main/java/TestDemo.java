import java.util.Random;

public class TestDemo {

	// making a random number for the method below
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	// using the random number to multiply it by itself 
	 public int randomNumberSquared() {
		 return (getRandomInt() * getRandomInt());
	 }
	
	//method for adding two numbers greater than 0
	public int addPositive(int a, int b) {
		if ( a >= 1 && b >= 1 ) {
			return (a + b); }
		else   {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
	}
}
