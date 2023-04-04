package com.tteonago.member.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "freeboard")
public class Freeboard {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fId; //pk

    @NotNull
    @Column(name = "title") //제목
    private String title;

    @NotNull
    @Column(name = "contents") //내용
    private String contents;

    @NotNull
    @Column(name = "hits") //조회수
    private int hite;

    @NotNull
    @Column(name = "createdDate") //작성날짜
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modifiedDate") //수정날짜
    private LocalDateTime modifiedDate;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username") //작성자
    private Member member;

    @NotNull
    @Column(name = "deleted") //삭제
    private boolean deleted = false;

    @OneToMany(mappedBy = "freeboard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment;
    //mappedBy 특성은 관계가 freeboard 엔티티의 게시물 필드에 매핑됨을 지정하고,
    //cascade 특성은 모든 cascade 작업이 댓글에 적용되어야 함을 지정함.
    //orphanRemoval 속성은 삭제된 게시물과 관련된 댓글도 삭제되도록 true로 설정됨.

    public void addComment(Comment comment) {
        comment.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment) {
        comment.remove(comment);
        comment.setPost(null);
    }
}