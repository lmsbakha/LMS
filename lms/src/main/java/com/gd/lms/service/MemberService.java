package com.gd.lms.service;

import java.io.File;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.AccountMapper;
import com.gd.lms.mapper.AdminMapper;
import com.gd.lms.mapper.ManagerMapper;
import com.gd.lms.mapper.MemberFileMapper;
import com.gd.lms.mapper.StudentMapper;
import com.gd.lms.mapper.TeacherMapper;
import com.gd.lms.vo.Account;
import com.gd.lms.vo.Admin;
import com.gd.lms.vo.Manager;
import com.gd.lms.vo.MemberFile;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.Teacher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MemberService {
	// StudentMapper 객체 주입
	@Autowired
	private StudentMapper studentMapper;

	// TeacherMapper 객체 주입
	@Autowired
	private TeacherMapper teacherMapper;

	// ManagerMapper 객체 주입
	@Autowired
	private ManagerMapper managerMapper;

	// AdminMapper 객체 주입
	@Autowired
	private AdminMapper adminMapper;

	// AccountMapper 객체 주입
	@Autowired
	private AccountMapper accountMapper;

	// MemberFileMapper 객체 주입
	@Autowired
	private MemberFileMapper memberFileMapper;

	// 학생 정보 가져오기
	// 파라미터 : loginId
	// 리턴 값 : educationNo, studentName
	public Map<String, Object> getStudenetInfo(String loginId) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + loginId + "<-- loginId" + TeamColor.TEXT_RESET);

		// Mapper call
		Map<String, Object> studentInfo = studentMapper.selectStudentInfo(loginId);
		// 디버깅
		log.debug(TeamColor.PSJ + studentInfo + "<-- studentInfo" + TeamColor.TEXT_RESET);

		return studentInfo;
	}

	// 로그인한 아이디와 연관된 강사정보
	// 파라미터 : accoutnId
	// 리턴값 : Map<String, Object> teacherName, lectureName, lectureActive,
	// lectureStartDate, lectureEndDate 받아오기
	public Map<String, Object> getInfoAboutTeacher(String accountId) {
		// 파라미터 디버깅
		log.debug(TeamColor.PSJ + accountId + "<-- accountId" + TeamColor.TEXT_RESET);

		// Mapper call
		Map<String, Object> infoAboutTeacher = teacherMapper.selectInfoAboutTeacher(accountId);
		// 디버깅
		log.debug(TeamColor.PSJ + infoAboutTeacher + "<-- infoAboutTeacher" + TeamColor.TEXT_RESET);
		return infoAboutTeacher;
	};

	// 학생 목록
	public List<Student> getStudentList() {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList" + TeamColor.TEXT_RESET);

		List<Student> studentList = studentMapper.selectStudentList();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList studentList : " + studentList + TeamColor.TEXT_RESET);

		return studentList;
	}

	// 강사 목록
	public List<Teacher> getTeacherList() {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getManagerList" + TeamColor.TEXT_RESET);

		List<Teacher> teacherList = teacherMapper.selectTeacherList();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList teacherList : " + teacherList + TeamColor.TEXT_RESET);

		return teacherList;

	}

	// 행정 목록
	public List<Manager> getManagerList() {
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getTeacherList" + TeamColor.TEXT_RESET);

		List<Manager> managerList = managerMapper.selectManagerList();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getStudentList teacherList : " + managerList + TeamColor.TEXT_RESET);

		return managerList;
	}

	// 멤버 개인정보 상세보기
	public Map<String, Object> getMemberOne(Account account) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne account : " + account + TeamColor.TEXT_RESET);

		// accountId 받아오기
		String accountId = account.getAccountId();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne accountId : " + accountId + TeamColor.TEXT_RESET);
		// accountLevel 받아오기
		int accountLevel = account.getAccountLevel();
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne accountLevel : " + accountLevel + TeamColor.TEXT_RESET);

		Map<String, Object> memberMap = new HashMap<>();

		if (accountLevel == 1) {
			Student member = studentMapper.selectStudentOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne student member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		} else if (accountLevel == 2) {
			Teacher member = teacherMapper.selectTeacherOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne teacher member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		} else if (accountLevel == 3) {
			Manager member = managerMapper.selectManagerOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne manager member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		} else {
			Admin member = adminMapper.selectAdminOne(accountId);
			// 디버깅
			log.debug(TeamColor.PCW + "MemberService getMemberOne admin member : " + member + TeamColor.TEXT_RESET);
			// memberMap에 담기
			memberMap.put("member", member);
		}

		// 멤버 사진파일 MemberFile

		MemberFile memberFile = memberFileMapper.selectMemberFile(accountId);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getMemberOne memberFile : " + memberFile + TeamColor.TEXT_RESET);
		memberMap.put("memberFile", memberFile);

		return memberMap;
	}

	// 비밀번호 & 정보 & 탈퇴 를 위한 비밀번호 확인하기
	public int getAccountPwCheck(Account account) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getAccountPwCheck account : " + account + TeamColor.TEXT_RESET);

		int row = accountMapper.accountPwCheck(account);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService getAccountPwCheck row : " + row + TeamColor.TEXT_RESET);

		return row;
	}

	// 학생, 강사, 행정 비밀번호 변경
	public int modifyAccountPw(Account account) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyAccountPw account : " + account + TeamColor.TEXT_RESET);

		int row = accountMapper.updateMemberAccountPw(account);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyAccountPw row : " + row + TeamColor.TEXT_RESET);

		return row;
	}

	// 학생 정보 수정하기
	public int modifyStudent(Student student) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyStudent student : " + student + TeamColor.TEXT_RESET);

		int row = studentMapper.updateStudent(student);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyAccountPw row : " + row + TeamColor.TEXT_RESET);

		return row;
	}

	// 학생 탈퇴하기
	public int removeStudent(Account account) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService removeStudent account : " + account + TeamColor.TEXT_RESET);

		int accountStateRow = studentMapper.updateAccountStateStudent(account);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService removeStudent accountStateRow : " + accountStateRow
				+ TeamColor.TEXT_RESET);

		return studentMapper.deleteStudent(account.getAccountId());
	}

	// 강사 정보 수정하기
	public int modifyTeacher(Teacher teacher) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyTeacher teacher : " + teacher + TeamColor.TEXT_RESET);

		int row = teacherMapper.updateTeacher(teacher);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService  modifyTeacher row : " + row + TeamColor.TEXT_RESET);

		return row;
	}

	// 강사 탈퇴하기
	public int removeTeacher(Account account) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService removeTeacher account : " + account + TeamColor.TEXT_RESET);

		int accountStateRow = teacherMapper.updateAccountStateTeacher(account);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService removeTeacher accountStateRow : " + accountStateRow
				+ TeamColor.TEXT_RESET);

		return teacherMapper.deleteTeacher(account.getAccountId());
	}

	// 행정 정보 수정하기
	public int modifyManager(Manager manager) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyManager manager : " + manager + TeamColor.TEXT_RESET);

		int row = managerMapper.updateManager(manager);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService  modifyManager row : " + row + TeamColor.TEXT_RESET);

		return row;
	}

	// 행정 탈퇴하기
	public int removeManager(Account account) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService removeManager account : " + account + TeamColor.TEXT_RESET);

		int accountStateRow = managerMapper.updateAccountStateManager(account);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService removeManager accountStateRow : " + accountStateRow
				+ TeamColor.TEXT_RESET);

		return managerMapper.deleteManager(account.getAccountId());
	}

	// memberFile 수정하기 (삭제 후 재업로드)
	public int modifyMemberFile(String accountId, String path, String memberFileName, MultipartFile mf) {

		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyMemberFile accountId : " + accountId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "MemberService modifyMemberFile path : " + path + TeamColor.TEXT_RESET);
		log.debug(TeamColor.PCW + "MemberService modifyMemberFile memberFileName : " + memberFileName
				+ TeamColor.TEXT_RESET);

		// File - memberPhoto에서 기존 memberFile 삭제하기
		File f = new File(path + memberFileName);
		f.delete(); // 삭제

		// new memberFile 객체
		MemberFile memberFile = new MemberFile();

		// memberFile 삭제
		int deleteRow = memberFileMapper.deleteMemberFile(accountId);
		// 디버깅
		log.debug(TeamColor.PCW + "MemberService modifyMemberFile deleteRow : " + deleteRow + TeamColor.TEXT_RESET);

		// 삭제가 성공했다면 다시 재업로드
		if (deleteRow == 1) {
			// 원래 파일 이름 추출
			String origName = mf.getOriginalFilename();

			// 파일 이름으로 쓸 UUID 생성 파일 이름 중복방지
			String fileName = UUID.randomUUID().toString();

			// 확장자 추출(ex : .png)
			String extension = origName.substring(origName.lastIndexOf("."));

			// - 제거
			fileName = fileName.replace("-", "");
			// uuid와 확장자 결합
			fileName += extension;

			// 파일을 불러올 때 사용할 파일 경로
			String savedPath = path + fileName;

			// MemberFile 데이터바인딩
			memberFile.setAccountId(accountId);
			memberFile.setMemberFileName(fileName);
			memberFile.setMemberFileOriginName(origName);
			memberFile.setMemberFileType(mf.getContentType());
			memberFile.setMemberFileSize(mf.getSize());

			// 디버깅
			log.debug(TeamColor.PCW + "MemberService modifyMemberFile :" + memberFile + TeamColor.TEXT_RESET);

			// memberFile 파일 입력
			int insertRow = memberFileMapper.insertMemberFile(memberFile);

			// 디버깅
			log.debug(TeamColor.PCW + "AccountService memberFile row:" + insertRow + TeamColor.TEXT_RESET);

			if (insertRow == 1) {
				try {
					// 파일 위치에 저장
					mf.transferTo(new File(savedPath));
				} catch (Exception e) { // runTime계열 익셉션 아니라서 꼭 예외 처리 필요
					e.printStackTrace();

					throw new RuntimeException(); // 예외 처리하면 트랜잭션 발생안하니까 컴파일 가능한 예외 발생시켜주기
				}
				return insertRow;
			}
			return insertRow;
		}
		return deleteRow;
	}

}
