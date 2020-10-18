import java.util.Locale;
import java.util.Scanner;

public class Main {

	static double x;
	static int n;
	static double EPS;

	/*
	(2i-1)(2i-1)(2i-1)x^2
	---------------------
	      2i * (2i+1)
	 */

    public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
    	Cin();
		Cout();
	// Уже все работает
	//	Test(n);    //  Summary test for epsilon // n - number of solutions
	//	Test2(EPS);  // number test for epsilon
	//	Test3 (n);   // number test for n // n - number of numbers
	// при EPS == 0,00000001 не работает
	// предел для n == 19965
    // 0,9 19965 0,000001
    }

    
    public static double SummaryOfN(int n){
    	double num = x;
    	double s = 0;
    	double j = 0;
    	s += x;
    	for (int i = 1;i < n;i++){
    		j = i;
			num *= SolutionForAdd(j,x);
			s = (i % 2 == 0 ) ? s + num : s - num;
		}
    	return s;
	}

	public static double SummaryOfGreaterE1e(double e){
		double num = x;
		double s = 0;
		double j = 0;
		s += x;
		for (int i = 1;Math.abs(num) > e/10;i++){
			j = i;
			num *= SolutionForAdd(j,x);
			s = (i % 2 == 0 ) ? s+num : s - num;
		}
		return s;
	}

	public static double SummaryOfGreaterE0e(double e){
		double num = x;
		double s = 0;
		double j = 0;
		s += x;
		for (int i = 1;Math.abs(num) > e;i++){
			j = i;
			num *= SolutionForAdd(j,x);
			s = (i % 2 == 0 ) ? s+num : s - num;
		}
		return s;
	}

	public static double SolutionForAdd(double i,double x){

		return (2*i-1) * x * x * (2*i-1)  / (2 * i * (2*i+1));
	}

	public static void Cin(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите х от -1 до 1 не включая");
		x = scanner.nextDouble();
		if (x<1 && x>-1){
			System.out.println("Введите N");
			n = scanner.nextInt();
			System.out.println("ВВедите E");
			EPS = scanner.nextDouble();
		}
		else{
			System.exit(-1);
		}


	}

	public static void Cout(){
		System.out.println("Summary of N =            " + SummaryOfN(n));
		System.out.println("Summary while > EPS =     " + SummaryOfGreaterE0e(EPS));
		System.out.println("Summary while > EPS/10 =  " + SummaryOfGreaterE1e(EPS));
		System.out.println("Just ln =                 " + Math.log(x+Math.sqrt(x*x+1)));


	}

	public static void Test(int n){
    	for (int i = 0;i < n;i++ ){
			System.out.println("E = " + Math.pow(10,-i));
			System.out.println(SummaryOfGreaterE1e(Math.pow(10,-i)));
			System.out.println(SummaryOfGreaterE0e(Math.pow(10,-i)));
			System.out.println(Math.log(x+Math.sqrt(x*x+1)));
			System.out.println("-------------------------------------");
		}
	}

	public static void Test2(double e){
		double num = x;
		for (int i = 1;Math.abs(num) > e;i++){
			num =  ((num * (2*i-1)) * x * x  * (2*i-1)) / (2 * i * (2*i+1));
			System.out.println("i =" + i + " num =" + num);
		}
	}

	public static void Test3(int n){
		double num = x;
		for (int i = 1;i < n ;i++){
			num =  ((num * (2*i-1)) * x * x  * (2*i-1)) / (2 * i * (2*i+1));
			System.out.println("i =" + i + " num =" + num);
		}
	}

}
