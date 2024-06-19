public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    // Constructor
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public Person(Person originalPerson, int newId) {
    }

    // Set age method
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    // Equals method
    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name) &&
                this.age == otherPerson.age &&
                this.occupation.equals(otherPerson.occupation);
    }

    // Getters (optional)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
    // Example usage
    public static void main(String[] args) {
        Person person1 = new Person(1, "Josh Rivera", 30, "AI Engineer");
        Person person2 = new Person(2, "MR.Anderson", 25, "Data Scientist");

        System.out.println("Are person1 and person2 equal? " + person1.equals(person2));
    }
}
