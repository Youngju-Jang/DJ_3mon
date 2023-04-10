package com.bit.board.model.dao;

import com.bit.model.bean.BoardDto;

import java.util.List;

public interface BoardDao {
     void registerArticle(BoardDto boardDto);
     List<BoardDto> searchListAll();
     List<BoardDto> seearchListBySubject(String subject);
     BoardDto viewArticle(int no);
     void modifyArticle(BoardDto boardDto);
     void deleteArticle(int no);
}
