package other_f_arrays;

import java.util.function.BiConsumer;

public class NewOperation {
	public static void main(String[] args) {
		short[] numbers = { (short) 1, (short) 2, (short) 3 };
		int key = 2;

		map(numbers, key, (v, k) -> System.out.println(v + k));

		byte[] transformedArray = transformArray(numbers, s -> (byte) (s * key));

		System.out.print("Transformed array: ");
		for (byte b : transformedArray) {
			System.out.print(b + " ");
		}
	}

	private static byte[] transformArray(short[] numbers, shortToByteFunction f) {
		byte[] result = new byte[numbers.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = f.apply(numbers[i]);
		}

		return result;
	}

	private static void map(short[] numbers, int key, BiConsumer<Integer, Integer> consume) {
		for (int i : numbers) {
			consume.accept(i, key);
		}
	}

	public interface shortToByteFunction {
		byte apply(short s);
	}
}
