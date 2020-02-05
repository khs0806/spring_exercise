package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.model.Users;

@Repository
@EnableJpaRepositories
public interface UsersRepository extends JpaRepository<Users, Long>{

	Users findByUserIdAndUserPw(String userId, String userPw);
//	Users findByUser_id(String user_id);
	
	
}
