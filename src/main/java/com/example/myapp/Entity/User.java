package com.example.myapp.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="tusers")
public class User {
    @Id

    private  String id;
    @Column(name="user_name")
  private String  user_name;
    @Column(name="email_id")
    private String email_id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String  last_name;
    @Column(name="password")
    private String password;
    @Column(name = "company_code")
    private String companyCode;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    private Date updatedDate;



}
