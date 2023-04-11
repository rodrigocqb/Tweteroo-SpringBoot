package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Tweet create(TweetDTO dto) {
        User user = userRepository.findByUsername(dto.username());
        return repository.save(new Tweet(dto, user.getAvatar()));
    }

    public Page<Tweet> getTweetsByPage(String query) {
        int page;

        if(query != null) {
            try {
                page = Integer.parseInt(query);
            } catch (Exception e) {
                page = 1;
            }
        } else {
            page = 1;
        }
        System.out.println(page);

        return repository.findAll(PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "id")));
    }
}
