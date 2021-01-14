package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Feedback;

@Repository
public interface FbRepository extends JpaRepository<Feedback, Long>{

}
