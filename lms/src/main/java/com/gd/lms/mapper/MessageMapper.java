package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Message;

@Mapper
public interface MessageMapper {
	// 전체 메시지 리스트 조회
	List<Message> selectMessageList(String accountId);
	// 받은 메시지 리스트 조회
	List<Message> selectReceiveMessageList(String toId);
	// 보낸 메시지 리스트 조회
	List<Message> selectSentMessageList(String fromId);
	// 안 읽은 메시지 카운팅
	int selectUnreadMessageCnt(String toId);	// toID로 받은 메시지-읽지 않은 메시지 조회
	// 수/발신 메시지 상세보기
	Message selectMessageOne(int messageNo);
	// 메시지 보내기
	Message insertMessage(Message message);
	// 받은 메시지 삭제
	int deleteMessage(int messageNo);
	// 상대가 보기 전 메시지 발송 취소
	int cancelMessage(int messageNo);
	
}
