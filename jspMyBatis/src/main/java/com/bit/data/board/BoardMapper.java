package com.bit.data.board;

import com.bit.domain.board.vo.Board;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface BoardMapper {
     void insertBoard(Board board);
     List<Board> selectBoardList(HashMap<String, Object> map);
     void updateBoardHit(@Param ("no") int no);
     Board selectBoard(int no);
     int countBoard(HashMap<String, Object> map);
}
