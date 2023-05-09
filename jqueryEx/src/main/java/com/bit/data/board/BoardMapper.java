package com.bit.data.board;

import com.bit.domain.board.vo.Board;

import java.util.List;

public interface BoardMapper {
     void insertBoard(Board board);
     List<Board> selectBoardList();
}
