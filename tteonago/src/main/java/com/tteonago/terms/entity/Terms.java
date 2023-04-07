package com.tteonago.terms.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "terms")
public class Terms {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tId;

    @Column(name = "contents", length = 10000)
    private String contents;

    @Column(name = "createDate")
    private LocalDateTime createDate;

}
