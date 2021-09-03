package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;

public class CommReviewListHandler extends AbstractCommReviewHandler {

  public CommReviewListHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[소통해요 게시글]");
    //    CommReviewDTO[] commReviewsDTO = new CommReviewDTO [commReviewDTOList.size()];
    //    commReviewDTOList.toArray(commReviewsDTO);
    //    for (CommReviewDTO commReviewDTO : commReviewsDTO) {
    if (commReviewDTOList.isEmpty()) {
      System.out.println("게시글이 없습니다");
      return;
    }


    for (CommReviewDTO commReviewDTO : commReviewDTOList) {
      System.out.printf("%d, %s, %s\n", 
          commReviewDTO.getNo(), 
          commReviewDTO.getContent(),
          commReviewDTO.getRegisteredDate());
    }
  }
}










