package com.syn.admin.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.syn.admin.model.User;
import com.syn.admin.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping()
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	@RequestMapping("/{id}")
	public User get(@PathVariable("id") Integer id) {
		return userRepository.findOne(id);
	}

	@PostMapping()
	@ResponseBody
	public User add(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public User put(@PathVariable(value = "id") Integer id, @RequestBody User user) {
		User dbUser = userRepository.findOne(id);
		if (!StringUtils.isNullOrEmpty(user.getName())) {
			dbUser.setName(user.getName());
		}
		if (!StringUtils.isNullOrEmpty(user.getMobile())) {
			dbUser.setMobile(user.getMobile());
		}
		if (!StringUtils.isNullOrEmpty(user.getEmail())) {
			dbUser.setEmail(user.getEmail());
		}
		return userRepository.save(dbUser);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable(value = "id") Integer id) {
		userRepository.delete(id);
		return "Record Deleted!!!";
	}

}
