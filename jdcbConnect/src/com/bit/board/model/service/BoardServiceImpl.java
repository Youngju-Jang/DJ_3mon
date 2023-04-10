package com.bit.board.model.service;

import com.bit.board.model.dao.BoardDao;
import com.bit.board.model.dao.BoardDaoImpl;
import com.bit.model.bean.BoardDto;

import java.util.List;

public class BoardServiceImpl implements BoardService{
     
     private static BoardService boardService = new BoardServiceImpl();
     
     public static BoardService getBoardService(){
          return boardService;
     }
     @Override
     public void registerArticle(BoardDto boardDto) {
          BoardDaoImpl.getBoardDao().registerArticle(boardDto);
     }
     
     @Override
     public List<BoardDto> searchListAll() {
          return null;
     }
     
     @Override
     public List<BoardDto> searchListBySubject(String subject) {
          return null;
     }
     
     @Override
     public BoardDto viewArticle(int no) {
          return null;
     }
     
     @Override
     public void modifyArticle(BoardDto boardDto) {
     
     }
     
     @Override
     public void deleteArticle(int no) {
     
     }
}
