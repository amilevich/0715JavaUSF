package com.questionfifteen.calculate;

public class TestClass implements Calculations{
	
	public static void main(String[] args) {
	
	Calculations calculator = new MyClass();
    double operand1 = 50;
    double operand2 = 2;
	
	System.out.println("Addition: "+ calculator.addition(operand1,operand2));
    System.out.println("Subtraction: "+ calculator.subtraction(operand1,operand2));
    System.out.println("Multiplication: "+ calculator.multiplication(operand1,operand2));
    System.out.println("Division: "+ calculator.division(operand1,operand2));
    
	
}
		@Override
		public double addition(double a, double b) {
			// TODO Auto-generated method stub
			return a+b;
		}

		@Override
		public double subtraction(double a, double b) {
			// TODO Auto-generated method stub
			return a-b;
		}

		@Override
		public double multiplication(double a, double b) {
			// TODO Auto-generated method stub
			return a*b;
		}

		@Override
		public double division(double a, double b) {
			// TODO Auto-generated method stub
			return a/b;
		}

}	