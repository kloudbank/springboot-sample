package com.ski.tmpl.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ski.tmpl.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	public Board findById(long id);
}

