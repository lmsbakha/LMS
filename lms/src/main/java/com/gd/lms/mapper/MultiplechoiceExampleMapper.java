package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.MultiplechoiceExample;

@Mapper
public interface MultiplechoiceExampleMapper {
	// 객관식 문제 보기 추가하는 메소드
	// 파라미터 : MultiplechoiceExample  
	// 리턴값 : int
	int insertMultiplechoiceExample(MultiplechoiceExample multiplechoiceExample);
	
	// 특정 문제와 관련된 보기(1,2,3,4,5)를 보여주는 메소드
	// 파라미터 : 
}
