package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Tweet create(TweetDTO dto) {
        User user = userRepository.findFirstByUsername(dto.username());
        return repository.save(new Tweet(dto, user.getAvatar()));
    }
}
