package com.bit.domain.board.dao;

import com.bit.domain.board.vo.Board;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public interface BoardDao {
     public List<Object> selectEmp(Hashtable<String, Object> map);
     public String getIdCheck(String id);
     public void insertBoard(Board vo);
     public List<Board> selectAll(HashMap<String, Object> map);
     public void addHit(int no);
     public Board selectBoard(int no);
     public int countBoard(HashMap<String, Object> map);
}
