package com.test.intro.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.intro.jpa.model.PhonesEntity;

/**
 * The Interface PhonesJpaRepository.
 */
@Repository
public interface PhonesJpaRepository extends JpaRepository<PhonesEntity, Integer>{

}
