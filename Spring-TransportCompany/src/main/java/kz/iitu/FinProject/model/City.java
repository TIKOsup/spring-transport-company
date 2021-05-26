package kz.iitu.FinProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "change_date", nullable = false, columnDefinition = "DATE")
    private Date changeDate;

    public City() {
        changeDate = new Date(System.currentTimeMillis());
    }

    public City(String name) {
        this.name = name;
        changeDate = new Date(System.currentTimeMillis());
    }

    public City(long id, String name) {
        this.name = name;
        this.id = id;
        changeDate = new Date(System.currentTimeMillis());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.changeDate = new Date(System.currentTimeMillis());
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getChangeDate() {
        return changeDate;
    }
}
