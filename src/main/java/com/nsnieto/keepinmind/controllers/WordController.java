package com.nsnieto.keepinmind.controllers;

import com.nsnieto.keepinmind.entities.Word;
import com.nsnieto.keepinmind.repositories.WordRepository;
import com.nsnieto.keepinmind.services.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    private final WordRepository wordController;

    private final WordService wordService;

    public WordController(WordRepository wordController, WordService wordService) {
        this.wordController = wordController;
        this.wordService = wordService;
    }

    @GetMapping(value = "/list/random", produces = {"application/json"})
    public ResponseEntity<Object> getWordsRandom(@RequestParam(name = "size", defaultValue = "3") int size) {
        return wordService.getWordsRandom(size);
    }

    @GetMapping(value = "/list", produces = {"application/json"})
    public ResponseEntity<Object> getWords() {
        return wordService.listAll();

    }

    @PostMapping(value = "find", produces = {"application/json"})
    public ResponseEntity<Object> create(@Validated @RequestBody Word newWord) {
        return ResponseEntity.ok(wordController.findByNameAndMean(newWord.getName(), newWord.getMean()));
    }

    @PostMapping("/create/list")
    public ResponseEntity<Object> create(@Valid @RequestBody List<Word> words) {
        wordController.saveAll(words);
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestParam(name = "id") Long id, @Valid @RequestBody Word word) {
        return wordService.updateWord(id, word);
    }

}
