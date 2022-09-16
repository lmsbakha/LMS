package com.gd.lms.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Subject;

@Mapper
public interface SubjectMapper {
	// 전체 과목 리스트 가져오기
	// 파라미터 : X
	// 리턴값 : List<Subject>
	List<Subject> selectSujectList();
}
