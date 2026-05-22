package com.study.java.chapter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 * Period, Duration
 */
public class Ch29Time {
    // 날짜 - 날짜 = Period
    // 시간 - 시간 = Duration
    class TestPeriodDuration {
        // Period
        LocalDate date1 = LocalDate.of(1996, 12, 11);
        LocalDate date2 = LocalDate.of(1999, 12, 31);
        Period period = Period.between(date1, date2); // 날짜 차
        long year = period.get(ChronoUnit.YEARS); // int getYears()
        long month = period.get(ChronoUnit.MONTHS); // int getMonths()
        long day = period.get(ChronoUnit.DAYS); // int getDays()

        // Duration
        LocalTime time1 = LocalTime.of(1, 0, 0);
        LocalTime time2 = LocalTime.of(2, 0, 0);
        Duration duration = Duration.between(time1, time2); // 시간 차
        long hour = duration.get(ChronoUnit.HOURS); // long toHours()
        long minute = duration.get(ChronoUnit.MINUTES); // long toMinutes()
        long second = duration.get(ChronoUnit.SECONDS); // long getSeconds()
        long millisecond = duration.get(ChronoUnit.MILLIS); // long getMillis()
        long nanosecond = duration.get(ChronoUnit.NANOS); // long getNanos()

        // 본질적으로 차이를 계산하기 위한 것이다.
        Period pe = Period.of(1, 12, 31); // 1년 12개월 31일
        Duration du = Duration.ofDays(365); // 365일
        Duration du2 = Duration.ofHours(24); // 24시간
        Duration du3 = Duration.ofMinutes(60); // 60분
        Duration du4 = Duration.ofSeconds(60); // 60초
        // with: 변경
        void with() {
            pe = pe.withYears(2); // 1년에서 2년으로 변경
            du4 = du4.withSeconds(120); // 60초에서 120초로 변경
        }
        // D-day는 between()보다 until()이 일수만 반환하므로 유리. Period는 년월일을 따로 저장.
        void d_day() {
            LocalDate today = LocalDate.now();
            LocalDate birthday = LocalDate.of(today.getYear(), 12, 25);

            Period period = Period.between(today, birthday); // 년월일이 나오므로
            long dday = today.until(birthday, ChronoUnit.DAYS); // 일수만 반환하는 until이 유리
            long dday2 = ChronoUnit.DAYS.between(today, birthday);

            // 올해 생일이 이미 지났으면 내년으로 변경
            if (birthday.isBefore(today)) {
                birthday = birthday.plusYears(1);
            }
        }

        void TestCalculation () {
            // 연산
            pe = pe.minusDays(1).multipliedBy(3); // (일 - 1) * 3
            du = du.plusHours(1).dividedBy(2); // (시간 + 1) / 2

            // 시간 순서
            boolean sameDate = Period.between(date1, date2).isZero(); // 같으면 0이므로 참
            boolean isBefore = Duration.between(time1, time2).isNegative(); // time1이 작으면 참
            boolean isAfter = Duration.between(time1, time2).isPositive(); // time1이 크면 참

            // 출력
            System.out.println(pe.toTotalMonths()); // 월단위로 변환해서 반환 (일은 무시)
            System.out.println(du.toHours()); // 시간단위로 변환해서 반환
        }

        // DateTimeFormat
        void TestTimeFormat() {
            // DateTimeFormatter에 미리 정해둔 형식이 잇으므로 찾아줄 수 잇음
            String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date1); // 1996-12-11
            String yyyymmdd2 = date2.format(DateTimeFormatter.ISO_LOCAL_DATE); // 1999-12-31

            // ofLocalizedDate: locale에 종속된 형식화
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL); // Full은 0000년 00월 00일 0요일
            String full = formatter.format(LocalDate.now());

            // 사용자 정의 패턴
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String pattern = formatter2.format(LocalDate.now());

            // 날짜와 시간 파싱하기
            LocalDate newDate = LocalDate.parse("2001-01-01", formatter2); // 형식이 같아야 날짜를 가져올 수 있음.
            // 잘 알려진 형식은 생략 가능 (그래도 써주는 게 정확!!)
            LocalDate newDate2 = LocalDate.parse("2001-01-01");
            LocalTime newTime = LocalTime.parse("23:11:11");
            LocalDateTime newDateTime = LocalDateTime.parse("2001-01-01T23:11:11");
        }
    }
}
