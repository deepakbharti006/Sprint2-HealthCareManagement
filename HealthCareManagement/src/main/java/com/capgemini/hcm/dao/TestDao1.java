package com.capgemini.hcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.hcm.entity.Test;

public interface TestDao1 extends JpaRepository<Test, Integer>{

}
