
public class ClosureExample {

	public static void main(String[] args) {
		int a = 20;
		int b = 30; // final variable
		process(a, i -> System.out.println(i + b));
	}
	
	private static void process(int i, Process p) {
		p.process(i);
	}

	interface Process{
		void process(int i);
	}

}
