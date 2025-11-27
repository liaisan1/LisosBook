package models;


public class User {
    private long id;
    private String username;
    private String email;
    private String passwordHash;
    private String role;

    public User(long id, String username, String email, String passwordHash, String role) {}

    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getRole() {return role;}

    public void setId(long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setRole(String role) {this.role = role;}
}