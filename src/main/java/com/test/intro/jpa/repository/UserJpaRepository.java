package com.test.intro.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.intro.jpa.model.UserEntity;

/**
 * The Interface UserJpaRepository.
 */
@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Integer>{

	/**
	 * Find user by.
	 *
	 * @param userEmail the user email
	 * @return the user entity
	 */
	@Query("SELECT U FROM UserEntity U "
			+ "WHERE U.userEmail = :userEmail ")
	UserEntity findUserByEmail(@Param("userEmail") String userEmail);
}
