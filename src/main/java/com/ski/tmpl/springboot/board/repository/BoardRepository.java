package com.ski.tmpl.springboot.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ski.tmpl.springboot.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	public Board findById(long id);
}

