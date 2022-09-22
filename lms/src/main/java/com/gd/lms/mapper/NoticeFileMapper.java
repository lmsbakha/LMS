package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.NoticeFile;

@Mapper
public interface NoticeFileMapper {
	// 공지글 파일 불러오기(다운로드)
	NoticeFile selectNoticeFile(int noticeFileNo);
	// 공지글 파일 첨부
	int insertNoticeFile(NoticeFile noticeFile);
	// 공지글 파일 삭제
	int deleteNoticeFile(int noticeNo);
}
