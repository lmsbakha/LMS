package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.NoticeFile;

@Mapper
public interface NoticeFileMapper {
	// 공지글 파일 불러오기(다운로드)
	NoticeFile selectNoticeFile(int noticeFileNo);
	// 공지글 파일 첨부
	int insertNoticeFile(NoticeFile noticeFile);
	// 게시글 하나에 들어가 있는 첨부파일 리스트 
	String selectNoticeFileList(int noticeNo);
	// 공지글 파일 삭제
	int deleteNoticeFile(int noticeNo);
	
}
