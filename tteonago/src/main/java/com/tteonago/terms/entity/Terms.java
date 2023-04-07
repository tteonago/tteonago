package com.tteonago.terms.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

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
