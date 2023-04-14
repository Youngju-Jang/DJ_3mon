package com.bit.board.model.dao;

import com.bit.model.bean.UserDto;

import java.util.List;

public interface UserDao {
     boolean registerUser(String username, String password); // 유저등록. 닉네임 제중복불가
     int getUserId(String username);
     UserDto getUserByUsername(String username);
     List<UserDto> searchAllUser();// 전체유저 검색
     int showAllowance(int no); // 현재 잔액 확인
     UserDto getUserByUserIdAndPassword(int userId, String password);// 닉네임, 패스워드로 유저찾기
     void modifyUser(UserDto userDto);// 유저정보수정. 아이디수정불가.
     void modifyMoney(int no, int money); // 입금
     void deleteUser(int no);// 유저삭제
}
