package com.bit.domain.member.dao.impl;

import com.bit.conf.SqlSessionManager;
import com.bit.data.member.MemberMapper;
import com.bit.domain.member.dao.MemberDao;
import com.bit.domain.member.vo.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MemberDaoImp implements MemberDao {
     public static final MemberDao instance = new MemberDaoImp();
     private final SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
     @Override
     public void insertMember(Member member) {
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
               MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
               memberMapper.insertMember(member);
               sqlSession.commit();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
     
     @Override
     public void deleteMember(int no) {
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
               MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
               memberMapper.deleteMember(no);
               sqlSession.commit();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
     
     @Override
     public List<Member> selectAllMember() {
          List<Member> memberList = null;
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
               MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
               memberList = memberMapper.selectAllMember();
          } catch (Exception e) {
               e.printStackTrace();
          }
          return memberList;
     }
     
     @Override
     public void updateMember(Member member) {
          try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
               MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
               memberMapper.updateMember(member);
               sqlSession.commit();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}
