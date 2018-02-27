package question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Operation {

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4);
		List<Character> charList = Arrays.asList('H', 'E', 'L', 'L', 'O');
		
		Function<Integer, Integer> square = n -> n * n;
		Function<Double, Double> plusOneHalf = n -> n + 1.5;
		Function<Character, Integer> chars = n ->  (int)n;
		
		System.out.println(map(plusOneHalf, doubleList));
		System.out.println(map(square, intList));
		System.out.println(map(chars, charList));

	}

	public static <E, T> List<T> map(Function<E, T> f, List<E> l) {
		List<T> result = new ArrayList<>();
		for (E i : l) {
			result.add(f.apply(i));
		}
		return result;
	}
}
