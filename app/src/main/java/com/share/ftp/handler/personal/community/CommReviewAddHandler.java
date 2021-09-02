package com.share.ftp.handler.personal.community;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.util.Prompt;

public class CommReviewAddHandler extends AbstractCommReviewHandler {

  public CommReviewAddHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }

  @Override
  public void execute() {

    System.out.println();
    System.out.println("[소통해요/ 한줄후기/ 등록]");

    CommReviewDTO commReviewDTO = new CommReviewDTO();

    commReviewDTO.setNo(Prompt.inputInt("번호? "));
    commReviewDTO.setContent(Prompt.inputString("내용? "));
    commReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    commReviewDTOList.add(commReviewDTO);
  }
}










