package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.MemberService;
import com.gd.lms.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RegisterController {
	// MemberService 객체 주입
	@Autowired
	MemberService memberService;

	// 멤버 회원가입 Form
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	// register.jsp 접속시 Register 버튼을 클릭시 회원가입 액션을 처리하는 메소드
	// 파라미터 : Member
	// 리턴값 : login 페이지로 이동
	// 멤버 회원가입 Action
	@PostMapping("/register")
	public String register(Member member, @RequestParam(value = "member") Member Paramember) {

		String accountId = Paramember.getAccountId();
		String createDate = Paramember.getCreateDate();
		String managerIdAccess = Paramember.getManagerIdAccess();
		String memberAddress = Paramember.getMemberAddress();
		String memberBirth = Paramember.getMemberBirth();
		String datailAddress = Paramember.getMemberDetailAddress();
		String memberEmail = Paramember.getMemberEmail();
		String memberGender = Paramember.getMemberGender();
		String memberMarry = Paramember.getMemberMarry();
		String military = Paramember.getMemberMilitary();
		String memberName = Paramember.getMemberName();
		String memberPhone = Paramember.getMemberPhone();
		String updateDate = Paramember.getUpdateDate();

		// 디버깅
		log.debug(TeamColor.PSY + "accountId : " + accountId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "createDate : " + createDate + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "managerIdAccess : " + managerIdAccess + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "memberAddress : " + memberAddress + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "memberBirth : " + memberBirth + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "datailAddress : " + datailAddress + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "memberEmail : " + memberEmail + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "memberGender : " + memberGender + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "memberMarry : " + memberMarry + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "military : " + military + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "memberName : " + memberName + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "memberPhone : " + memberPhone + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PSY + "updateDate : " + updateDate + TeamColor.TEXT_RESET);

		// 요청받은 값들을 addmember 객체에 셋팅
		Member addmember = new Member();
		addmember.setAccountId(accountId);
		addmember.setCreateDate(createDate);
		addmember.setManagerIdAccess(managerIdAccess);
		addmember.setMemberAddress(memberAddress);
		addmember.setMemberBirth(memberBirth);
		addmember.setMemberDetailAddress(datailAddress);
		addmember.setMemberEmail(memberEmail);
		addmember.setMemberGender(memberGender);
		addmember.setMemberMarry(memberMarry);
		addmember.setMemberMilitary(military);
		addmember.setMemberName(memberName);
		addmember.setMemberPhone(memberPhone);
		addmember.setUpdateDate(updateDate);
		// addmember 디버깅
		log.debug(TeamColor.PSY + addmember + "<-- addmember" + TeamColor.TEXT_RESET);

		// 서비스에서 회원가입 결과 가져오기
		int row = memberService.addMember(member);

		if (row != 0) { // 성공
			// 파라미터 디버깅
			log.debug(TeamColor.PSY + " add 성공" + TeamColor.TEXT_RESET);
		} else { // 실패
			log.debug(TeamColor.PSY + " add 실패" + TeamColor.TEXT_RESET);
		}
		return "redirect:/register";
	}

}
