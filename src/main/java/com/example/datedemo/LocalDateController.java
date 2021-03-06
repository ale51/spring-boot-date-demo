package com.example.datedemo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("localdate")
public class LocalDateController {

    @GetMapping
    public void get(@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate){
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
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate startAt;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate endAt;
    }

    @Data
    static class MultiFormatForm {
        @DateTimeFormat(pattern = "yyyy/MM/dd")
        private LocalDate startAt;

        @DateTimeFormat(pattern = "yyyy/MM/dd")
        private LocalDate endAt;
    }
}
