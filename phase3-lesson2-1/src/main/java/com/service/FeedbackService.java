package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.FbRepository;
import com.hcl.model.Feedback;

@Service
public class FeedbackService {

	@Autowired
	private FbRepository repo;
	
	public boolean saveFeedback(Feedback fb) {
		try {
			repo.save(fb);
			return true;
		} catch(Exception e) {
			System.out.println("can't save");
			return false;
		}
	}
	
	public List<Feedback> findAllFeedbacks() {
		return (List<Feedback>) repo.findAll();
	}
	
	public Optional<Feedback> findFeedbackById(long id) {
		return repo.findById(id);
	}
	
	public boolean deleteFeedback(Feedback fb) {
		try {
			repo.delete(fb);
			return true;
		} catch( Exception e) {
			System.out.println("Couldn't delete");
			return false;
		}
	}
	
}
