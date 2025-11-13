package com.scheduleappdevelop.contoller;

import com.scheduleappdevelop.dto.*;
import com.scheduleappdevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedules")
public class ScheduleContoller {
    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping
    public CreateScheduleResponse createSchedule(@RequestBody CreateScheduleRequest contentsSchedule) {
        return scheduleService.createSchedule(contentsSchedule);
    }

    //일정 전체 조회
    @GetMapping
    public List<AllScheduleResponse> getAllSchedules() {
        return scheduleService.allSchedule();
    }

    //일전 단건 조회
    @GetMapping("/{id}")
    public List<SingleScheduleResponse> getSingleSchedules(@PathVariable Long id) { //입력한 PK 값을 불러온다.
        return scheduleService.singleSchedule(id);
    }

    //일정 수정
    @PatchMapping("/{id}")
    public UpdateScheduleResponse updateSchedule(@PathVariable Long id,
                                                 @RequestBody UpdateScheduleRequest updateSchedule) { //제이슨 형태의 내용을 불러온다.
        return scheduleService.UpdateSchedule(id,updateSchedule);
    }

    //일정 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return ResponseEntity.ok("선택하신 일정이 삭제 완료되었습니다.");
    }

}
