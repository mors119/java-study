package com.study.java.chapter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * LocalTime, LocalDate
 */
public class Ch27Time {
    // java.time: 날짜와 시간을 다루는 핵심 클래스 제공
    // java.time.chrono: ISO 표준이 아닌 달력 시스템을 위한 클래스
    // java.time.format: 날짜와 시간을 파싱하고 형식화
    // java.time.temporal: 날짜와 시간 필드와 단위를 위한 클래스
    // java.time.zone: 시간대 관련

    // java.time (불변 객체)
    class TestTime {
        // LocalDate(날짜) + LocalTime(시간) = LocalDateTime(날짜 & 시간) - 전부 불변
        // LocalDateTime + ZoneId(시간대(time-zone)) = ZonedDateTime(날짜 & 시간 & 시간대)
        // Period는 날짜의 차이(날짜 - 날짜). Duration은 시간의 차이(시간 - 시간).

        // LocalDate, LocalTime ...의 매개변수로 인터페이스 Temporal(), TemporalField(날짜 시간 필드), TemporalUnit(날짜 시간 단위)등이 쓰인다.
        // Period, Duration 의 매개변수로 인터페이스 TemporalAmount()이 쓰인다.

        LocalTime now = LocalTime.now(); // 현재 시간
        // int minute = now.getMinute(); // 아래와 동일한 결과
        int minute = now.get(ChronoField.MINUTE_OF_HOUR); // TemporalField의 구현체인 ChronoField의 상수 사용

        LocalDate today = LocalDate.now(); // 오늘
        // LocalDate tomorrow = today.plusDays(1); // 오늘에 1 더하기
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS); // TemporalUnit의 구현체인 ChronoUnit의 상수 사용

        // now: 현재
        LocalDate d = LocalDate.now();
        LocalTime t = LocalTime.now();

        // of: 특정일 지정
        LocalDate d2 = LocalDate.of(1999, 12, 13); // 1999년 12월 13일
        LocalTime t2 = LocalTime.of(22, 10, 10); // 22시 10분 10초

        // ofYearDay: 일단위 지정, ofSecondDay: 초단위 지정
        LocalDate d3 = LocalDate.ofYearDay(1999, 365); // 1999년 12월 31일
        LocalTime t3 = LocalTime.ofSecondOfDay(86400); // 24시 00분 00초

        // get(TemporalField-(ChronoField)) (값이 큰 경우 Long을 사용!(나노초, 마이크로초))
        int d4 = d3.get(ChronoField.DAY_OF_MONTH);
        long t4 = t3.get(ChronoField.MICRO_OF_DAY); // int를 쓰면 넘어감.
        // 메서드로 가능한 것도 있음.
        int d5 = d3.getYear();
        int t5 = t3.getHour();

        // with: 날짜 시간 변경
        LocalDate d6 = d3.with(ChronoField.DAY_OF_YEAR, 2);

        // 더하기 빼기 minus plus
        LocalDate d7 = d3.minus(1, ChronoUnit.DAYS); // TemporalUnit에는 ChronoUnit
        LocalTime t6 = t3.plus(Period.ofDays(1)); // TemporalAmount에는 Period, Duration

        // 비교: isAfter, isBefore, isEqual
        void compare() {
            boolean a = d3.isAfter(ChronoLocalDate.from(tomorrow));
            boolean b = d3.isBefore(ChronoLocalDate.from(tomorrow));
            boolean c = d3.isEqual(ChronoLocalDate.from(tomorrow));
        }

    }
}
