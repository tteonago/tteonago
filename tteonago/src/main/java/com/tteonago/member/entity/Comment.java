package com.tteonago.member.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cId; 

    @NotNull
    @Column(name = "contents") 
    private String contents;

    @NotNull
    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "deleted")
    private boolean deleted;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freeboard") 
    private Freeboard freeboard;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username") 
    private Member member;

    public void add(Comment comment) {
    }
    public void remove(Comment comment) {
    }
    public void setPost(Freeboard freeboard) {
    }
}