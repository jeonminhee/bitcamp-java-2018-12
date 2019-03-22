package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {

  PhotoBoardDao boardDao;
  PhotoFileDao fileDao;
  PlatformTransactionManager txManager;

  public PhotoBoardServiceImpl(PhotoBoardDao boardDao, PhotoFileDao fileDao, PlatformTransactionManager txManager) {
    this.boardDao = boardDao; 
    this.fileDao = fileDao;
    this.txManager = txManager;
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
  public int add(PhotoBoard board) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      int count = boardDao.insert(board);
      // 파일을 저장하기 전에 사진 게시물의 번호를 각 사진 객체에 주입해야 한다.
      List<PhotoFile> files = board.getFiles();
      for(PhotoFile f : files) {
        f.setPhotoBoardNo(board.getNo());
      }
      fileDao.insert(board.getFiles());
      txManager.commit(status);
      return count;
    } catch(RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
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
  public int update(PhotoBoard board) {
    // 트랜잭션 관리는 Service 객체에서 해야한다.
    // 트랜젝션 동작 방식을 설정한다.
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    // 트랜젝션을 준비한다.
    TransactionStatus status = txManager.getTransaction(def);

    try {

      if(board.getTitle() != null) {
        boardDao.update(board);
      }

      List<PhotoFile> photoFiles = board.getFiles();
      if(photoFiles != null) {
        fileDao.deleteByPhotoBoardNo(board.getNo());
        fileDao.insert(photoFiles);
      }


      txManager.commit(status);
      return 1;
    } catch (RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
  }

  @Override
  public int delete(int no) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {

      fileDao.deleteByPhotoBoardNo(no);
      int count = boardDao.delete(no);
      txManager.commit(status);
      return count;
    }catch (RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
  }
}
