package com.ghina.Bank_Team2.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    private String createdBy;

    private Date createDateTime;

    private String updateBy;

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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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
        this.updateBy = this.createdBy;
        this.updatedDateTime =  this.createDateTime;
    }
    @PreUpdate
    private void onUpdate(){
        this.updateBy = "admin";
        this.updatedDateTime = new Date();
    }

}
