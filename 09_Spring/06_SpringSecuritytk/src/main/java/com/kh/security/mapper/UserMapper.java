package com.kh.security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.security.model.vo.User;

@Mapper
public interface UserMapper {

	void register(User user);
	User login(String id);
}
