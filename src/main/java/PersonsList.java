import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        persons = new ArrayList<>();
    }

    // Add a Person to the list
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Find a Person by name (exact match)
    public Person findByName(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person with name '" + name + "' not found.");
    }

    // Clone a Person with a new id
    public Person clonePerson(Person originalPerson, int newId) {
        return new Person(newId, originalPerson.getName(), originalPerson.getAge(), originalPerson.getOccupation());
    }

    // Write Person information to a file
    public void writePersonToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Example usage
    public static void main(String[] args) {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Josh Rivera", 30, "AI Engineer");
        Person person2 = new Person(2, "MR.Anderson", 25, "Data Scientist");

        personsList.addPerson(person1);
        personsList.addPerson(person2);

        try {
            Person foundPerson = personsList.findByName("Josh Rivera");
            System.out.println("Found person: " + foundPerson.getName());

            Person clonedPerson = personsList.clonePerson(person1, 3);
            System.out.println("Cloned person: " + clonedPerson.getName());

            personsList.writePersonToFile(person2, "person_info.txt");
            System.out.println("Person information written to file.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
