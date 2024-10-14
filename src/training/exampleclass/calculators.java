package training.exampleclass;

public class calculators {
	public int add(int num1 , int num2) {
		int result = num1 + num2;
		return result;
	}
	// method overloading 
	public int add(int num1, int num2, int num3) {
		int result = num1 + num2 + num3;
		return result;
	}
	public double add(double num1 , int num2) {
		double result = num1 + num2;
		return result;
	}

	public int sub(int num1,int num2){
        return (num1 - num2);
    }

    public int multi(int num1,int num2){
        return (num1 * num2);
    }

    public double div(double num1,double num2){
        return (num1 / num2);
}
}

