package com.ski.springboot.tmpl.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ski.springboot.tmpl.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	public Board findById(long id);
}

