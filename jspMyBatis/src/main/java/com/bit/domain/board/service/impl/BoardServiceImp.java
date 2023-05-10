package com.bit.domain.board.service.impl;

import com.bit.domain.board.dao.impl.BoardDaoImp;
import com.bit.domain.board.service.BoardService;
import com.bit.domain.board.vo.Board;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class BoardServiceImp implements BoardService {
     private static BoardService boardService = new BoardServiceImp();
     public static BoardService getBoardService(){
          return boardService;
     }
     @Override
     public List<Object> selectEmp(Hashtable<String, Object> map) {
          return null;
     }
     
     @Override
     public String getIdCheck(String id) {
          return null;
     }
     
     @Override
     public void insertBoard(Board board) {
          BoardDaoImp.getBoardDao().insertBoard(board);
     }
     
     @Override
     public List<Board> selectAll(HashMap<String, Object> map) {
          return BoardDaoImp.getBoardDao().selectAll(map);
     }
}