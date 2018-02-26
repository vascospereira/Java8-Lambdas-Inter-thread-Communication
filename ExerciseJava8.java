import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExerciseJava8 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person(Person.Sex.MALE, "Lionel", "Messi", 31),
				new Person(Person.Sex.FEMALE, "Lindsey", "Vonn", 33),
				new Person(Person.Sex.MALE, "Tiger", "Woods", 42),
				new Person(Person.Sex.FEMALE, "Serena", "Williams", 36),
				new Person(Person.Sex.MALE, "Roger", "Federer", 36)
				);
				
		//Sort by last first name
		Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		printConditionally(people, p -> true, p -> p.getFirstName(), p -> System.out.println(p));
		System.out.println("All people with last name starting with W:");
		printConditionally(people, p -> p.getLastName().startsWith("W"), p-> p.getFirstName(), p -> System.out.println(p));
		System.out.println("All people with 36 years old:");
		printConditionally(people, p -> p.getAge() == 36, p -> p.getFirstName(), name -> System.out.println(name));
		
	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate, Function<Person, String> mapper, Consumer<String> consumer) {
		for (Person person : people) {
			if(predicate.test(person)){
				String firstName = mapper.apply(person);
				consumer.accept(firstName);
			}
		}
	}
}
