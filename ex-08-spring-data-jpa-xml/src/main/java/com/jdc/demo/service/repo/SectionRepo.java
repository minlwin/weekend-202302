package com.jdc.demo.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.service.entity.Section;

public interface SectionRepo extends JpaRepositoryImplementation<Section, Integer>{

}
