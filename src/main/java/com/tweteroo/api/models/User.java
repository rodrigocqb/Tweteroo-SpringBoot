package com.tweteroo.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tweteroo.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "tweets"})
public class User {

    public User(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 255, nullable = false)
    private String avatar;
}
