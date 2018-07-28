package com.seb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



@Entity
public class ReviewEntity {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private double score;
	private String title, imbdId;
	
	@Lob
	private String review;
	
	public ReviewEntity(){
		
	}
	
	public ReviewEntity( String imbdId, String title, double score,String review ) {
		this.review = review;
		this.title = title;
		this.score = score;
		this.imbdId = imbdId;
	}



	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImbdId() {
		return imbdId;
	}



	public void setImbdId(String imbdId) {
		this.imbdId = imbdId;
	}



	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
	

}
