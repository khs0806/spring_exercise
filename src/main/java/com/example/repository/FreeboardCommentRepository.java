package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.FreeboardComment;

@Repository
public interface FreeboardCommentRepository extends JpaRepository<FreeboardComment, Long>{
	List<FreeboardComment> findAllByFreeId(Long freeId);
}
