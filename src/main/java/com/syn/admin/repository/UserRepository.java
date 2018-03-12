package com.syn.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.syn.admin.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}