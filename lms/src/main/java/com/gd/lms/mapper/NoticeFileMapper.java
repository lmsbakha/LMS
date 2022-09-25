package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.NoticeFile;

@Mapper
public interface NoticeFileMapper {
	// 공지글 파일 불러오기(다운로드)
	List<String> selectNoticeFile(int noticeFileNo);
	// 공지글 파일 첨부
	int insertNoticeFile(NoticeFile noticeFile);
	// 게시글 하나에 들어가 있는 첨부파일 리스트(복수일 수 있음)
	List<NoticeFile> selectNoticeFileList(int noticeNo);
	// 공지글 파일 삭제
	int deleteNoticeFile(String noticeFileName);
}
