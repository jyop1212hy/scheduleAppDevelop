package com.scheduleappdevelop.service;

import com.scheduleappdevelop.dto.*;
import com.scheduleappdevelop.entity.Schedule;
import com.scheduleappdevelop.entity.User;
import com.scheduleappdevelop.repository.ScheduleRepository;

import com.scheduleappdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //초기화 되지 않은 final 필드나, @NonNull이 붙은 필드에 대해 생성자를 생성해준다.
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional // 메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    //일정 생성
    public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {

        //게시물 작성자가 등록된 유저인지 확인
        User user = userRepository.findById(request.getUserId()).orElseThrow(()->new IllegalArgumentException("여기가 문제인가?"));

        //DTO -> Entity 변환
        Schedule schedule = new Schedule(
                request.getToDoTitle(),
                request.getToDoContent(),
//                request.getCreatedUserName()
                user
        );

        //DB 저장
        Schedule saved = scheduleRepository.save(schedule);

        //DB -> Response에 담기
        return new CreateScheduleResponse(
                saved.getId(),
                saved.getToDoTitle(),
                saved.getToDoContent(),
//                savedSchedule.getCreatedUserName(),
                saved.getUser().getId(),
                saved.getCreatedAt(),
                saved.getModifiedAt()
        );
    }

    //일정 전체 조회
    @Transactional(readOnly = true) // 메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    public List<AllScheduleResponse> allSchedule() {
        return scheduleRepository.findAll() //데이터베이스를 전부 찾는다.
                .stream() //찾은 데이터를 하나씩 스프링으로 가져와라

                //schedule 에 있는 데이터들을 AllScheduleResponse에 담아라
                .map(schedule -> new AllScheduleResponse(
                        schedule.getId(), //
                        schedule.getToDoTitle(),
                        schedule.getToDoContent(),
//                        schedule.getCreatedUserName(),
                        schedule.getUser().getId(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ))
                .toList(); //다시 리스트 형태로 만들어라
    }

    //일정 단건 조회
    @Transactional(readOnly = true) //메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    public List<SingleScheduleResponse> singleSchedule(Long id) {
        return scheduleRepository.findById(id) //데이터베이스를 전부 찾는다.
                .stream() //찾은 데이터를 하나씩 스프링으로 가져와라

                //schedule 에 있는 데이터들을 sngleScheduleResponse 담아라
                .map(schedules -> new SingleScheduleResponse(
                        schedules.getId(), //
                        schedules.getToDoTitle(),
                        schedules.getToDoContent(),
//                        schedules.getCreatedUserName(),
                        schedules.getUser().getId(),
                        schedules.getCreatedAt(),
                        schedules.getModifiedAt()
                ))
                .toList(); //다시 리스트 형태로 만들어라
    }

    //일정 수정
   @Transactional // 메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    public UpdateScheduleResponse UpdateSchedule(Long id, UpdateScheduleRequest updateScheduleData) {

        //수정해야할 조회 아이디가 아예 없으면??
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));

        if (updateScheduleData.getToDoTitle() != null) {
            schedule.setToDoTitle(updateScheduleData.getToDoTitle());
        }
        if (updateScheduleData.getToDoContent() != null) {
            schedule.setToDoContent(updateScheduleData.getToDoContent());
        }
//        if (updateScheduleData.getCreatedUserName() != null) {
//        schedule.setCreatedUserName(updateScheduleData.getCreatedUserName());
//        }

        //DB저장
        Schedule savedUpdateSchedules = scheduleRepository.save(schedule);

        //DB에서 리스폰스로 전달
        return new UpdateScheduleResponse(
                savedUpdateSchedules.getId(),
                savedUpdateSchedules.getToDoTitle(),
                savedUpdateSchedules.getToDoContent(),
                savedUpdateSchedules.getUser().getId(),
                savedUpdateSchedules.getCreatedAt(),
                savedUpdateSchedules.getModifiedAt()
        );
    }

    //삭제
    @Transactional
    public void delete(Long id) {
        scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("삭제할 ID가 없습니다."));

        scheduleRepository.deleteById(id);
    }

}

