package com.naat.bontu.api.bontu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Getter
    @Setter
    @Column(length = 45)
    private String user;
    
}
