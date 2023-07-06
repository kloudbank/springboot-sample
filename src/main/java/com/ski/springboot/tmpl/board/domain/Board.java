package com.ski.springboot.tmpl.board.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.v3.oas.annotations.media.Schema;
// import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @Schema(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    @Schema(example = "ia02736", required = true)
    private String userid ;

    @Column(length = 255)
    @Schema(example = "Title", required = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    @Schema(example = "Contents,,", required = true)
    private String content;

    @Column
    @Schema(hidden = true)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @Schema(hidden = true)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // @Builder
    // public Board(String userid, String title, String content, LocalDateTime createdAt) {
    //     this.userid = userid;
    //     this.title = title;
    // 	this.content = content;
    //     this.createdAt = createdAt;
    // }
}
