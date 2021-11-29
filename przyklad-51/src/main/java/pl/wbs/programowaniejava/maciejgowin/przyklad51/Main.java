package pl.wbs.programowaniejava.maciejgowin.przyklad51;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        PersonData titleData = new PersonData("/tmp/data");

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.print("Podaj imię i nazwisko (lub [w]ypisz, [z]akończ): ");
            String value = input.nextLine();

            if (value.equals("w")) {
                System.out.println(titleData.getPersons());
            } else if (value.equals("z")) {
                break;
            } else {
                if (!titleData.addPerson(value)) {
                    System.out.println("Nie poprawny format: " + value);
                }
            }
        }
    }
}
