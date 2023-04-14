package com.bit.board.model.service;

import com.bit.model.bean.DiaryDto;
import static com.bit.board.model.dao.DiaryDaoImpl.getDiaryDao;
import java.util.List;

public class DiaryServiceImpl implements  DiaryService{
     
     private static DiaryService diaryService = new DiaryServiceImpl();
     public static DiaryService getDiaryService(){return diaryService;}
     
     @Override // 수입, 지출 내역 작성
     public void writeDiary(DiaryDto diaryDto) {
          getDiaryDao().writeDiary(diaryDto);
     }
     
     @Override
     public void modifyDiary(DiaryDto diaryDto) {
     
     }
     
     @Override
     public void deleteDiary(int diaryId) {
     
     }
     
     @Override
     public List<DiaryDto> getTotalRecord(int userId) {
          return null;
     }
}
