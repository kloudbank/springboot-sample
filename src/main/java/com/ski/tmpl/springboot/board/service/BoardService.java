package com.ski.tmpl.springboot.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ski.tmpl.springboot.board.domain.Board;
import com.ski.tmpl.springboot.board.repository.BoardRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BoardService {
	
    @Autowired
	private BoardRepository boardRepository;

	public Iterable<Board> findAll() {
		return this.boardRepository.findAll();
	}
	
	public Board findById(long id) {
		return this.boardRepository.findById(id);
	}

	public Board createBoard(Board board) {
		return this.boardRepository.save(board);
	}

	public Board editBoard(Board board, long id) {
        try {
            board.setId(id);
            board.setCreatedAt(this.boardRepository.findById(id).getCreatedAt());
        }  catch (NullPointerException e) {
            log.warn(id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");
        }
		return this.boardRepository.save(board);
	}

	public boolean deleteBoard(long id) {
        boolean result = false;
        try {
            this.boardRepository.findById(id).getId();
            this.boardRepository.deleteById(id);
            result = true;
        } catch (NullPointerException e) {
            log.warn(id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");
        }
        return result;
	}
	
}
