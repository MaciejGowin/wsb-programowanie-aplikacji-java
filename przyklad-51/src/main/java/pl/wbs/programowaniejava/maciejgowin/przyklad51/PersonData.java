package pl.wbs.programowaniejava.maciejgowin.przyklad51;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.wbs.programowaniejava.maciejgowin.przyklad51.StringUtils.COMMA;
import static pl.wbs.programowaniejava.maciejgowin.przyklad51.StringUtils.SPACE;
import static pl.wbs.programowaniejava.maciejgowin.przyklad51.StringUtils.compare;

public class PersonData {

    private final Path filePath;
    private final List<Person> persons;

    public PersonData(String filePathString) throws Exception {
        filePath = Path.of(filePathString);
        persons = Files.readAllLines(filePath).stream()
                .map(line -> Person.fromSeparated(line, COMMA))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public boolean addPerson(String name) throws Exception {
        boolean added = Person.fromSeparated(name, SPACE)
                .map(person -> {
                    persons.add(person);
                    return true;
                })
                .orElse(false);

        if (added) {
            Files.writeString(
                    filePath,
                    getPersons().stream().map(person -> person.toSeparated(",")).collect(Collectors.joining("\n")));
        }
        return added;
    }

    public List<Person> getPersons() {
        return persons.stream()
                .sorted((p1, p2) -> {
                    int compare = compare(p1.getLastName(), p2.getLastName());
                    if (compare == 0) {
                        compare = compare(p1.getFirstName(), p2.getFirstName());
                    }
                    return compare;
                })
                .distinct()
                .collect(Collectors.toList());
    }
}
