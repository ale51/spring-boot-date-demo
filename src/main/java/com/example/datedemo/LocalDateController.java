package com.example.datedemo;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class LocalDateController {

    @GetMapping
    public void get(@RequestParam(name = "date") @DateTimeFormat LocalDate localDate){
        System.out.println(localDate);
    }

    @GetMapping("format")
    public void get2(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate localDate){
        System.out.println(localDate);
    }

    @GetMapping("multi")
    public void get3(
            @ModelAttribute MultiForm multiForm
    ){
        System.out.println(multiForm.getEndAt());
        System.out.println(multiForm.getStartAt());
    }

    @GetMapping("multi/format")
    public void get4(
            @ModelAttribute MultiFormatForm multiFormatForm
    ){
        System.out.println(multiFormatForm.getEndAt());
        System.out.println(multiFormatForm.getStartAt());
    }

    @PostMapping
    public void post(
            @RequestBody MultiForm multiForm
    ){
        System.out.println(multiForm.getStartAt());
        System.out.println(multiForm.getEndAt());
    }

    @PostMapping("format")
    public void post2(
            @RequestBody MultiFormatForm multiFormatForm
    ){
        System.out.println(multiFormatForm.getStartAt());
        System.out.println(multiFormatForm.getStartAt());
    }

    @Getter
    static class MultiForm {
        @DateTimeFormat
        private LocalDate startAt;

        @DateTimeFormat
        private LocalDate endAt;
    }

    @Getter
    static class MultiFormatForm {
        @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
        private LocalDate startAt;

        @DateTimeFormat(pattern = "yyyyMMdd HH:mm:ss")
        private LocalDate endAt;
    }
}
