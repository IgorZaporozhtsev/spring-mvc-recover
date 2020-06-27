package com.zeecoder.model;


import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

@EqualsAndHashCode
@Setter
@Getter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String first_name;
    @Column
    private String nickname;
    @Column
    private String password;
    @Column
    private String email;

}
