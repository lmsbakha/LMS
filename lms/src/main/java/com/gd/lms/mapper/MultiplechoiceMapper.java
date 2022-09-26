package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Multiplechoice;

@Mapper
public interface MultiplechoiceMapper {
	// 랜덤하게 문제 뽑기
	// 파라미터 : subjectName, multichoiceCnt Map<String, Object>
	// 리턴값 : Map<String, Object>
	List<Map<String, Object>> selectMultiplechoiceListByRandom(Map<String, Object> paramRandom);

	// 객관식 문제 상세보기
	// 파라미터 : questionNo
	// 리턴값 : Map<String, Object>
	Map<String, Object> selectMultiplechoiceOne(int questionNo);

	// 객관식 문제를 추가하는 메소드
	// 파라미터 : Multiplechoice
	// 리턴값 : 정상적으로 추가되었음을 확인시켜줄 int와 multiplechoice_no값
	int insertMultiplechoice(Multiplechoice multiplechoice);

	// 검색어(특정 과목)와 연관된 객관식 문제 리스트
	// 파라미터 : subjectName
	// 리턴값 : Multiplechoice
	List<Map<String, Object>> selectMultiplechoiceList(String subjectName);

	// 객관식 문제를 수정하는 메소드
	// 파라미터 : Multiplechoice 
	// 리턴값 : int
	int updateMultiplechoice(Multiplechoice multiplechoice);

	// 객관식 문제를 삭제하는 메소드
	// 파라미터 : multiplechoice_no(PK)
	// 리턴값 : 정상적으로 삭제되었음을 확인시켜줄 int
	int deleteMultiplechoice(Multiplechoice multiplechoice);

	// 객관식 문제를 삭제하는 메소드
	// 파라미터 : questionNo
	// 리턴값 : 정상적으로 삭제되었음을 확인시켜줄 int
	int deleteMultiplechoiceByQuestionNo(int questionNo);
	
	// 답안지 채점하기
	// 파라미터 : Map<String, Object>
	// 리턴값: 맞으면 1 틀리면 0
	int selectGradingAnswerSheet(Map<String, Object> as);
}
