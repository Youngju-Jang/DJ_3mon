package com.bit.domain.users.dao.impl;

import com.bit.conf.SqlSessionManager;
import com.bit.data.users.UsersMapper;
import com.bit.domain.users.dao.UserDao;
import com.bit.domain.users.vo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImp implements UserDao {
     private static final UserDao userDao = new UserDaoImp();
     private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
     public static UserDao getUserDao(){
          return userDao;
     }
     @Override
     public User selectUser(String name) {
          User user = null;
          // Try with resource 로DB와 연결할 세션객체 생성
          try(SqlSession sqlSession = sqlSessionFactory.openSession()){
               // 해당 세션에서 등록한 유저매퍼 클래스 객체를 불러와
               UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
               // 유저매퍼의 selectUser 쿼리 메소드 실행 (파라미터로 name 전달)
               // 해당 쿼리 실행 후 값이 존재할 경우 User 객체 리턴, 없을 경우 null 리턴됨
               user = usersMapper.selectUser(name);
          }catch (Exception e){
               e.printStackTrace();
          }
          // 디비정보 조회된 결과가 User DTO형태에 맞게 매핑되어 리턴됨
          return user;
     }
     
     @Override
     public boolean checkName(String name) {
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
               UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
               return usersMapper.checkName(name);
          } catch (Exception e) {
               e.printStackTrace();
          }
          return false;
     }
     
     @Override
     public void createUser(User user) {
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
               UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
               usersMapper.createUser(user);
               sqlSession.commit();
          }catch (Exception e){
               e.printStackTrace();
          }
     }
}
