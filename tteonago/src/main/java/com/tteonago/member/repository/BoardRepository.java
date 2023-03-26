package com.tteonago.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tteonago.member.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
	@Query(value = "SELECT b.article_no, b.parent_no, b.title, b.content, b.username, b.writedate " +
            "FROM board b " +
            "LEFT JOIN ( " +
            "  SELECT article_no, IFNULL(parent_no, 0) AS parent_no, COUNT(*) AS depth " +
            "  FROM board " +
            "  GROUP BY article_no, parent_no " +
            ") p ON b.article_no = p.article_no " +
            "ORDER BY " +
            "  CASE WHEN b.parent_no = 0 THEN -b.article_no ELSE -b.parent_no END, " +
            "  p.depth, " +
            "  b.article_no", nativeQuery = true)
	List<Object[]> getBoardList1();
}
