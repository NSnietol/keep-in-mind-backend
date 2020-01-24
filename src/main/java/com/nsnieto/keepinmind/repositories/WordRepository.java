package com.nsnieto.keepinmind.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsnieto.keepinmind.entities.Word;



@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

	Optional<Word> findById(Long id);
	Optional<Word> findByNameAndMean(String name,String mean);
}

