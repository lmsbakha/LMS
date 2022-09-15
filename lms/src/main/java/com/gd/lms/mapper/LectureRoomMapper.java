package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.LectureRoom;

@Mapper
public interface LectureRoomMapper {
	// 강의실 추가
	// 파라미터 : LectureRoom
	// 리턴값 : 정상적으로 쿼리가 작동했는지 확인할 int
	int insertLectureRoom(LectureRoom paramLectureRoom);

	// 강의실 리스트
	// 파라미터 : X
	// 리턴값 : LectureRoom 정보를 담은 List
	List<LectureRoom> selectLectureRoomList();

	// 강의실 정보를 수정하는 메소드
	// 파라미터 : LectureRoom
	// 리턴값: : LectureRoom
	LectureRoom updateLectureRoom(LectureRoom paramLectureRoom);

	// 강의실 삭제
	// 파라미터 : LecutrRoomName (PK)
	// 리턴값 : 정상적으로 삭제가 작동되었는지 확인할 int
	int deleteLectureRoom(String lectureRoomName);
}
