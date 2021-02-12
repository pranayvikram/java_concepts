package com.concept.lambdaFunction;

public class Greeter {

	public static void main (String... strings) {
		
		Greeter greeter = new Greeter();
		
		greeter.conceptFirst();
		
		greeter.conceptSecond();
		
	}
	
	public void greet(GreetingFunctionInterface greetingInter) {
		
		greetingInter.perform();
	}
	
	private void conceptFirst() {
		
		Greeter greeter = new Greeter();
		
		LembdaWorldGreeting lembdaWorldGreeting = new LembdaWorldGreeting();
		lembdaWorldGreeting.perform();
		greeter.greet(lembdaWorldGreeting);
		
		GreetingFunctionInterface greeinginFunction = () -> System.out.println(" Hello Lambda World !!!");
		greeinginFunction.perform();
		
		
		// When you use an interface to declare a lambda expression, 
		// it should have only one abstract method (but default methods are allowed).
		GreetingFunctionInterface grtPerf = () -> System.out.println(" Hello Lambda World !!!!");
		grtPerf.perform();

		// () signature should match with any Interface which has single method declaration with same signature;
		GreetingFunction grtFunc = () -> System.out.println(" Hello Lambda World !!!!!");
		grtFunc.greetingFunction();
		
		// (int a) signature should match with any Interface which has single method declaration with same signature;
		DoubleNumberFunctionInterface dblNumFunc = (int a) -> a * 2;
		int doubleResult = dblNumFunc.doubleNumberFunction(2);
		System.out.println("Double: " + doubleResult);
		
		// (int a, int b) signature should match with any Interface which has single method declaration with same signature;
		AddFunctionInterface addFunc = (int a, int b) -> a + b;
		int additionResult = addFunc.addFunction(2, 4);
		System.out.println("Addition: " + additionResult);
		
		SafeDivisionFunctionInterface safeDivFunc = (int a, int b) -> {
			if(b == 0) return 0;
			return a / b;
		};
		
		int divisionResult = safeDivFunc.safeDivisionFunction(2, 3);
		System.out.println("Safe division: " + divisionResult);
		
		StringLengthCountFunctionInterface strLenCountFunc = (String str) -> str.length();
		int stringResult = strLenCountFunc.stringLengthCountFunction("StringLength");
		System.out.println("String Length Count: " + stringResult); 
	}
	
	private void conceptSecond() {
		
		Greeter greeter = new Greeter();
		
		LembdaWorldGreeting lembdaWorldGreeting = new LembdaWorldGreeting();
		lembdaWorldGreeting.perform();
		greeter.greet(lembdaWorldGreeting);
		
		
		GreetingFunctionInterface greeinginFunction = () -> System.out.println(" Hello Lambda World !!");
		greeinginFunction.perform();
		
		
		// Anonymous inner class: In line implementation of an interface
		GreetingFunctionInterface innerClassGreeting = new GreetingFunctionInterface() {
			public void perform () {
				System.out.println(" Hello Lambda World !!");
			}
		};
		
		innerClassGreeting.perform();
	}
	
}

interface  GreetingFunction {
	
	void greetingFunction();
}

interface  DoubleNumberFunctionInterface {
	
	int doubleNumberFunction(int a);
}

interface  AddFunctionInterface {
	
	int addFunction(int a, int b);
}

interface  SafeDivisionFunctionInterface {
	
	int safeDivisionFunction(int a, int b);
}

interface StringLengthCountFunctionInterface {
	
	int stringLengthCountFunction(String a);
}
