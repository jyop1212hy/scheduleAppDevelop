package com.scheduleappdevelop.contoller;

import com.scheduleappdevelop.dto.CreateScheduleRequest;
import com.scheduleappdevelop.dto.CreateScheduleResponse;
import com.scheduleappdevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedules")
public class ScheduleContoller {
    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping
    public CreateScheduleResponse createSchedule(@RequestBody CreateScheduleRequest contentsSchedule) {
        return scheduleService.createSchedules(contentsSchedule);
    }

    //일정 조회
    //일정 수정
    //일정 삭제
}
