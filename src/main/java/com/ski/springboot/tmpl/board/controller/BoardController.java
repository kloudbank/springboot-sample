package com.ski.springboot.tmpl.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ski.springboot.tmpl.board.domain.Board;
import com.ski.springboot.tmpl.board.service.BoardService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/v1")
public class BoardController {
	
    @Autowired
	private BoardService boardService;

	@GetMapping(value="/board/all")
	public Iterable<Board> findBoardAll() {
		return this.boardService.findAll();
	}
	
	@GetMapping(value="/board/{id}")
	public Board findBoardById(@PathVariable long id) {
		return this.boardService.findById(id);
	}

	@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created")
    })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="/board")
	public Board addBoard(@RequestBody Board board) {
        return this.boardService.createBoard(board);
	}
	
	@PutMapping(value="/board/{id}")
	public Board editBoard(@RequestBody Board board, @PathVariable long id) {
		return this.boardService.editBoard(board, id);
	}
	
	@DeleteMapping(value="/board/{id}")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted")
    })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteBoard(@PathVariable long id) {
		return this.boardService.deleteBoard(id);
	}
}
