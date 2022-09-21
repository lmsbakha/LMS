package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.MultiplechoiceExample;

@Mapper
public interface MultiplechoiceExampleMapper {
	// 객관식 문제 보기 추가하는 메소드
	// 파라미터 : MultiplechoiceExample  
	// 리턴값 : int
	int insertMultiplechoiceExample(MultiplechoiceExample multiplechoiceExample);
	
	// 특정 문제와 관련된 보기(1,2,3,4,5)를 보여주는 메소드
	// 파라미터 : questionNo
	// 리턴값 : List<MultiplechoiceExample>
	List<MultiplechoiceExample> selectMultiplechoiceExampleList(int questionNo);
	
	// 보기 지문 수정하는 메소드
	// 파라미터 : MultiplechoiceExample
	// 리턴값 : 정상적으로 수정되었는지 확인할 int
	int updateMultiplechoiceExample(MultiplechoiceExample multiplechoiceExample);
}
