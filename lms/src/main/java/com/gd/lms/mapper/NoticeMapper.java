package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Notice;

@Mapper
public interface NoticeMapper {
	// 공지사항 리스트
	List<Notice> selectNoticeList(Map<String, Object>noticeMap);
	// 총 공지글 개수
	int selectTotalNotice();
	// 공지사항 작성 액션
	int insertNotice(Notice notice);
	// 공지글 상세보기
	public Notice selectNoticeOne(int noticeNo);
	// 조회수 증가
	public int updateNoticeCount(Notice notice);
	// 수정 액션
	public int updateNotice(Notice notice);
	// 삭제
	public int deleteNotice(int noticeNo);
}
