package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommBoardDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardUpdateHandler  implements Command {

  CommBoardDao commBoardDao;

  public CommBoardUpdateHandler (CommBoardDao commBoardDao) {
    this.commBoardDao =  commBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {
      System.out.println();
      System.out.println("[  메인/소통해요/나눔이야기/게시글변경  ]");
      int commNo = (int) request.getAttribute("commNo");

      CommBoardDTO commBoardDTO = commBoardDao.findByCommNo(commNo);


      if (commBoardDTO == null) {
        System.out.println("[  해당 게시글이 없습니다.  ]");
        return;
      }


      String title = Prompt.inputString(String.format("제목(%s)? ", commBoardDTO.getTitle()));
      String content = Prompt.inputString(String.format("내용(%s)? ", commBoardDTO.getContent()));
      String fileUpload = Prompt.inputString(String.format("첨부파일(%s)? ", commBoardDTO.getFileUpload()));

      try {
        String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");
        if (input.equalsIgnoreCase("n"))  {
          System.out.println("[  게시글 변경을 취소하였습니다.  ]");
          return;
        }

        else if(input.equals("y")) {
          commBoardDTO.setTitle(title);
          commBoardDTO.setContent(content);
          commBoardDTO.setFileUpload(fileUpload);

          commBoardDao.update(commBoardDTO);

          System.out.println("[  게시글을 변경하였습니다.  ]");
          return;
        }

        else {
          System.out.println("[  y 또는 n을 입력하세요.  ]");
          continue;
        }
      } catch (Throwable e) {
      }
    }
  }
}




