package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.mapper.QnaMapper;
import com.gd.lms.vo.QnaQuestion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	
	
	// 질문 리스트 조회
	public List<QnaQuestion> getQnaList() {
		return qnaMapper.selectQnaList();
	}
	
	// 질문 상세보기
	
	/////////////////////////////////////////////////////
	
	
	// 질문 작성 액션
	
	
	// 질문 수정 액션
	
	
	// 질문 삭제 액션	
	
	
	/////////////////////////////////////////////////////
		
	
	// 답변 작성 액션
	
	
	// 답변 수정 액션
	
	
	// 답변 삭제 액션
}
