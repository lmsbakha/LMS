package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.NoticeFile;

@Mapper
public interface NoticeFileMapper {
	// 공지글 파일 첨부
	int insertNoticefile(NoticeFile noticeFile);
	// 공지글 파일 삭제

}
