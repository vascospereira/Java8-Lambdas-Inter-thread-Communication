import java.util.Arrays;
import java.util.List;

public class CollectionIteration {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person(Person.Sex.MALE, "Lionel", "Messi", 31),
				new Person(Person.Sex.FEMALE, "Lindsey", "Vonn", 33), new Person(Person.Sex.MALE, "Tiger", "Woods", 42),
				new Person(Person.Sex.FEMALE, "Serena", "Williams", 36),
				new Person(Person.Sex.MALE, "Roger", "Federer", 36));
		// easy to run in multiple threads
		people.forEach(System.out::println);
		// streams
		people.stream().filter(p -> p.getLastName().startsWith("W")).forEach(p -> System.out.println(p.getFirstName()));
		// Use multiple cores
		long count = people.parallelStream().filter(p -> p.getAge() > 35 && p.getSex() == Person.Sex.MALE).count();
		System.out.println(count);
	}
}
