import java.util.Scanner;
import java.util.Scanner.*;

public class Driver {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		// %%%%%%%%%%%%%%%%%%%% QUESTION 2 %%%%%%%%%%%%%%%%%%%%%%%
		
		int curve = -1;
		float grade = (float) -0.0;
		// Create the Scanner code to gather a float and an integer using the variables already created
		System.out.println("Please enter the grade you received: ");
		// code here
		grade = sc.nextFloat();
		System.out.println("Please enter the curve percentage you will receive: (example 5%) ");
		// code here
		curve = sc.nextInt();
		
		
		// just for a hint for the integer (Integer) portion, try below:
		// https://docs.oracle.com/javase/8/docs/api/?java/lang/Integer.html
		

		System.out.println("Here are the values collected");
		// Display both values collected using a System.out.println
		System.out.println("grade: " + grade + " curve: " + curve);
		
		
		
		// %%%%%%%%%%%%%%%%%%%% QUESTION 2 %%%%%%%%%%%%%%%%%%%%%%%
		
		// %%%%%%%%%%%%%%%%%%%% QUESTION 3 %%%%%%%%%%%%%%%%%%%%%%%
		
		// Using the variables and the new values received (curve and grade), call the curvedGrade  
		// (first one) function from here and display the results the function returns here
		// 1. fix the curvedGrade function below. Remember, if you get a 90, with 10% curve, you now have a 99%
		// 2. call function
		// 3. display result
		float curvgrade = curvedGrade(80, 5);
		System.out.println("Curved grade: " + curvgrade);
					
		// %%%%%%%%%%%%%%%%%%%% QUESTION 3 %%%%%%%%%%%%%%%%%%%%%%%
		
		// %%%%%%%%%%%%%%%%%%%% QUESTION 4 %%%%%%%%%%%%%%%%%%%%%%%
		
		// Create instance of a Student here
		Student temp = new Student("Bob", "the Builder", 90);
		// call and pass STUDENT and a curved value to curvedGrade (second one) function
		curvedGrade(temp, 3);
		// display the new results ONLY using the "get" Student class functions
		System.out.println(temp.getfirstName() + " " + temp.getlastName() + " " + temp.getscore());
		
		// display the new results ONLY using the "toString" Student class functions
		System.out.println(temp);
		
		// %%%%%%%%%%%%%%%%%%%% QUESTION 4 %%%%%%%%%%%%%%%%%%%%%%%
		
		// %%%%%%%%%%%%%%%%%%%% QUESTION 5 %%%%%%%%%%%%%%%%%%%%%%%
		
		int value1 = 23;
		float value2 = (float) 23.5;
		String value3 = "Lupoli";
		int [] value4 = {2,3,4,5};

		// using the values directly above, call the passingExercise function
		// notice the displays below. Which values were changed by the function??
		passingExercise(value1, value2, value3, value4);
		System.out.println("Here is the resulting value for value1->" + value1);
		System.out.println("Here is the resulting value for value2->" + value2);
		System.out.println("Here is the resulting value for value3->" + value3);
		System.out.println("Here is the resulting value for value4->" + value4);
		
		// no values were change with passingExercise
		
		
		// %%%%%%%%%%%%%%%%%%%% QUESTION 5 %%%%%%%%%%%%%%%%%%%%%%%
		
		
		System.out.println("Program complete.");
	}
	
	// Using the variables and the new values received (curve and grade), call the curvedGrade  
			// (first one) function from here and display the results the function returns here
			// 1. fix the curvedGrade function below. Remember, if you get a 90, with 10% curve, you now have a 99%
			// 2. call function
			// 3. display result
			public static float curvedGrade(float thisGrade, int percentCurve)
			{
				float result = 0; // default value
				
				// create the code to get this function to truely work
				float curvefloat = (float) (percentCurve * 0.01 + 1);
				result = thisGrade * curvefloat;
				
				return result;
			}

	public static void curvedGrade(Student thisStudent, int percentCurve)
	{
		// reset value WITHIN the Student instance to new curved grade!!
		float newgrade = curvedGrade(thisStudent.getscore(), percentCurve);
		thisStudent.setscore(newgrade);
	}
	
	public static void passingExercise(int x, float y, String z, int [] array)
	{
		x = x * 10;
		y = y * 10;
		z += 'Z';
		array[0] = -23;
	}

}
