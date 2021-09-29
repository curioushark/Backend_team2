package com.ghina.Bank_Team2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "mst_customer")
public class Customer extends BaseEntity{

    @Id
    private String id;

    private int nik;

    private String fullName;

    private String email;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    private String address;

    public String getId(){
        if (id == null || id.equals("")) {
            id = UUID.randomUUID().toString();
        }
        return id;
        }

        public void setId(String id){
        this.id = id;
        }

    public int getNik() {return nik;}

    public void setNik(int nik) {this.nik = nik;}

    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Date getJoinDate() {return joinDate;}

    public void setJoinDate(Date joinDate) {this.joinDate = joinDate;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}
}
