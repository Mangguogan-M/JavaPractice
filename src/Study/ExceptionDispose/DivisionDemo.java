package Study.ExceptionDispose;

public class DivisionDemo {
	
	public static void division(String strNum1, String strNum2) throws Exception{
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 / num2;
		System.out.println("result = " + result);
	}
	
	
	public static void main(String[] args) {
		try {
			division("123", "abc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
