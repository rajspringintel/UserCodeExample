package com.example.myapp.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="company")
public class Company {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private String id;
@Column(name="company_code")
private String company_code;
@Column(name="nation")
private String nation;


    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<User> users;

}
