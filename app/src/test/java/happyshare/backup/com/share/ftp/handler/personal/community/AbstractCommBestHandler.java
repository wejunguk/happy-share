package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBestHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;

  public AbstractCommBestHandler(List<CommBoardDTO> commBoardDTOList) {
    this.commBoardDTOList = commBoardDTOList;

    //    //  전체 목록중에서 조회수가 가장 높은 3개
    //    CommBoardDTO[] arr = commBoardHandler.chooseBoard();
    //
    //    System.out.printf("%d, %s, %s, %s, %s, %d\n", 
    //        arr[0].getNo(), 
    //        arr[0].getTitle(), 
    //        arr[0].getContent(),
    //        arr[0].getFileUpload(),
    //        //this.commBoardsDTO[i].getPassword(),
    //        arr[0].getRegisteredDate(), 
    //        arr[0].getViewCount());


  }
}










