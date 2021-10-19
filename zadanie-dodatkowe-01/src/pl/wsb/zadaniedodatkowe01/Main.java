package pl.wsb.zadaniedodatkowe01;

public class Main {

    public static void main(String[] args) {
        Person[] persons = {
                Person.constructPerson("Jan", "Nowak"),
                Person.constructPerson("Anna", "Kowalski"),
                Person.constructPerson("Ewa", "Nowak"),
                Person.constructPerson("Antoni", "Kowalski"),
                Person.constructPerson("Marek", "Starski"),
                Person.constructPerson("Andrzej", "Kowalski")
        };

        familyMembers("Kowalski", persons);
        familyMembers("Nowak", persons);
        familyMembers("Starski", persons);
        familyMembers("Owczarek", persons);
    }

    public static void familyMembers(String lastName, Person[] persons) {
        String familyMembers = "";
        boolean isNextPerson = false;
        for (Person person: persons) {
            if (person.lastName == lastName) {
                if (isNextPerson) {
                    familyMembers += ", ";
                }
                familyMembers += person.getFullName();
                isNextPerson = true;
            }
        }

        if (familyMembers == "") {
            familyMembers = "none";
        }

        System.out.println("Family members: " + familyMembers);
    }
}
