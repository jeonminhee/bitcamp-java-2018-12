package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  public Scanner keyboard;
  final int LENGTH = 10;
  Board[] boards = new Board[LENGTH];
  int boardIdx = 0;
  
  public void addBoard() {

    Board board = new Board();

    System.out.print("번호? ");
    board.no = Integer.parseInt(this.keyboard.nextLine());

    System.out.print("내용? ");
    board.contents = this.keyboard.nextLine();

    board.createdDate = new Date(System.currentTimeMillis()); 

    board.viewCount = 0;

    boards[this.boardIdx] = board;
    this.boardIdx++;

    System.out.println("저장하였습니다.");

  }

  public void listBoard() {

    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }

  }

}
