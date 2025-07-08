package com.j797.to_do_list_with_dto.repository;

import com.j797.to_do_list_with_dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public int save(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    public int delete(User user) {
        String sql = "DELETE FROM user WHERE id = ?";
        return jdbcTemplate.update(sql, user.getId());
    }
}
