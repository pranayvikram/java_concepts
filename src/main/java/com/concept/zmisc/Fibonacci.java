package zmisc;

public class Fibonacci {
	
	public static void main(String args[]) {
		
		Fibonacci dd = new Fibonacci();
		dd.test(97);
	}
	
	private void test(int num) {
		
		boolean flag = true;
		for(int i = 2; i <= num/2; ++i) {
			if(num % i == 0) {
				flag = false;
				break;
			}
		}
		System.out.println("Answer: " + flag);
	}
}
