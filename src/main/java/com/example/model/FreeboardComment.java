package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name = "freeboardComment")
public class FreeboardComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="writeDate")
	private LocalDateTime writeDate;
	
	@Column(name="writer")
	private String writer;
	
	@Column(name="commentOriginId")
	private Long commentOriginId;
	
	@Column(name="commentLevel")
	private int commentLevel;
	
	@ManyToOne(targetEntity = Freeboard.class)
	@JoinColumn(foreignKey = @ForeignKey(name="freeId"))
	private Long freeId;
	
	public Long getFreeId() {
		return freeId;
	}
	public void setFreeId(Long freeId) {
		this.freeId = freeId;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Long getCommentOriginId() {
		return commentOriginId;
	}
	public void setCommentOriginId(Long commentOriginId) {
		this.commentOriginId = commentOriginId;
	}
	public int getCommentLevel() {
		return commentLevel;
	}
	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}
}
