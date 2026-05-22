package com.study.java.chapter;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Instant, LocalDateTime, ZonedDateTime, ZoneId, ZoneOffset, OffsetDateTime, TemporalAdjusters
 */
public class Ch28Time {
    // Instant - java.util.Date를 대체하고 (Timezone 없음) timestamp(시간 기록)를 제공 - 로컬
    // 에포크 타임(1970-01-01 00:00:00 UTC) 부터 나노초 단위로 표현
    class TestInstant {
        Instant now = Instant.now();
        Instant now2 = Instant.ofEpochSecond(now.getEpochSecond());
        Instant now3 = Instant.ofEpochSecond(now.getEpochSecond(), now.getNano());

        Date date = Date.from(now); // Instant -> Date
        Instant instant = date.toInstant(); // Date -> Instant
    }

    class TestDate {
        LocalDate date = LocalDate.of(2024, 12, 31);
        LocalTime time = LocalTime.of(12, 34, 56);
        LocalDateTime dateTime = LocalDateTime.of(2024, 12, 31, 12, 34, 56);

        // LocalDate와 Time을 이용해서 LocalDateTime 만들기 date + time = dateTime
        void toLocalDateTime() {
            LocalDateTime dt = LocalDateTime.of(date, time);
            LocalDateTime dt2 = date.atTime(time);
            LocalDateTime dt2_1 = date.atTime(12, 34, 56);
            LocalDateTime dt2_2 = date.atTime(LocalTime.now().getHour(), LocalTime.now().getMinute()); // 그냥 get으로 구해도됨.
            LocalDateTime dt3 = date.atStartOfDay(); // dt3 = date.atTime(0,0,0);
            LocalDateTime dt4 = time.atDate(date); // 여러 방법 존재
        }

        // LocalDateTime을 이용해서 LocalTime, LocalDate 만들기
        void toTimeOrDate () {
            LocalDate ld = dateTime.toLocalDate();
            LocalTime lt = dateTime.toLocalTime();
        }

        // LocalDateTime -> ZonedDateTime (Calendar와 유사 date, time, zone)
        void toZone() {
            ZoneId zone = ZoneId.of("Asia/Seoul");
            ZonedDateTime zdt = dateTime.atZone(zone); // LocalDateTime + ZoneId
            String zoneAvailable = ZoneId.getAvailableZoneIds().toString(); // 사용 가능한 zone 확인

            // ZoneDateTime을 다른 형식으로 변환
            LocalTime lt = zdt.toLocalTime();
            LocalDate ld = zdt.toLocalDate();
            LocalDateTime ldt = zdt.toLocalDateTime();
            OffsetDateTime odt = zdt.toOffsetDateTime();
            Instant instant = zdt.toInstant();
            Long es = zdt.toEpochSecond();

            // GregorianCalendar
            GregorianCalendar gc = GregorianCalendar.from(zdt); // ZonedDateTime -> GregorianCalendar
            ZonedDateTime zdt2 = gc.toZonedDateTime(); // GregorianCalendar -> ZonedDateTime
        }

        // ZoneId(서머 타임을 계산함, 시간차 + @(DST 같은 서머타임)) - ZonedDateTime
        // 시간차 ZoneOffset(시간차)과 OffsetDateTime(ZoneOffset + Instant): 글로벌
        // 컴퓨터는 로컬에서 Instant를 쓰기 때문에 유리
        void toOffset() {
            ZoneId zid = ZoneId.of("Asia/Seoul");
            // ZoneOffset krOffset = ZoneOffset.of("+09:00"); // UTC(표준시)로부터 시간대가 얼마나 떨어져 있는지 표현 (kr = +9)
            ZoneOffset krOffset = ZonedDateTime.now().getOffset();
            int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS); // 현재 위치의 ZoneOffset을 얻어서 초단위로

            // ZonedDateTime은 ZoneId로, OffsetDateTime은 ZoneOffset으로 표현
            ZonedDateTime zdt = ZonedDateTime.of(date, time, zid);
            OffsetDateTime odt = OffsetDateTime.of(date, time, krOffset);

            OffsetDateTime odt2 = zdt.toOffsetDateTime();  // ZoneDateTime -> OffsetDateTime
            ZonedDateTime zdt2 = odt.toZonedDateTime(); // OffsetDateTime -> ZoneDateTime
        }

        // TemporalAdjusters: 복잡한 날짜 계산을 도와주는 클래스
        void toCal() {
            LocalDate today = LocalDate.now();
            LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // 다음 월요일
            LocalDate previousMonday = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)); // 이전 월요일
        }
    }
}
