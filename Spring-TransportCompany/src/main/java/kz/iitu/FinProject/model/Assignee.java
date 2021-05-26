package kz.iitu.FinProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    @Column(name = "username", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String username;
    @Column(name = "password", nullable = false, updatable = true, columnDefinition = "TEXT")
    private String password;
    @Column(name = "change_date", updatable = true, columnDefinition = "DATE")
    private Date changeDate;

    public Assignee() {
        changeDate = new Date(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        changeDate = new Date(System.currentTimeMillis());
    }

    public Date getChangeDate() {
        return changeDate;

    }
}
