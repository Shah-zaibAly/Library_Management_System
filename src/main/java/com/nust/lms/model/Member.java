/**
 * Member INHERITS from Person.
 * This reuses common fields (id, name) and can add member-specific behavior.
 */
public class Member extends Person {
    private final String email;

    public Member(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{id=" + getId() + ", name='" + getName() + "', email='" + email + "'}";
    }
}
