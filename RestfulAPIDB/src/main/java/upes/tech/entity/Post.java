package upes.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Post")
@Table(name="Post")
public class Post {

	@Id
	@Column(name="postid")
	private int postid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="body")
    private String body;
	public Post() {
	}
	public Post(int postid, String title, String body) {
		super();
		this.postid = postid;
		this.title = title;
		this.body = body;
	}
	public Post(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "post [postid=" + postid + ", title=" + title + ", body=" + body + "]";
	}
	
}

