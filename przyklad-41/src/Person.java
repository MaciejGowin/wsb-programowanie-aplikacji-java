public class Person {

    private String name;
    private Integer yearOfBirth;

    public Person(String name, Integer yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format("{name: \"%s\", yearOfBirth: \"%s\"}", name, yearOfBirth);
    }
}
