package com.scheduleappdevelop.service;

import com.scheduleappdevelop.dto.*;
import com.scheduleappdevelop.entity.Schedule;
import com.scheduleappdevelop.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //초기화 되지 않은 final 필드나, @NonNull이 붙은 필드에 대해 생성자를 생성해준다.
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional // 메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    //일정 생성
    public CreateScheduleResponse createSchedules(CreateScheduleRequest request) {

        //DTO -> Entity 변환
        Schedule schedule = new Schedule(
                request.getToDoTitle(),
                request.getToDoContent(),
                request.getCreatedUserName()
        );

        //DB 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        //DB -> Response에 담기
        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getToDoTitle(),
                savedSchedule.getToDoContent(),
                savedSchedule.getCreatedUserName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    //일정 전체 조회
    @Transactional // 메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    public List<AllScheduleResponse> allSchedules() {
        return scheduleRepository.findAll() //데이터베이스를 전부 찾는다.
                .stream() //찾은 데이터를 하나씩 스프링으로 가져와라

                //schedule 에 있는 데이터들을 AllScheduleResponse에 담아라
                .map(schedule -> new AllScheduleResponse(
                        schedule.getId(), //
                        schedule.getToDoTitle(),
                        schedule.getToDoContent(),
                        schedule.getCreatedUserName(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ))
                .toList(); //다시 리스트 형태로 만들어라
    }

    //일정 단건 조회
    @Transactional //메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    public List<SingleScheduleResponse> singleSchedules(Long id) {
        return scheduleRepository.findById(id) //데이터베이스를 전부 찾는다.
                .stream() //찾은 데이터를 하나씩 스프링으로 가져와라

                //schedule 에 있는 데이터들을 sngleScheduleResponse 담아라
                .map(schedules -> new SingleScheduleResponse(
                        schedules.getId(), //
                        schedules.getToDoTitle(),
                        schedules.getToDoContent(),
                        schedules.getCreatedUserName(),
                        schedules.getCreatedAt(),
                        schedules.getModifiedAt()
                ))
                .toList(); //다시 리스트 형태로 만들어라
    }

    //일정 수정
    @Transactional // 메서드매의 모든 로직을 하나라도 실패면 전체 실패로 간주
    public UpdateScheduleResponse UpdateSchedule(Long id, UpdateScheduleRequest updateSchedule) {

        //수정해야할 조회 아이디가 아예 없으면??
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));

        if (updateSchedule.getToDoTitle() != null) {
            schedule.setToDoTitle(updateSchedule.getToDoTitle());
        }
        if (updateSchedule.getToDoContent() != null) {
            schedule.setToDoContent(updateSchedule.getToDoContent());
        }
        if (updateSchedule.getCreatedUserName() != null) {
            schedule.setCreatedUserName(updateSchedule.getCreatedUserName());
        }

        //DB저장
        Schedule savedUpdateSchedules = scheduleRepository.save(schedule);

        //DB에서 리스폰스로 전달
        return new UpdateScheduleResponse(
                savedUpdateSchedules.getId(),
                savedUpdateSchedules.getToDoTitle(),
                savedUpdateSchedules.getToDoContent(),
                savedUpdateSchedules.getCreatedUserName(),
                savedUpdateSchedules.getCreatedAt(),
                savedUpdateSchedules.getModifiedAt()
        );
    }

    //삭제
    public void delete(Long id) {
        scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("삭제할 ID가 없습니다."));

        scheduleRepository.deleteById(id);
    }

}

