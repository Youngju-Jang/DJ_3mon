package com.bit.board.model.dao;

import com.bit.model.bean.DiaryDto;

import java.util.List;

public interface DiaryDao {
     boolean writeDiary(DiaryDto diaryDto); // 작성
     void modifyDiary(DiaryDto diaryDto); // 수정
     void deleteDiary(int diaryId); // 삭제
     List<DiaryDto> getTotalRecord(int userId); // 기록 불러오기
}
