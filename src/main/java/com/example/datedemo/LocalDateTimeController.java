package com.example.datedemo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("localdatetime")
public class LocalDateTimeController {

    @GetMapping
    public void get(@RequestParam(name = "datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime){
        System.out.println(localDateTime);
    }

    @GetMapping("format")
    public void get2(@RequestParam(name = "datetime") @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") LocalDateTime localDateTime){
        System.out.println(localDateTime);
    }

    @GetMapping("multi")
    public void get3(
            @ModelAttribute MultiForm multiForm
    ){
        System.out.println(multiForm.getStartAt());
        System.out.println(multiForm.getEndAt());
    }

    @GetMapping("multi/format")
    public void get4(
            @ModelAttribute MultiFormatForm multiFormatForm
    ){
        System.out.println(multiFormatForm.getStartAt());
        System.out.println(multiFormatForm.getEndAt());
    }

    @PostMapping
    public void post(
            @RequestBody MultiForm multiForm
    ){
        System.out.println(multiForm.getStartAt());
        System.out.println(multiForm.getEndAt());
    }

    // @RequestBodyの場合はformatはできない模様。
    @PostMapping("format")
    public void post2(
            @RequestBody MultiFormatForm multiFormatForm
    ){
        System.out.println(multiFormatForm.getStartAt());
        System.out.println(multiFormatForm.getEndAt());
    }

    @Data
    static class MultiForm {
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime startAt;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime endAt;
    }

    @Data
    static class MultiFormatForm {
        @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
        private LocalDateTime startAt;

        @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
        private LocalDateTime endAt;
    }
}
