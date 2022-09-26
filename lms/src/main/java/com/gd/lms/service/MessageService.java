package com.gd.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.MessageMapper;
import com.gd.lms.vo.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MessageService {
	@Autowired
	private MessageMapper messageMapper;
	
	// 전체 메시지 리스트 조회
	public List<Message> getMessageList(String fromId, String toId ){
		log.debug(TeamColor.LHN + "전체 메시지 리스트 조회" + TeamColor.TEXT_RESET);
		
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("fromId", fromId);
		messageMap.put("toId", toId);
		
		//디버깅
		log.debug(TeamColor.LHN + "fromId: " + fromId + TeamColor.TEXT_RESET);
		log.debug(TeamColor.LHN + "toId: " + toId + TeamColor.TEXT_RESET);
		
		return messageMapper.selectMessageList(messageMap);
	}
	// 받은 메시지 리스트 조회
	public List<Message> getRecieveMessageList(String toId ){
		log.debug(TeamColor.LHN + " 수신 메시지 리스트 조회" + TeamColor.TEXT_RESET);
		//디버깅
		log.debug(TeamColor.LHN + "toId: " + toId + TeamColor.TEXT_RESET);
		
		return messageMapper.selectReceiveMessageList(toId);
	}
	
	//보낸 메시지 리스트 조회
	public List<Message> getSentMessageList(String fromId ){
		log.debug(TeamColor.LHN + "리스트 조회" + TeamColor.TEXT_RESET);
		//디버깅
		log.debug(TeamColor.LHN + "fromId: " + fromId + TeamColor.TEXT_RESET);
		
		return messageMapper.selectSentMessageList(fromId);
	}
	
	// 안 읽은 메시지 카운팅
	public int showUnreadMessageCnt(String toId) {
		log.debug(TeamColor.LHN + "안 읽은 메시지 카운팅 " +  TeamColor.TEXT_RESET);
		int unreadCnt = messageMapper.selectUnreadMessageCnt(toId);
		// 디버깅
		log.debug(TeamColor.LHN + "안 읽은 메시지: " + unreadCnt + TeamColor.TEXT_RESET);
		return unreadCnt;
	}
	
	// 수/발신 메시지 상세보기
	public Message showMessageOne(int messageNo) {
		log.debug(TeamColor.LHN + "메시지 상세보기" +  TeamColor.TEXT_RESET);
		Message message = null;
		return message;
	}
	
	// 메시지 보내기 
	
	
	// 메시지 삭제
	
	
	// 상대가 보기 전 메시지 발송취소
	
}
