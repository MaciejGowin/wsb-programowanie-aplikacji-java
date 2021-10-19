import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastName;
    private int yearOfBirth;

    public Person(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        } else if (lastName != null) {
            return lastName;
        } else if (firstName != null) {
            return firstName;
        } else {
            return null;
        }
    }

    public int getAge() {
        return LocalDate.now().getYear() - yearOfBirth;
    }
}
