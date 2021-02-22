package day15.api.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatting {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        
        //날짜 형식을 바꿀때는 DateTimeFormatter를 사용
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");

        String format = now.format(f);
        System.out.println("형식변환 날짜: " + format);
    }
}
