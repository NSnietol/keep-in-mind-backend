package com.nsnieto.keepinmind.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nsnieto.keepinmind.entities.Word;
import com.nsnieto.keepinmind.repositories.WordRepository;

@Component
public class WordService {

	@Autowired
	private WordRepository wordController;

	@Autowired
	private WordRepository wordRepository;

	public Word saveNewWord(Word newWord) throws Exception {
		
		newWord.setName(newWord.getName().trim());
		newWord.setMean(newWord.getMean().trim());

		Optional<Word> optionalWord = wordRepository.findByNameAndMean(newWord.getName(), newWord.getMean());
		
		return optionalWord.isPresent() ? optionalWord.get() : wordRepository.save(newWord);

	}

	public Optional<Word> findWordById(Long id) throws Exception {

		return wordRepository.findById(id);

	}

	
	// Omitir esto, no deberia estar así acá
	public ResponseEntity<Object> listAll() {

		try {

			return ResponseEntity.status(201).body(wordController.findAll());

		} catch (Exception e) {

			return ResponseEntity.status(404).body(e.getMessage());

		}

	}

	public ResponseEntity<Object> getWordsRandom(int size) {

		List<Word> words = wordController.findAll();

		Collections.shuffle(words);

		if (words.size() > size) {
			return ResponseEntity.status(201).body(words.subList(0, size));
		} else {
			return ResponseEntity.status(201).body(words);
		}

	}

	public ResponseEntity<Object> updateWord(long id, Word word) {

		try {
			wordController.deleteById(id);
			return ResponseEntity.status(404).body("");

		} catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());

		}

	}

	

}
