package entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "public", name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "role_name", nullable = false, unique = true)
    @Size(max = 30)
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryUser> users = new ArrayList<>();

    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<LibraryUser> getUsers() {
        return users;
    }

    public void setUsers(List<LibraryUser> users) {
        this.users = users;
    }
}
