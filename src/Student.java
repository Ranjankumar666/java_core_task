package src;

public class Student {
    private String firstname;
    private String lastname;
    private String email;

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return firstname + "," + lastname + "," + email;
    }

}