package com.seb.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.seb.entities.ReviewEntity;


public interface ReviewRepository extends CrudRepository<ReviewEntity, Long>{
	
	 
   public List<ReviewEntity> findByImbdId(String imbdId);
   public List<ReviewEntity> findByTitle(String title);

}
