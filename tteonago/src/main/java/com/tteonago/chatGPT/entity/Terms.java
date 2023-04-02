package com.tteonago.chatGPT.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
