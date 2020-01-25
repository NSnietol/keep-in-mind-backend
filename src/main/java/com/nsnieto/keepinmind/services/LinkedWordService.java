package com.nsnieto.keepinmind.services;

import com.nsnieto.keepinmind.dto.WordDto;
import com.nsnieto.keepinmind.entities.LinkedWord;
import com.nsnieto.keepinmind.entities.User;
import com.nsnieto.keepinmind.entities.Word;
import com.nsnieto.keepinmind.exception.ValueNotFound;
import com.nsnieto.keepinmind.repositories.LinkedWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LinkedWordService {

    @Autowired
    private LinkedWordRepository linkedWordRepository;

    @Autowired
    private WordService wordService;
    @Autowired
    private UserService userService;

    // MarkedWord
    public LinkedWord addWordToUser(WordDto dto) throws Exception {

        User user = userService.getUserByNickName(dto.getNickName());

        Word word = wordService.saveNewWord(Word.builder()
                .name(dto.getName())
                .mean(dto.getMean())
                .build());

        Optional<Word> markedWord = checkWordInUser(user.getNickName(), word);

        if (markedWord.isPresent()) {
            return LinkedWord.builder().user(user).word(markedWord.get()).build();
        }

        return linkedWordRepository.save(LinkedWord.builder().user(user).word(word).build());

    }

    // Optional
    public Optional<Word> checkWordInUser(String nickName, Word word) throws Exception {
        return null;
    }

    // Primitive values
    public boolean deleteLinkedWord(String nickName, Long wordId) throws Exception {

        User user = userService.getUserByNickName(nickName);

        Optional<LinkedWord> markedWordToDelete = linkedWordRepository.findAllByUser(user).stream()
                .filter(markedWord -> markedWord.getWord().getId() == wordId).findAny();

        if (markedWordToDelete.isPresent()) {

            linkedWordRepository.delete(markedWordToDelete.get());

        } else {
            throw new ValueNotFound("Word :" + wordId);
        }

        return true;
    }

    public boolean shareWords(String nickNameOrigin, String nickNameDestination) throws Exception {

        List<Word> wordlist = linkedWordRepository.findAllWordByUserNickName(nickNameOrigin);
        User userDestination = userService.getUserByNickName(nickNameDestination);

        /*
         * wodrlist.stream() .map(word->new MarkedWord()) .collect(Collection.)
         */

        return true;
    }

    // List

    public List<Word> findAllWordsByNickName(String nickName, Pageable pageable) throws Exception {
        //return linkedWordRepository.findAllWordByUserNickName(nickName, pageable);
        return linkedWordRepository.findAllWordsByUser(userService.getUserByNickName(nickName), pageable);
    }

    public List<Word> findAllWordsByNickName(String nickName) throws Exception {
        return linkedWordRepository.findAllWordsByUser(userService.getUserByNickName(nickName));
    }

    public List<Word> findAllWordsByNickNameTest(String nickName) throws Exception {
        return linkedWordRepository.findAllWordByUserNickName(nickName);
    }

}
