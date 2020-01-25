package com.nsnieto.keepinmind.controllers;


import com.nsnieto.keepinmind.dto.WordDto;
import com.nsnieto.keepinmind.services.LinkedWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/words")
@Controller
public class LinkedWordController {

    @Autowired
    private LinkedWordService linkedWordService;


    @GetMapping("/list/{nickName}")
    public ResponseEntity<Object> listAll(
            @RequestParam(name = "sort", defaultValue = "id") String sort,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @Validated @PathVariable String nickName) {

        try {
            if (sort.equals("id")) {
                return ResponseEntity.ok(linkedWordService.findAllWordsByNickName(nickName, PageRequest.of(page, size, Sort.by(sort.toLowerCase()))));

            }
            {
                return ResponseEntity.ok(linkedWordService.findAllWordsByNickName(nickName));

            }

        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @PostMapping("/create")
    public ResponseEntity<Object> testCreate(@Validated @RequestBody WordDto dto) {

        try {
            return ResponseEntity.ok(linkedWordService.addWordToUser(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> testCreates() {

        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;

    }


}
