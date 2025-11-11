package com.scheduleappdevelop.service;

import com.scheduleappdevelop.dto.CreateScheduleRequest;
import com.scheduleappdevelop.dto.CreateScheduleResponse;
import com.scheduleappdevelop.entity.Schedule;
import com.scheduleappdevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public CreateScheduleResponse createSchedules(CreateScheduleRequest request) {

        //DTO -> Entity 변환
        Schedule schedule = new Schedule(
                request.getCreatedUserName(),
                request.getToDoTitle(),
                request.getToDoContent()
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
}
