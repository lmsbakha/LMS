package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Notice;

@Mapper
public interface NoticeMapper {
	// 공지사항 리스트
	List<Map<String, Object>> selectNoticeList();
	// 공지사항 작성 액션
	int addNotice(Notice notice);
	// 수정
	// 삭제
}
