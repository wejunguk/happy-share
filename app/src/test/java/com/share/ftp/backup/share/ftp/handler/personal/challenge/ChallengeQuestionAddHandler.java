package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionAddHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionAddHandler(List<MyChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 등록]");

    MyChallengeQuestionDTO myChallengeQuestionDTO = new MyChallengeQuestionDTO();

    myChallengeQuestionDTO.setNo(Prompt.inputInt("번호: "));
    myChallengeQuestionDTO.setMemberId(Prompt.inputString("아이디: "));
    myChallengeQuestionDTO.setContent(Prompt.inputString("내용: "));

    myChallengeQuestionDTOList.add(myChallengeQuestionDTO);
  }
}
