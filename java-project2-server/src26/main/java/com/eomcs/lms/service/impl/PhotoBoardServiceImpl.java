package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {

  PhotoBoardDao boardDao;
  PhotoFileDao fileDao;

  public PhotoBoardServiceImpl(PhotoBoardDao boardDao, PhotoFileDao fileDao) {
    this.boardDao = boardDao; 
    this.fileDao = fileDao;
  }

  @Override
  public List<PhotoBoard> list(int lessonNo, String searchWord) {
    if(lessonNo <= 0 && searchWord == null) {
      return boardDao.findAll(null);
    } else {
      HashMap<String, Object> params = new HashMap<>();
      if(lessonNo > 0) {
        params.put("lessonNo", lessonNo);       
      }

      if(searchWord != null) {
        params.put("keyword", searchWord);
      }

      return boardDao.findAll(params);
    }
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public int add(PhotoBoard board) {
    int count = boardDao.insert(board);
    List<PhotoFile> files = board.getFiles();
    for(PhotoFile f : files) {
      f.setPhotoBoardNo(board.getNo());
    }

    fileDao.insert(board.getFiles());

    return count;
  }

  @Override
  public PhotoBoard get(int no) {
    PhotoBoard board = boardDao.findByNoWithFile(no);
    if(board != null) {
      boardDao.increaseCount(no);
    }
    return board;
  }


  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public int update(PhotoBoard board) {

    if(board.getTitle() != null) {
      boardDao.update(board);
    }

    List<PhotoFile> photoFiles = board.getFiles();
    if(photoFiles != null) {
      fileDao.deleteByPhotoBoardNo(board.getNo());
      fileDao.insert(photoFiles);
    }
    return 1;
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public int delete(int no) {

    fileDao.deleteByPhotoBoardNo(no);
    return boardDao.delete(no);
  }
}
