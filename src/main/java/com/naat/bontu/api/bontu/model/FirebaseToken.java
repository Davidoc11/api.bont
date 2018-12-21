package com.naat.bontu.api.bontu.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class FirebaseToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Getter
    @Setter
    private Long number;
    @Getter
    @Setter
    private String token;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "USER_ID",unique = true)
    private User user;
}
