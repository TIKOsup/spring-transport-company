package kz.iitu.FinProject.model;

public enum Role {
    User("USER"), Admin("ADMIN");

    public final String role;

    Role(String role){
        this.role = role;
    }
}
