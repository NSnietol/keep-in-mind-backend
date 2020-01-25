package com.nsnieto.keepinmind.repositories;

import com.nsnieto.keepinmind.entities.LinkedWord;
import com.nsnieto.keepinmind.entities.User;
import com.nsnieto.keepinmind.entities.Word;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LinkedWordRepository extends JpaRepository<LinkedWord, Long> {

    List<LinkedWord> findAllByUser(User user, Pageable pageable);

    List<LinkedWord> findAllByUser(User user);

    List<Word> findAllWordsByUser(User user);

    List<Word> findAllWordsByUser(User user, Pageable pageable);


    List<Word> findAllWordByUserNickName(String nickName, Pageable pageable);

    List<Word> findAllWordByUserNickName(String nickName);

    Optional<LinkedWord> findAWordByUserNickNameAndWord(String nickName, Word word);

}

