package com.share.ftp;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.context.ApplicationContextListener;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.CommBoardDao;
import com.share.ftp.dao.CommReviewDao;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.dao.impl.NetChallengeDao;
import com.share.ftp.dao.impl.NetCommBoardDao;
import com.share.ftp.dao.impl.NetCommReviewDao;
import com.share.ftp.dao.impl.NetDonationBoardDao;
import com.share.ftp.dao.impl.NetDonationRegisterDao;
import com.share.ftp.dao.impl.NetJoinDao;
import com.share.ftp.dao.impl.NetQuestionDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.ftp.domain.personal.ChallengeJoinDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AdminChallengeAddHandler;
import com.share.ftp.handler.admin.AdminChallengeDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeDetailHandler;
import com.share.ftp.handler.admin.AdminChallengeListHandler;
import com.share.ftp.handler.admin.AdminChallengeQuestionListHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyAddHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyConnectlHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyUpdateHandler;
import com.share.ftp.handler.admin.AdminChallengeUpdateHandler;
import com.share.ftp.handler.admin.AdminMemberDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeAddHandler;
import com.share.ftp.handler.admin.AdminNoticeDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeDetailHandler;
import com.share.ftp.handler.admin.AdminNoticeListHandler;
import com.share.ftp.handler.admin.AdminNoticeSearchHandler;
import com.share.ftp.handler.admin.AdminNoticeUpdateHandler;
import com.share.ftp.handler.admin.AdminQuestionAddHandler;
import com.share.ftp.handler.join.AuthDisplayUserHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.AuthUpdateUserHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinDetailHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinSearchEmailIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.JoinSearchTelIdHandler;
import com.share.ftp.handler.join.MyPageDeleteUserHandler;
import com.share.ftp.handler.join.MyPageUpdateUserHandler;
import com.share.ftp.handler.org.MyVolApplyListHandler;
import com.share.ftp.handler.org.MyVolApproveListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeRankingHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeWishHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeDetailHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeListHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeWishHandler;
import com.share.ftp.handler.personal.community.CommBestDetailHandler;
import com.share.ftp.handler.personal.community.CommBestListHandler;
import com.share.ftp.handler.personal.community.CommBoardAddHandler;
import com.share.ftp.handler.personal.community.CommBoardDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardDetailHandler;
import com.share.ftp.handler.personal.community.CommBoardListHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyAddHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyConnectHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyListHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyUpdateHandler;
import com.share.ftp.handler.personal.community.CommBoardSearchHandler;
import com.share.ftp.handler.personal.community.CommBoardUpdateHandler;
import com.share.ftp.handler.personal.community.CommReviewAddHandler;
import com.share.ftp.handler.personal.community.CommReviewDeleteHandler;
import com.share.ftp.handler.personal.community.CommReviewListHandler;
import com.share.ftp.handler.personal.community.CommReviewSearchHandler;
import com.share.ftp.handler.personal.community.CommReviewUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationAdminPrompt;
import com.share.ftp.handler.personal.donation.DonationBoardAcceptApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAdminApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAppliedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyCompleteListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardDetailRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationBoardListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRegisterListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectedListHandler;
import com.share.ftp.handler.personal.donation.DonationPrompt;
import com.share.ftp.handler.personal.donation.DonationRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterMyListHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterParticipationHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterTotalMoneyHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDeleteHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDetailHandler;
import com.share.ftp.handler.personal.mypage.MyBoardListHandler;
import com.share.ftp.handler.personal.mypage.MyBoardUpdateHandler;
import com.share.ftp.handler.personal.mypage.MyDonationHandler;
import com.share.ftp.handler.personal.mypage.MyPointListHandler;
import com.share.ftp.handler.personal.mypage.MyRankingHandler;
import com.share.ftp.handler.personal.support.AdminQuestionConnectHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionSearchHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolDetailHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolHandler;
import com.share.ftp.handler.personal.volunteer.MyRejectedVolHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAcceptHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyCompleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestBookmarkHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralTotalApprovedListHandler;
import com.share.ftp.handler.personal.volunteer.VolOrgRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolOrgRequestApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolPersonalRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolPersonalRequestApplyListHandler;
import com.share.ftp.listener.AppInitListener;
import com.share.ftp.listener.FileListener;
import com.share.menu.Menu;
import com.share.menu.MenuFilter;
import com.share.menu.MenuGroup;
import com.share.request.RequestAgent;
import com.share.util.Prompt;

public class ClientApp {

  RequestAgent requestAgent;

  List<JoinDTO> joinDTOList = new ArrayList<>();
  // 함께해요 도메인(값)
  List<VolListDTO> volListDTOList = new ArrayList<>();

  // 개인, 기관 봉사 도메인
  List<GeneralRequestDTO> generalRequestDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestApplyDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestRejectDTOList = new ArrayList<>();

  // 소통해요 도메인(값)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();
  List<CommBoardReplyDTO> commBoardReplyDTOList = new ArrayList<>();

  // 챌린지 도메인(값)
  List<ChallengeJoinDTO> challengeJoinDTOList = new ArrayList<>();
  List<ChallengeQuestionDTO> challengeQuestionDTOList = new ArrayList<>();
  List<ChallengeReviewDTO> challengeReviewDTOList = new ArrayList<>();
  List<ChallengeQuestionDTO> challengeReplyList = new ArrayList<>();

  // 모금함 개설 신청 관련 도메인(값)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardApplyDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardRejectDTOList = new ArrayList<>();

  // 기부 도메인(값)
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();
  List<DonationRegisterDTO> donationMyRegisterDTOList;

  // 마이페이지 도메인(값)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<QuestionListDTO> myQuestionListDTOList = new ArrayList<>();

  // 관리자 도메인(값)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  //  List<QuestionDTO> questionDTOList = new ArrayList<>();
  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();


  // HashMap
  HashMap<String,Command> challengeReviewMap = new HashMap<>();

  // 메뉴 객체 컨트롤(Map)
  HashMap<String,Command> commands = new HashMap<>();

  // => 옵저버(리스너) 목록
  List<ApplicationContextListener> listeners = new ArrayList<>();

  // => 옵저버(리스너)를 등록하는 메서드
  public void addApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.add(listener);
  }

  // => 옵저버(리스너)를 제거하는 메서드
  public void removeApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.remove(listener);
  }

  private void notifyOnApplicationStarted() {
    HashMap<String, Object> params = new HashMap<>();
    params.put("joinDTOList", joinDTOList);
    params.put("volListDTOList", volListDTOList);
    params.put("generalRequestDTOList", generalRequestDTOList);
    params.put("generalRequestApplyDTOList", generalRequestApplyDTOList);
    params.put("generalRequestRejectDTOList", generalRequestRejectDTOList);
    params.put("commBoardDTOList", commBoardDTOList);
    params.put("commReviewDTOList", commReviewDTOList);
    params.put("commBoardReplyDTOList", commBoardReplyDTOList);
    params.put("challengeJoinDTOList", challengeJoinDTOList);
    params.put("challengeQuestionDTOList", challengeQuestionDTOList);
    params.put("challengeReviewDTOList", challengeReviewDTOList);
    params.put("donationBoardDTOList", donationBoardDTOList);
    params.put("donationBoardApplyDTOList", donationBoardApplyDTOList);
    params.put("donationBoardRejectDTOList", donationBoardRejectDTOList);
    params.put("donationRegisterDTOList", donationRegisterDTOList);
    params.put("myProfileDTOList", myProfileDTOList);
    params.put("myQuestionListDTOList", myQuestionListDTOList);
    params.put("challengeDTOList", challengeDTOList);
    params.put("noticeDTOList", noticeDTOList);
    //    params.put("questionDTOList", questionDTOList);
    params.put("approveOrgDTOList", approveOrgDTOList);

    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(params);
    }
  }

  private void notifyOnApplicationEnded() {
    HashMap<String, Object> params = new HashMap<>();
    params.put("joinDTOList", joinDTOList);
    params.put("volListDTOList", volListDTOList);
    params.put("generalRequestDTOList", generalRequestDTOList);
    params.put("generalRequestApplyDTOList", generalRequestApplyDTOList);
    params.put("generalRequestRejectDTOList", generalRequestRejectDTOList);
    params.put("commBoardDTOList", commBoardDTOList);
    params.put("commReviewDTOList", commReviewDTOList);
    params.put("commBoardReplyDTOList", commBoardReplyDTOList);
    params.put("challengeJoinDTOList", challengeJoinDTOList);
    params.put("challengeQuestionDTOList", challengeQuestionDTOList);
    params.put("challengeReviewDTOList", challengeReviewDTOList);
    params.put("donationBoardDTOList", donationBoardDTOList);
    params.put("donationBoardApplyDTOList", donationBoardApplyDTOList);
    params.put("donationBoardRejectDTOList", donationBoardRejectDTOList);
    params.put("donationRegisterDTOList", donationRegisterDTOList);
    params.put("myProfileDTOList", myProfileDTOList);
    params.put("myQuestionListDTOList", myQuestionListDTOList);
    params.put("challengeDTOList", challengeDTOList);
    params.put("noticeDTOList", noticeDTOList);
    //    params.put("questionDTOList", questionDTOList);
    params.put("approveOrgDTOList", approveOrgDTOList);

    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(params);
    }
  }

  //MenuGroup에서 사용할 필터를 정의한다.
  MenuFilter menuFilter = menu -> (menu.getAccessScope() & AuthLoginHandler.getUserAccessLevel()) > 0;


  class MenuItem extends Menu {

    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }
    @Override
    public void execute() {
      Command command = commands.get(menuId);
      try {
        command.execute(new CommandRequest(commands));
      } catch(Exception e) {
        System.out.printf("%s 명령을 실행하는 중 오류 발생!\n", menuId);
        e.printStackTrace();
      }
    }
  }

  // 전체 봉사보기 Handler 

  VolGeneralRequestAppliedListHandler volGeneralRequestAppliedListHandler = 
      new VolGeneralRequestAppliedListHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  GeneralRequestDTO personalRequestDTO = new GeneralRequestDTO();

  VolGeneralDoJoinHandler volRequestPersonalAppliedListDetailHandler =
      new VolGeneralDoJoinHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  // 함께해요 봉사 세부사항 Handler

  VolPersonalRequestAppliedListHandler volPersonalRequestAppliedListHandler = new VolPersonalRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  VolOrgRequestAppliedListHandler volOrgRequestAppliedListHandler = new VolOrgRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  //봉사참여자목록
  VolGeneralDoJoinListHandler volDoJoinHandler = 
      new VolGeneralDoJoinListHandler
      (generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler);

  DonationRegisterDTO donationRegisterDTO = new DonationRegisterDTO();


  // 모금함 개설 승인된 목록 Handler
  //  DonationBoardAppliedListHandler donationBoardAppliedListHandler =
  //      new DonationBoardAppliedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);
  //
  //  DonationPrompt donationPrompt = new DonationPrompt(donationBoardDTOList, donationRegisterDTOList);
  //  DonationAdminPrompt donationAdminPrompt = new DonationAdminPrompt(donationBoardDTOList, donationRegisterDTOList);


  public ClientApp() throws Exception {

    requestAgent = new RequestAgent("127.0.0.1", 8888);

    JoinDao netJoinDao = new NetJoinDao(requestAgent);
    CommBoardDao netCommBoardDao = new NetCommBoardDao(requestAgent);
    CommReviewDao netCommReviewDao = new NetCommReviewDao(requestAgent);
    ChallengeDao netChallengeDao = new NetChallengeDao(requestAgent);
    QuestionDao questionDao = new NetQuestionDao(requestAgent);
    //    ChallengeQuestionDao netChallengeQuestionDao = new NetChallengeDao(requestAgent);
    //    ChallengeReviewDao netChallengeReviewDao = new NetChallengeDao(requestAgent);


    //로그인, 로그아웃
    commands.put("/auth/login", new AuthLoginHandler(netJoinDao)); // 로그인
    commands.put("/auth/logout", new AuthLogoutHandler()); // 로그아웃
    commands.put("/auth/changeUserInfo", new AuthUpdateUserHandler()); // 마이페이지 나의정보
    commands.put("/auth/displayUserInfo", new AuthDisplayUserHandler()); // 마이페이지 나의정보수정

    //회원가입
    commands.put("/join/add", new JoinAddHandler(netJoinDao)); // 회원가입
    commands.put("/join/searchTelId", new JoinSearchTelIdHandler(netJoinDao)); // 폰번호로 아이디 찾기
    commands.put("/join/searchEmailId", new JoinSearchEmailIdHandler(netJoinDao)); // 이메일로 아이디 찾기
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(netJoinDao)); // 비밀번호 찾기

    commands.put("/volGeneralRequest/apply", new VolGeneralRequestApplyHandler(generalRequestDTOList,joinDTOList));
    commands.put("/volGeneralRequest/applyList", new VolGeneralRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volPersonalRequest/applyList", new VolPersonalRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volOrgRequest/applyList", new VolOrgRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volGeneralRequest/applyCompleteList", new VolGeneralRequestApplyCompleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/acceptApply", new VolGeneralRequestAcceptHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/rejectApply", new VolGeneralRequestRejectHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/appliedList", new VolGeneralRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volPersonalRequest/appliedList", new VolPersonalRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volOrgRequest/appliedList", new VolOrgRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/rejectedList", new VolGeneralRequestRejectedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/delete", new VolGeneralRequestDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/bookmark", new VolGeneralRequestBookmarkHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/totalApprovedList", new VolGeneralTotalApprovedListHandler(volPersonalRequestAppliedListHandler,volOrgRequestAppliedListHandler));
    commands.put("/volGeneralDoJoin/add", new VolGeneralDoJoinHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralDoJoin/list", new VolGeneralDoJoinListHandler(generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler));
    commands.put("/volGeneralDoJoin/delete", new VolGeneralDoJoinDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));

    //함께해요 (기관) + 마이페이지
    //    commands.put("/volRequestOrg/apply", new VolRequestOrgApplyHandler(orgRequestDTOList,joinDTOList));
    //    commands.put("/volRequestOrg/applyList", new VolRequestOrgApplyListHandler(orgRequestDTOList));
    //    commands.put("/volRequestOrg/applyCompleteList", new VolRequestOrgApplyCompleteListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/acceptApply", new VolRequestOrgAcceptApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectApply", new VolRequestOrgRejectApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/appliedList", new VolRequestOrgAppliedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectedList", new VolRequestOrgRejectedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));

    // 소통해요 나눔이야기
    commands.put("/commBoard/add", new CommBoardAddHandler(netCommBoardDao));
    commands.put("/commBoard/list", new CommBoardListHandler(netCommBoardDao));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(netCommBoardDao));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(netCommBoardDao));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(netCommBoardDao));
    commands.put("/commBoard/search", new CommBoardSearchHandler(netCommBoardDao));
    // commands.put("/commBoard/like", new CommBoardLikeHandler(netCommBoardDao)); 

    // 소통해요 댓글
    commands.put("/commBoardReply/connect", new CommBoardReplyConnectHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/add", new CommBoardReplyAddHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/list", new CommBoardReplyListHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/update", new CommBoardReplyUpdateHandler(commBoardDTOList, commBoardReplyDTOList));
    commands.put("/commBoardReply/delete", new CommBoardReplyDeleteHandler(commBoardDTOList, commBoardReplyDTOList));

    // commands.put("/commBoard/connect", new CommBoardReplyConnectHandler());

    // 소통해요 나눔이야기 BEST
    commands.put("/commBest/list", new CommBestListHandler(commBoardDTOList));
    commands.put("/commBest/detail", new CommBestDetailHandler(commBoardDTOList));

    // 소통해요 한줄후기
    commands.put("/commReview/add", new CommReviewAddHandler(netCommReviewDao));
    commands.put("/commReview/list", new CommReviewListHandler(netCommReviewDao));
    commands.put("/commReview/update", new CommReviewUpdateHandler(netCommReviewDao));
    commands.put("/commReview/delete", new CommReviewDeleteHandler(netCommReviewDao));
    commands.put("/commReview/search", new CommReviewSearchHandler(netCommReviewDao));

    // 챌린지
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(netChallengeDao));  // 챌린지 목록
    commands.put("/challenge/detail", new ChallengeDetailHandler(netChallengeDao)); // 챌린지 상세정보
    commands.put("/challengeJoin/join", new ChallengeJoinHandler(netChallengeDao));  // 참여하기
    commands.put("/challengeJoin/list", new ChallengeJoinListHandler(netChallengeDao));  // 참여자목록
    //    commands.put("/challengeDetail/like", new ChallengeLikeHandler(challengeDTOList));  // 챌린지 좋아요 기능(사용안함)
    commands.put("/challengeDetail/wish", new ChallengeWishHandler(netChallengeDao));  // 관심 챌린지 등록(찜하기)

    // 챌린지 참여인증&댓글
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(netChallengeDao));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(netChallengeDao));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(netChallengeDao));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(netChallengeDao));
    //    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(netChallengeReviewDao, netChallengeDao));
    commands.put("/challengeReview/connect", new ChallengeReviewConnectHandler(netChallengeDao));

    // 챌린지 문의하기
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(netChallengeDao));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(netChallengeDao));
    //    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(netChallengeDao));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(netChallengeDao));
    //    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(netChallengeDao, netChallengeQuestionDao));
    commands.put("/challengeQuestion/connect", new ChallengeQuestionConnectHandler(netChallengeDao));


    // 챌린지 랭킹
    commands.put("/ranking/list", new ChallengeRankingHandler(joinDTOList));  //전체랭킹(구현예정)
    commands.put("/myRanking/list", new MyRankingHandler(joinDTOList)); //나의랭킹(구현예정)

    // 모금함 (개설신청하기, 개설목록, 승인, 반려)

    DonationBoardDao donationBoardDao = new NetDonationBoardDao(requestAgent);

    DonationPrompt donationPrompt = new DonationPrompt(donationBoardDao);
    DonationAdminPrompt donationAdminPrompt = new DonationAdminPrompt(donationBoardDao);

    DonationRegisterDao donationRegisterDao = new NetDonationRegisterDao(requestAgent);

    commands.put("/donationBoard/list", new DonationBoardListHandler(donationBoardDao));
    commands.put("/donationBoard/apply", new DonationBoardApplyHandler(donationBoardDao));
    commands.put("/donationBoard/applyList", new DonationBoardApplyListHandler(donationBoardDao));
    commands.put("/donationBoard/appliedList", new DonationBoardAppliedListHandler(donationBoardDao));
    commands.put("/donationBoard/acceptApply", new DonationBoardAcceptApplyHandler(donationBoardDao));
    commands.put("/donationBoard/rejectApply", new DonationBoardRejectApplyHandler(donationBoardDao));
    commands.put("/donationBoard/rejectedList", new DonationBoardRejectedListHandler(donationBoardDao));
    commands.put("/donationBoard/applyDetail", new DonationBoardApplyDetailHandler(donationBoardDao, donationPrompt));
    commands.put("/adminDonationBoard/applyDetail", new DonationBoardAdminApplyDetailHandler(donationBoardDao, donationAdminPrompt));

    // 모금함 (기부하기)
    commands.put("/donationRegister/add", new DonationRegisterAddHandler(donationRegisterDao, donationBoardDao));
    commands.put("/donationRegister/participation", new DonationRegisterParticipationHandler(donationRegisterDao));
    commands.put("/donationRegister/totalMoney", new DonationRegisterTotalMoneyHandler(donationRegisterDao));

    commands.put("/donationBoardRegister/list", new DonationBoardRegisterListHandler(donationRegisterDao));
    commands.put("/donationBoardDetailRegister/add", new DonationBoardDetailRegisterAddHandler(donationBoardDao, donationRegisterDao));

    // 고객센터 문의사항
    commands.put("/question/add", new QuestionAddHandler(questionDao));
    commands.put("/question/list", new QuestionListHandler(questionDao));
    commands.put("/question/detail", new QuestionDetailHandler(questionDao));
    commands.put("/question/update", new QuestionUpdateHandler(questionDao));
    commands.put("/question/delete", new QuestionDeleteHandler(questionDao));
    commands.put("/question/search", new QuestionSearchHandler(questionDao));

    commands.put("/adminQuestion/connect", new AdminQuestionConnectHandler());
    //    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(myQuestionListDTOList));

    // 마이페이지
    commands.put("/myPage/info", new MyPageUpdateUserHandler(netJoinDao)); // 내정보 수정
    commands.put("/myPage/delete", new MyPageDeleteUserHandler(netJoinDao)); // 회원탈퇴

    commands.put("/myVol/applied", new MyAppliedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myVol/appliedDetail", new MyAppliedVolDetailHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myVol/rejected", new MyRejectedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));

    commands.put("/myChallenge/list", new MyChallengeListHandler(challengeDTOList));
    commands.put("/myChallenge/detail", new MyChallengeDetailHandler(challengeDTOList));
    commands.put("/myChallenge/wish", new MyChallengeWishHandler(challengeDTOList));


    commands.put("/myBoard/list", new MyBoardListHandler()); // 나의게시글 목록
    commands.put("/myBoard/detail", new MyBoardDetailHandler()); // 나의게시글 목록
    commands.put("/myBoard/update", new MyBoardUpdateHandler()); // 나의게시글 목록
    commands.put("/myBoard/delete", new MyBoardDeleteHandler()); // 나의게시글 목록

    commands.put("myPoint/list", new MyPointListHandler(joinDTOList)); // 나의포인트 

    commands.put("/orgMyVol/apply", new MyVolApplyListHandler()); // 기관 마이페이지 승인신청 
    commands.put("/orgMyVol/approve", new MyVolApproveListHandler()); // 기관 마이페이지 승인조회
    commands.put("/myDonation/list", new MyDonationHandler()); // 모금함
    commands.put("/myDonation/registerlist", new DonationRegisterMyListHandler(donationRegisterDao)); // 모금함
    commands.put("/myDonation//applyCompleteList", new DonationBoardApplyCompleteListHandler(donationBoardDao));

    // 관리자

    // 관리자 회원정보 조회
    commands.put("/join/list", new JoinListHandler(netJoinDao)); // 관리자가 회원 목록을 조회
    commands.put("/join/detail", new JoinDetailHandler(netJoinDao)); // 가입회원 상세보기 (관리자연결)
    commands.put("/join/delete", new AdminMemberDeleteHandler());

    // 관리자 공지사항 (개인 + 관리자)
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDTOList));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDTOList));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDTOList));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDTOList));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDTOList));
    commands.put("/adminNotice/search", new AdminNoticeSearchHandler(noticeDTOList));

    // 관리자 문의사항

    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/detail", new AdminQuestionDetailHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/update", new AdminQuestionUpdateHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/delete", new AdminQuestionDeleteHandler(myQuestionListDTOList));

    // 관리자 챌린지
    commands.put("/adminChallenge/add", new AdminChallengeAddHandler(netChallengeDao));
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(netChallengeDao));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(netChallengeDao));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(netChallengeDao));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(netChallengeDao));
    commands.put("/adminChallenge/QuestionList", new AdminChallengeQuestionListHandler(netChallengeDao));
    commands.put("/adminChallenge/replyAdd", new AdminChallengeReplyAddHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // 챌린지 답글 등록
    commands.put("/adminChallenge/replyUpdate", new AdminChallengeReplyUpdateHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // 챌린지 답글 변경
    commands.put("/adminChallenge/replyDelete", new AdminChallengeReplyDeleteHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // 챌린지 답글 삭제
    commands.put("/adminChallenge/replyConnect", new AdminChallengeReplyConnectlHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList)); // 챌린지 답글 등록, 변경, 삭제 연결

    // 관리자 기관승인

    //    challengeReviewMap.put("/challengeReview/add", new ChallengeReviewAddHandler(netChallengeDao, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/list", new ChallengeReviewListHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    //    challengeReviewMap.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/search", new ChallengeReviewSearchHandler(challengeReviewDTOList, challengeDTOList));
  }


  void service() {

    notifyOnApplicationStarted();

    createMenu().execute();
    Prompt.close();

    notifyOnApplicationEnded();

  }

  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*행복하Share*");
    mainMenuGroup.setMenuFilter(menuFilter);
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT, "/auth/login"));

    MenuGroup searchId = new MenuGroup("아이디찾기", ACCESS_LOGOUT);
    mainMenuGroup.add(searchId);
    searchId.add(new MenuItem("휴대폰번호로아이디찾기", ACCESS_LOGOUT, "/join/searchTelId"));
    searchId.add(new MenuItem("이메일로아이디찾기", ACCESS_LOGOUT, "/join/searchEmailId"));

    mainMenuGroup.add(new MenuItem("비밀번호찾기", ACCESS_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("회원가입", ACCESS_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_MEMBER_ADMIN, "/auth/logout"));



    // 함께해요
    MenuGroup doVolMenu = new MenuGroup("함께해요");
    mainMenuGroup.add(doVolMenu);
    doVolMenu.setMenuFilter(menuFilter);


    doVolMenu.add(new MenuItem("개인봉사신청양식", ACCESS_PERSONAL, "/volGeneralRequest/apply"));
    doVolMenu.add(new MenuItem("기관봉사신청양식", ACCESS_ORG, "/volGeneralRequest/apply")); 
    doVolMenu.add(new MenuItem("전체인증봉사리스트","/volGeneralRequest/appliedList")); 
    doVolMenu.add(createVolJoinMenu()); // 봉사 참여하기
    doVolMenu.add(new MenuItem("찜하기", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // 구현예정

    // 소통해요
    MenuGroup CommunityMenu = new MenuGroup("소통해요");
    mainMenuGroup.add(CommunityMenu);
    CommunityMenu.setMenuFilter(menuFilter);

    CommunityMenu.add(createReviewMenu());      // 나눔이야기
    CommunityMenu.add(createBestReviewMenu());  // 나눔이야기BEST
    CommunityMenu.add(createShortReviewMenu()); // 한줄후기

    // 챌린지
    MenuGroup challengeMenu = new MenuGroup("챌린지");
    mainMenuGroup.add(challengeMenu);
    challengeMenu.setMenuFilter(menuFilter);

    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    challengeMenu.add(monthlyChallengeMenu);
    monthlyChallengeMenu.setMenuFilter(menuFilter);

    //    MenuGroup challengeListMenu = new MenuGroup("챌린지 목록");
    //    monthlyChallengeMenu.add(challengeListMenu);

    //    MenuGroup challengeDetailMenu = new MenuGroup("챌린지 상세보기");
    //    monthlyChallengeMenu.add(challengeDetailMenu); 

    //    MenuGroup showChallengeDetailHandler = new MenuGroup("상세정보");  // 구현예정
    //    challengeDetailMenu.add(showChallengeDetailHandler);

    monthlyChallengeMenu.add(new MenuItem("챌린지 목록", "/adminChallenge/list"));

    monthlyChallengeMenu.add(new MenuItem("챌린지 상세정보", "/challenge/detail"));

    //    monthlyChallengeMenu.add(new MenuItem("참여하기", ACCESS_MEMBER, "/challengeJoin/join"));
    //
    //    monthlyChallengeMenu.add(new MenuItem("참여자 목록", ACCESS_MEMBER, "/challengeJoin/list"));
    //
    //    monthlyChallengeMenu.add(createChallengeReviewMenu()); // 참여인증&댓글
    //    monthlyChallengeMenu.add(createChallengeQuestionMenu()); // 문의하기

    challengeMenu.add(createMonthlyRankingMenu()); // 이달의 랭킹


    // 모금함
    mainMenuGroup.add(createDonationMenu());


    // 고객센터
    MenuGroup supportMenu = new MenuGroup("고객센터");
    mainMenuGroup.add(supportMenu);
    supportMenu.setMenuFilter(menuFilter);

    supportMenu.add(createNoticeMenu());      // 공지사항
    supportMenu.add(createQuestionMenu());         // 문의하기

    // 마이페이지
    MenuGroup MyPageMenu = new MenuGroup("마이페이지", ACCESS_MEMBER);
    mainMenuGroup.add(MyPageMenu);
    MyPageMenu.setMenuFilter(menuFilter);

    MyPageMenu.add(createMyProfileMenu());    // 회원정보
    MyPageMenu.add(createMyVolunteerMenu());  // 나의봉사
    MyPageMenu.add(createMyBoardMenu());      // 나의게시글
    MyPageMenu.add(createMyChallengeMenu());    // 나의챌린지
    MyPageMenu.add(createMyPointMenu());      // 나의포인트
    MyPageMenu.add(createMyDonationMenu());   // 나의모금함
    MyPageMenu.add(createOrgApprovewMenu());  // 기관승인신청
    MyPageMenu.add(new MenuItem("탈퇴", ACCESS_MEMBER, "/myPage/delete")); 

    // 관리자
    //    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    //    mainMenuGroup.add(adminMenu);

    mainMenuGroup.add(createAdminMemberMenu());      // 회원관리
    mainMenuGroup.add(createAdminDonationMenu());    // 기부관리
    mainMenuGroup.add(createAdminVolMenu());         // 봉사관리
    mainMenuGroup.add(createAdminNoticeMenu());      // 공지사항관리
    mainMenuGroup.add(createAdminAskMenu());         // 문의사항관리
    mainMenuGroup.add(createAdminChallengeMenu());   // 챌린지관리
    mainMenuGroup.add(createAdminApproveInfoMenu()); // 기관승인관리
    mainMenuGroup.add(createAdminCommMenu()); // 커뮤니티 관리

    mainMenuGroup.add(new MenuItem("탈퇴하기", ACCESS_MEMBER, "/myPage/delete"));

    return mainMenuGroup;



  }

  ////////////////////////////////////////////////////////////////////////////////////////////////



  private Menu createVolJoinMenu() {
    MenuGroup volJoinMenu = new MenuGroup("봉사참여하기");
    volJoinMenu.setMenuFilter(menuFilter);

    volJoinMenu.add(new MenuItem("개인봉사참여",ACCESS_PERSONAL,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("기관봉사참여",ACCESS_ORG,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("참여자정보보기","/volDoJoin/list")); 
    volJoinMenu.add(new MenuItem("찜하기", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // 구현예정
    volJoinMenu.add(createVolReviewMenu());
    volJoinMenu.add(createVolQuestionMenu()); 

    return volJoinMenu;
  }


  private Menu createVolReviewMenu() {
    MenuGroup volReview = new MenuGroup("참여인증&댓글");
    volReview.setMenuFilter(menuFilter);
    volReview.add(new MenuItem("봉사 참여인증 등록", ACCESS_MEMBER, "/volJoinReview/add"));
    volReview.add(new MenuItem("봉사 참여인증 목록", "/volJoinReview/list"));
    volReview.add(new MenuItem("봉사 참여인증 수정", ACCESS_MEMBER,"/volJoinReview/update"));
    volReview.add(new MenuItem("봉사 참여인증 삭제", ACCESS_MEMBER,"/volJoinReview/delete"));
    volReview.add(new MenuItem("봉사 참여인증 검색", "/volJoinReview/search"));

    return volReview;
  }


  private Menu createVolQuestionMenu() {
    MenuGroup VolQuestion = new MenuGroup("문의하기");
    VolQuestion.setMenuFilter(menuFilter);

    VolQuestion.add(new MenuItem("문의 등록", ACCESS_MEMBER, "/volQuestion/add"));
    VolQuestion.add(new MenuItem("문의 목록",  "/volQuestion/list"));
    VolQuestion.add(new MenuItem("문의 상세보기", ACCESS_MEMBER,"/volQuestion/detail"));
    VolQuestion.add(new MenuItem("문의 수정", ACCESS_MEMBER, "/volQuestion/update"));
    VolQuestion.add(new MenuItem("문의 삭제", ACCESS_MEMBER, "/volQuestion/delete"));
    VolQuestion.add(new MenuItem("문의 검색",  "/volQuestion/search"));

    return VolQuestion;
  }





  private Menu createReviewMenu() {
    MenuGroup reviewMenu = new MenuGroup("나눔 이야기");
    reviewMenu.setMenuFilter(menuFilter);

    reviewMenu.add(new MenuItem("등록", ACCESS_MEMBER_ADMIN, "/commBoard/add"));
    reviewMenu.add(new MenuItem("목록","/commBoard/list"));
    reviewMenu.add(new MenuItem("상세보기","/commBoard/detail"));
    //    reviewMenu.add(new MenuItem("변경", ACCESS_MEMBER_ADMIN,"/commBoard/update"));
    //    reviewMenu.add(new MenuItem("삭제",ACCESS_MEMBER_ADMIN,"/commBoard/delete"));
    reviewMenu.add(new MenuItem("검색",ACCESS_MEMBER_ADMIN,"/commBoard/search"));

    return reviewMenu;
  }

  private Menu createBestReviewMenu() {
    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");
    bestReviewMenu.setMenuFilter(menuFilter);

    bestReviewMenu.add(new MenuItem("목록","/commBest/list"));
    bestReviewMenu.add(new MenuItem("상세보기","/commBest/detail"));

    return bestReviewMenu;
  }

  private Menu createShortReviewMenu() {
    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");
    shortReviewMenu.setMenuFilter(menuFilter);

    shortReviewMenu.add(new MenuItem("등록", ACCESS_MEMBER_ADMIN, "/commReview/add"));
    shortReviewMenu.add(new MenuItem("목록", "/commReview/list")); 
    //    shortReviewMenu.add(new MenuItem("변경", ACCESS_MEMBER_ADMIN, "/commReview/update")); 
    //    shortReviewMenu.add(new MenuItem("삭제", ACCESS_MEMBER_ADMIN, "/commReview/delete")); 
    shortReviewMenu.add(new MenuItem("검색",ACCESS_MEMBER_ADMIN,"/commReview/search"));


    return shortReviewMenu;
  }


  public  Menu createChallengeReviewMenu() {
    MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
    ChallengeReview.setMenuFilter(menuFilter);
    ChallengeReview.add(new MenuItem("참여인증&댓글 등록", ACCESS_MEMBER, "/challengeReview/add"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 목록", "/challengeReview/list"));
    //    ChallengeReview.add(new MenuItem("참여인증&댓글 상세보기", ACCESS_MEMBER,"/challengeReview/detail"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 수정", ACCESS_MEMBER,"/challengeReview/update"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 삭제", ACCESS_MEMBER,"/challengeReview/delete"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 검색", "/challengeReview/search"));

    return ChallengeReview;
  }



  private Menu createChallengeQuestionMenu() {
    MenuGroup ChallengeQuestion = new MenuGroup("문의하기");
    ChallengeQuestion.setMenuFilter(menuFilter);
    ChallengeQuestion.add(new MenuItem("문의 등록", ACCESS_MEMBER, "/challengeQuestion/add"));
    ChallengeQuestion.add(new MenuItem("문의 목록",  "/challengeQuestion/list"));
    ChallengeQuestion.add(new MenuItem("문의 상세보기", ACCESS_MEMBER,"/challengeQuestion/detail"));
    ChallengeQuestion.add(new MenuItem("문의 수정", ACCESS_MEMBER, "/challengeQuestion/update"));
    ChallengeQuestion.add(new MenuItem("문의 삭제", ACCESS_MEMBER, "/challengeQuestion/delete"));
    ChallengeQuestion.add(new MenuItem("문의 검색",  "/challengeQuestion/search"));

    return ChallengeQuestion;
  }



  private Menu createMonthlyRankingMenu() {
    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
    monthlyRankingMenu.setMenuFilter(menuFilter);
    monthlyRankingMenu.add(new MenuItem("이달의 랭킹보기", "/ranking/list"));  //전체랭킹(구현예정)
    monthlyRankingMenu.add(new MenuItem("나의 랭킹보기", ACCESS_MEMBER, "/myRanking/list"));  //나의랭킹(구현예정)

    return monthlyRankingMenu;
  }

  private Menu createDonationMenu() {
    MenuGroup donationMenu = new MenuGroup("모금함");
    donationMenu.setMenuFilter(menuFilter);

    donationMenu.add(new MenuItem("전체 기부금 내역", "/donationRegister/totalMoney"));
    donationMenu.add(new MenuItem("전체 기부 참여내역", "/donationRegister/participation"));
    donationMenu.add(new MenuItem("모금함목록","/donationBoard/list"));
    donationMenu.add(new MenuItem("모금함 상세보기", "/donationBoard/applyDetail"));
    //    donationMenu.add(new MenuItem("기부하기", ACCESS_MEMBER, "/donationRegister/add"));
    donationMenu.add(new MenuItem("모금함 개설신청", ACCESS_ORG, "/donationBoard/apply"));

    return donationMenu;
  }


  private Menu createNoticeMenu() {
    MenuGroup noticeMenu = new MenuGroup("공지사항");
    noticeMenu.setMenuFilter(menuFilter);

    noticeMenu.add(new MenuItem("공지사항 등록", ACCESS_ADMIN,"/adminNotice/add"));
    noticeMenu.add(new MenuItem("공지사항 목록","/adminNotice/list"));
    noticeMenu.add(new MenuItem("공지사항 상세보기","/adminNotice/detail"));
    //    noticeMenu.add(new MenuItem("공지사항 변경",ACCESS_ADMIN,"/adminNotice/update"));
    //    noticeMenu.add(new MenuItem("공지사항 삭제",ACCESS_ADMIN,"/adminNotice/delete"));
    noticeMenu.add(new MenuItem("공지사항 검색","/adminNotice/search"));

    return noticeMenu;
  }

  private Menu createQuestionMenu() {
    MenuGroup question = new MenuGroup("문의하기");
    question.setMenuFilter(menuFilter);
    question.add(new MenuItem("등록", ACCESS_MEMBER,"/question/add"));
    question.add(new MenuItem("목록", "/question/list"));
    question.add(new MenuItem("상세보기", ACCESS_MEMBER_ADMIN, "/question/detail"));
    //    ask.add(new MenuItem("변경", ACCESS_MEMBER,"/question/update"));
    //    ask.add(new MenuItem("삭제", ACCESS_MEMBER, "/question/delete"));
    question.add(new MenuItem("검색", "/question/search"));

    return question;
  }


  // 마이페이지

  private Menu createMyProfileMenu() {
    MenuGroup myProfile = new MenuGroup("회원정보", ACCESS_MEMBER);
    myProfile.setMenuFilter(menuFilter);
    myProfile.add(new MenuItem("내 정보", "/auth/displayUserInfo"));
    myProfile.add(new MenuItem("내 정보 수정", "/auth/changeUserInfo"));

    return myProfile;
  }

  private Menu createMyVolunteerMenu() {
    MenuGroup myVolunteer = new MenuGroup("나의 봉사");
    myVolunteer.setMenuFilter(menuFilter);

    myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_PERSONAL,"/myVol/appliedDetail")); 
    myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_ORG,"/myVol/appliedDetail")); // 보완필요
    myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_PERSONAL,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_ORG,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_PERSONAL,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_ORG,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("개인봉사 삭제",ACCESS_PERSONAL,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("기관봉사 삭제",ACCESS_ORG,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("참여한봉사 취소하기",ACCESS_MEMBER,"/volGeneralDoJoin/delete"));    
    myVolunteer.add(new MenuItem("찜한봉사",ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // 구현예정

    return myVolunteer;
  }

  private Menu createMyBoardMenu() {

    MenuGroup myBoard = new MenuGroup("나의 게시글"); // 구현예정
    myBoard.setMenuFilter(menuFilter);
    myBoard.add(new MenuItem("나의게시글 목록","/myBoard/list"));
    myBoard.add(new MenuItem("나의게시글 상세보기","/myBoard/detail"));
    myBoard.add(new MenuItem("나의게시글 수정","/myBoard/update"));
    myBoard.add(new MenuItem("나의게시글 삭제","/myBoard/delete"));

    return myBoard;
  }
  private Menu createMyChallengeMenu() {

    MenuGroup myChallenge = new MenuGroup("나의 챌린지"); // 구현예정
    myChallenge.setMenuFilter(menuFilter);
    myChallenge.add(new MenuItem("나의챌린지 목록","/myChallenge/list"));
    myChallenge.add(new MenuItem("나의챌린지 상세보기","/myChallenge/detail"));
    myChallenge.add(new MenuItem("나의챌린지 찜한목록","/myChallenge/wish"));

    return myChallenge;
  }


  private Menu createMyDonationMenu() {
    MenuGroup myDonation = new MenuGroup("나의 모금함"); 
    myDonation.setMenuFilter(menuFilter);
    myDonation.add(new MenuItem("나의 모금함 개설신청서 확인", ACCESS_ORG, "/myDonation//applyCompleteList")); 
    myDonation.add(new MenuItem("나의 기부내역", ACCESS_MEMBER, "/myDonation/registerlist"));
    myDonation.add(new MenuItem("승인된 모금함 개설내역",ACCESS_ORG,"/donationBoard/appliedList")); 
    myDonation.add(new MenuItem("반려된 모금함 개설내역", ACCESS_ORG,"/donationBoard/rejectedList"));  

    return myDonation;
  }

  private Menu createMyPointMenu() {
    MenuGroup myPoint = new MenuGroup("나의 포인트"); // 구현예정
    myPoint.setMenuFilter(menuFilter);
    myPoint.add(new MenuItem("나의포인트확인","myPoint/list"));

    return myPoint;
  }


  private Menu createOrgApprovewMenu() {
    MenuGroup orgpprove = new MenuGroup("기관 승인 신청");
    orgpprove.setMenuFilter(menuFilter);

    orgpprove.add(new MenuItem("승인 요청하기","/orgMyVol/apply"));
    orgpprove.add(new MenuItem("승인 현황보기","/orgMyVol/approve"));

    return orgpprove;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////    

  // 관리자

  private Menu createAdminMemberMenu() {
    MenuGroup adminMemberMenu = new MenuGroup("회원정보 관리", ACCESS_ADMIN);
    adminMemberMenu.setMenuFilter(menuFilter);

    adminMemberMenu.add(new MenuItem("회원목록",ACCESS_ADMIN, "/join/list"));
    adminMemberMenu.add(new MenuItem("가입회원 상세보기", ACCESS_ADMIN,"/join/detail"));
    adminMemberMenu.add(new MenuItem("회원추방",ACCESS_ADMIN,"/adminMember/list"));

    return adminMemberMenu;
  }

  private Menu createAdminDonationMenu() {
    MenuGroup adminDonationMenu = new MenuGroup("모금함 관리" ,ACCESS_ADMIN);
    adminDonationMenu.setMenuFilter(menuFilter);

    adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 목록",ACCESS_ADMIN, "/donationBoard/applyList"));
    adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 상세보기",ACCESS_ADMIN, "/adminDonationBoard/applyDetail"));
    //    adminDonationMenu.add(new MenuItem("모금함 개설 승인하기", "/donationBoard/acceptApply"));
    //    adminDonationMenu.add(new MenuItem("모금함 개설 반려하기", "/donationBoard/rejectApply"));

    return adminDonationMenu;
  }

  private Menu createAdminVolMenu() {
    MenuGroup adminVolMenu = new MenuGroup("봉사활동 관리", ACCESS_ADMIN);
    adminVolMenu.setMenuFilter(menuFilter);

    adminVolMenu.add(new MenuItem("개인봉사신청내역",ACCESS_ADMIN,"/volPersonalRequest/applyList"));
    adminVolMenu.add(new MenuItem("기관봉사신청내역",ACCESS_ADMIN,"/volOrgRequest/applyList")); // 구현예정
    adminVolMenu.add(new MenuItem("개인봉사승인하기",ACCESS_ADMIN,"/volGeneralRequest/acceptApply"));
    adminVolMenu.add(new MenuItem("기관봉사승인하기",ACCESS_ADMIN,"/volGeneralRequest/acceptApply")); // 구현예정
    adminVolMenu.add(new MenuItem("개인봉사반려하기",ACCESS_ADMIN,"/volGeneralRequest/rejectApply"));
    adminVolMenu.add(new MenuItem("기관봉사반려하기",ACCESS_ADMIN,"/volGeneralRequest/rejectApply")); // 구현예정
    adminVolMenu.add(new MenuItem("개인봉사삭제하기",ACCESS_ADMIN,"/volGeneralRequest/delete"));

    return adminVolMenu;
  }

  private Menu createAdminNoticeMenu() {
    MenuGroup adminNoticeMenu = new MenuGroup("공지사항 관리", ACCESS_ADMIN);
    adminNoticeMenu.setMenuFilter(menuFilter);

    adminNoticeMenu.add(new MenuItem("공지사항 등록",ACCESS_ADMIN,"/adminNotice/add"));
    adminNoticeMenu.add(new MenuItem("공지사항 목록",ACCESS_ADMIN,"/adminNotice/list"));
    adminNoticeMenu.add(new MenuItem("공지사항 상세보기",ACCESS_ADMIN,"/adminNotice/detail"));
    //    adminNoticeMenu.add(new MenuItem("공지사항 변경",ACCESS_ADMIN,"/adminNotice/update"));
    //    adminNoticeMenu.add(new MenuItem("공지사항 삭제",ACCESS_ADMIN,"/adminNotice/delete"));
    adminNoticeMenu.add(new MenuItem("공지사항 검색",ACCESS_ADMIN,"/adminNotice/search"));

    return adminNoticeMenu;
  }

  private Menu createAdminAskMenu() {
    MenuGroup adminAskInfo = new MenuGroup("문의사항 관리", ACCESS_ADMIN);
    adminAskInfo.setMenuFilter(menuFilter);

    //    adminAskInfo.add(new MenuItem("문의사항 등록",ACCESS_ADMIN,"/question/add"));
    adminAskInfo.add(new MenuItem("문의사항 목록",ACCESS_ADMIN,"/question/list"));
    adminAskInfo.add(new MenuItem("문의사항 상세보기",ACCESS_ADMIN,"/question/detail"));
    //    adminAskInfo.add(new MenuItem("문의사항 변경",ACCESS_ADMIN,"/question/update"));
    //    adminAskInfo.add(new MenuItem("문의사항 삭제",ACCESS_ADMIN,"/question/delete"));
    adminAskInfo.add(new MenuItem("문의사항 검색",ACCESS_ADMIN,"/question/search"));

    return adminAskInfo;
  }


  private Menu createAdminChallengeMenu() {
    MenuGroup adminChallengeInfo = new MenuGroup("챌린지 관리", ACCESS_ADMIN);
    adminChallengeInfo.setMenuFilter(menuFilter);

    adminChallengeInfo.add(new MenuItem("챌린지 등록",ACCESS_ADMIN,"/adminChallenge/add"));
    adminChallengeInfo.add(new MenuItem("챌린지 목록",ACCESS_ADMIN,"/adminChallenge/list"));
    adminChallengeInfo.add(new MenuItem("챌린지 상세보기",ACCESS_ADMIN,"/adminChallenge/detail"));
    //    adminChallengeInfo.add(new MenuItem("챌린지 변경","/adminChallenge/update"));
    //    adminChallengeInfo.add(new MenuItem("챌린지 삭제","/adminChallenge/delete"));
    //    adminChallengeInfo.add(new MenuItem("챌린지 문의답글 등록","/adminChallengeQuestion/add"));

    return adminChallengeInfo;
  }

  private Menu createAdminApproveInfoMenu() {
    MenuGroup adminApproveInfo = new MenuGroup("기관 승인", ACCESS_ADMIN);
    adminApproveInfo.setMenuFilter(menuFilter);

    adminApproveInfo.add(new MenuItem("기관승인신청 목록",ACCESS_ADMIN,"/adminChallenge/list"));
    adminApproveInfo.add(new MenuItem("기관승인신청 내용",ACCESS_ADMIN,"/adminChallenge/detail"));
    adminApproveInfo.add(new MenuItem("기관승인신청 변경",ACCESS_ADMIN,"/adminChallenge/update"));
    adminApproveInfo.add(new MenuItem("기관승인신청 삭제",ACCESS_ADMIN,"/adminChallenge/delete"));

    return adminApproveInfo;
  }
  private Menu createAdminCommMenu() {
    MenuGroup adminCommInfo = new MenuGroup("커뮤니티 관리", ACCESS_ADMIN);
    adminCommInfo.setMenuFilter(menuFilter);

    adminCommInfo.add(new MenuItem("나눔이야기 목록", ACCESS_MEMBER_ADMIN, "/commBoard/list"));
    adminCommInfo.add(new MenuItem("나눔이야기", ACCESS_MEMBER_ADMIN, "/commBoard/detail")); 
    adminCommInfo.add(new MenuItem("나눔이야기 Best 상세보기", ACCESS_MEMBER_ADMIN, "/commBest/detail")); 
    adminCommInfo.add(new MenuItem("한줄후기 목록",ACCESS_MEMBER_ADMIN,"/commReview/list"));


    return adminCommInfo;
  }


  public static void main(String[] args) throws Exception {

    ClientApp app = new ClientApp(); 
    app.addApplicationContextListener(new AppInitListener());
    app.addApplicationContextListener(new FileListener());
    app.service();

    Prompt.close();
  }


}

