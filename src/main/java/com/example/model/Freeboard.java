package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "freeboard")
public class Freeboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "freeId")
	private Long freeId;
	@Column(name = "content")
	private String content;
	@Column(name = "title")
	private String title;
	@Column(name = "writer")
	private String writer;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Long getFreeid() {
		return freeId;
	}
	public void setFreeid(Long freeid) {
		this.freeId = freeid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
