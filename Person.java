public class Person {
	public enum Sex {
		MALE, FEMALE
	}

	private Sex sex;
	private String firstName;
	private String lastName;
	private int age;

	public Person(Sex sex, String firstName, String lastName, int age) {
		this.sex = sex;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [sex=" + sex + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
