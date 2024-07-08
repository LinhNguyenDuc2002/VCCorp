package com.example.vcc_task7.service;

import com.example.vcc_task7.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User add(User user) throws Exception;

    void delete(Integer id) throws Exception;

    User update(Integer id, User user) throws Exception;

    List<User> sortByName();

    List<User> findByName(String name);

    List<User> findById(Integer id);

    List<User> findByAddress(String address);

    User addMoney(Integer id, Long money) throws Exception;

    void sendMoney(Integer userA, Integer userB, Long money) throws Exception;
}
