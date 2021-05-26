package kz.iitu.FinProject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "description")
    private String description;
    @Column(name = "assignee_id")
    private long assigneeId;
    @Column(name = "origin_branch_id")
    private long originBranchId;
    @Column(name = "destination_branch_id")
    private long destinationBranchId;
    @Column(name = "origin_city_id")
    private long originCityId;
    @Column(name = "destination_city_id")
    private long destinationCityId;
    @Column(name = "status", columnDefinition = "TEXT")
    private String status;
    @Column(name = "change_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime changeDate;

    public Task() {
        changeDate = LocalDateTime.now();
    }

    public void setDescription(String description) {
        this.description = description;
        changeDate = LocalDateTime.now();
    }

    public void setAssigneeId(long assigneeId) {
        this.assigneeId = assigneeId;
        changeDate = LocalDateTime.now();
    }

    public void setOriginBranchId(long originBranchId) {
        this.originBranchId = originBranchId;
        changeDate = LocalDateTime.now();
    }

    public void setDestinationBranchId(long destinationBranchId) {
        this.destinationBranchId = destinationBranchId;
        changeDate = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOriginCityId(long originCityId) {
        this.originCityId = originCityId;
        changeDate = LocalDateTime.now();
    }

    public void setDestinationCityId(long destinationCityId) {
        this.destinationCityId = destinationCityId;
        changeDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getAssigneeId() {
        return assigneeId;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOriginBranchId() {
        return originBranchId;
    }

    public long getDestinationBranchId() {
        return destinationBranchId;
    }

    public long getOriginCityId() {
        return originCityId;
    }

    public long getDestinationCityId() {
        return destinationCityId;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }
}
