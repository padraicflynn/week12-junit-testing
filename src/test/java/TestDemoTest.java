import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.provider.MethodSource;
 

class TestDemoTest {
	
	private  TestDemo testDemo;

	
	// making a new test demo object 
	
	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	
	
	
	
	
	//testing random number squared 
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		                      //spy is looking at the class for the method (randomNumberSquared()
		TestDemo mockDemo = spy(testDemo);
		
		
		// put the 5 in as the variable when the mock demo pretends to be get random int method 
		doReturn(5).when(mockDemo).getRandomInt();
		
		
		                   //int fivesquared should be equal to the mocked method of random number squared 
		int fiveSquared = mockDemo.randomNumberSquared();
		
		
		//confirm that fivesquared is 25
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
		@Test
		void assertThatNumberSquaredIsCorrectUsingASix() {
		//making a second test for number squared 
		
		TestDemo mockDemoSecondTest = spy(testDemo);
		
		doReturn(6).when(mockDemoSecondTest).getRandomInt();
		
		int sixSquared = mockDemoSecondTest.randomNumberSquared();
		
		assertThat(sixSquared).isEqualTo(36);
		
		}
		
		
		@Test
		void assertThatNumberSquaredIsCorrectUsingANegativeNumber() {
		//make a third test for random number square using something that will have a negative number 
		
		TestDemo mockDemoNegative = spy(testDemo);
		
		doReturn(-4).when(mockDemoNegative).getRandomInt();
		
		int negativeFourSquared = mockDemoNegative.randomNumberSquared();
		
		assertThat(negativeFourSquared).isEqualTo(16);
		
	}
	
	
	
	
	
	 
	
	//Testing the adding number method
	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	 void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException ) {
	
		
		// asking if we expect an exception or not. if false than it's a double negative with the '!', so it'll pass. if the argument below is true than it should raise a throwable. 
		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		
		else { 
			  assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class); 
	}
		
	//close adding number test method 	
	}	
	
	//provide variables for adding positive test, method source looks for this method to plug in numbers to add and their sum, we have !expectException, so the Boolean will be opposite false 
		static Stream<Arguments> argumentsForAddPositive() {
			// @formatter:off
			return Stream.of(
					 
					arguments(5, 5, 10, false),
					arguments(-1, -1, -2, true),
					arguments(0, 12, 12, true),
					arguments(-5, 10, 5, true),
					arguments(4, 3, 7, false)
					);
		  // @formatter:on
			}
		
 //close class
}

