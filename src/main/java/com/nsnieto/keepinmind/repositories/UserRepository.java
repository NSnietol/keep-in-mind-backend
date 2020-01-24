package com.nsnieto.keepinmind.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsnieto.keepinmind.entities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByNickName(String nickName);
}

