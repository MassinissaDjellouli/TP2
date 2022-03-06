package Models.Users;

public class Employe {
    private final String username;
    private String password;
    private final Role role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Employe(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
