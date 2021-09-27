package com.jdt8.bank.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    private String createdBy;

    private Date createDateTime;

    private String updatedBy;

    private Date updatedDateTime;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    @PrePersist
    private void onCreate() {
        this.createDateTime = new Date();
        this.createdBy = "admin";
        this.updatedBy = this.createdBy;
        this.updatedDateTime = this.createDateTime;
    }

    @PreUpdate
    private void onUpdate() {
        this.updatedBy = "admin";
        this.updatedDateTime = new Date();
    }

}
