package com.Mehmet2.UserProject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="KULLANICILAR")
@Data
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name="user_seq_gen",sequenceName = "user_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @Column(name="ID")
    private Long id;

    @Column(name="ISIM")
    private String firstName;

    @Column(name = "SOYAD")
    private String lastName;
}
