package com.bit.board.model.service;

import com.bit.model.bean.DiaryDto;

import java.util.List;

public interface DiaryService {
     void writeDiary(DiaryDto diaryDto); // 작성
     void modifyDiary(DiaryDto diaryDto); // 수정
     void deleteDiary(int diaryId); // 삭제
     List<DiaryDto> getRecordByMonthAndYear(int userId,int year, int month); // 기록 불러오기
     
}
