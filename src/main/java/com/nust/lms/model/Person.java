/**
 * Abstract class demonstrates INHERITANCE and ABSTRACTION.
 * Common state/behavior for different people types is placed here.
 */
public abstract class Person {
    // ENCAPSULATION: fields are private and accessed through getters.
    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
