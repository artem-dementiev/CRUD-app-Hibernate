package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "library_user")
public class LibraryUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "first_name", nullable = false)
    @Size(max = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(max = 50)
    private String lastName;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;
    private String address;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private UserRole role;

    @NotNull
    @Size(max = 50)
    private String login;

    @NotNull
    @Size(max = 30)
    private String password;

    @NotNull
    @Size(max = 70)
    private String email;

    public LibraryUser() {

    }

    public LibraryUser(String firstName, String lastName, String phoneNumber,
            String address, String login, String password, String email) {
        this.firstName  = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
