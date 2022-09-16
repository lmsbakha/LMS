package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Multiplechoice;

@Mapper
public interface MultiplechoiceMapper {
	// 객관식 문제를 추가하는 메소드
	// 파라미터 : Multiplechoice
	// 리턴값 : 정상적으로 추가되었음을 확인시켜줄 int
	int insertMultiplechoice(Multiplechoice multiplechoice);
	
	// 특정 과목과 연관된 객관식 문제 리스트
	// 파라미터 : subjectName
	// 리턴값 : Multiplechoice
	List<Multiplechoice> selectMultiplechoiceList(String subjectName);
	
	// 객관식 문제를 수정하는 메소드
	// 파라미터 : Multiplechoice 
	// 리턴값 : Multiplechoice
	Multiplechoice updateMultiplechoice(Multiplechoice multiplechoice);
	
	// 객관식 문제를 삭제하는 메소드
	// 파라미터 : multiplechoice_no(PK)
	// 리턴값 : 정상적으로 삭제되었음을 확인시켜줄 int
	int deleteMultiplechoice(Multiplechoice multiplechoice);
}
