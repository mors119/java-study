package com.study.java.chapter;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Date, Calendar, time(권장),
 * 다양한 Format
 */
public class Ch26DateCalendar {
    // java.util.Date: 거의 사용하지 않음
    // java.util.Calendar: Date 클래스 개선
    // java.time 패키지(권장): Date 와 Calendar 의 단점을 개선

    // 날짜 -> 일 단위로 변환 후 계산 -> 날짜
    // 시간 -> 초 단위로 변환 후 계산 -> 날짜

    // java.util.Calendar (가변 객체)
    class TestCalendar {
        void test() {
            // Calendar는 날짜와 시간을 항상 같이 가지고 다닌다.
            Calendar today = Calendar.getInstance(); // 현재 날짜
            int thisYear = today.get(Calendar.YEAR); // 연도
            int lastDay = today.getActualMaximum(Calendar.DATE); // 해당 월의 마지막 날짜

            // Calendar -> Date
            Date d = new Date(today.getTimeInMillis());
            // Date -> Calendar
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
        }
        void setMethod() {
            Calendar date1 = Calendar.getInstance();
            // get
            date1.get(Calendar.YEAR); // 연도
            date1.get(Calendar.MONTH); // 월
            date1.get(Calendar.DATE); // 일
            date1.get(Calendar.HOUR); // 시

            // set
            date1.set(Calendar.YEAR, 2000); // (field, value)
            date1.set(2025, 6, 15); // Calendar month는 0부터 시작하므로 주의
            date1.set(2025, Calendar.AUGUST, 15); // (year, month, date, hour, minute, second, millisecond)

            // print
            System.out.println(date1.get(Calendar.YEAR));
            System.out.println(new Date(date1.getTimeInMillis())); // 2025-08-15 00:00:00.0

            // 필드 초기화
            date1.clear(); // 모든 필드 초기화
        }
    }

    // 여러 가지 Format
    class TestFormat {
        // DecimalFormat
        void decimalFormat() {
            double num = 123456.89;
            DecimalFormat df = new DecimalFormat("#.#E0");
            // # = 10진수, . = 소수점, - = 음수 부호, , = 단위 구분, 0.0 = 10진수 소수점 이하 1자리(값이 없을 때 0), E = 지수
            String rs = df.format(num);
            System.out.println(rs); // 1.2345689E5

            DecimalFormat dfo = new DecimalFormat("#,###.##");
            try {
                // 숫자의 타입을 확정할 수 없으므로 조상 클래스 Number 클래스를 사용
                Number number = dfo.parse("1,123,123.49");

                double d = number.doubleValue(); // double 타입으로
                System.out.println(d); // 1123123.49
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        // SimpleDateFormat
        void simpleDate () {
            Calendar cal = Calendar.getInstance();
            Date day = cal.getTime();

            // 원하는 포맷을 지정해주면 맞춰 출력
            SimpleDateFormat df1, df2, df3, df4, df5, df6;
            df1 = new SimpleDateFormat("yyyy-MM-dd"); // 2026-05-21
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2026-05-21 21:13:45
            df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm::ss:SSS"); // 2026-05-21 21:13::56:021
            df4 = new SimpleDateFormat("yy-MM-dd E"); // 26-05-21 Thu
            df5 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss"); // 2026-05-21 PM 09:16:05

            System.out.println(df5.format(day)); // 출력

            df6 = new SimpleDateFormat("yyyy년 MM월 dd일");
            try {
                Date date = df6.parse("2026년 05월 21일"); // 포멧을 이용해서 데이터에서 날짜 뽑기
                System.out.println(date); // 2026-05-21 00:00:00.0
                System.out.println(df6.format(date)); // 2026년 05월 21일
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        // ChoiceFormat
        void choice () {
            int[] score = {100, 92, 90, 84, 63, 71, 60};

            // limits와 format을 지정
            double[] limit = {60, 70, 80, 90};
            String[] grades = {"D", "C", "B", "A"};
            ChoiceFormat form = new ChoiceFormat(limit, grades);

            // pattern을 지정
            String pattern = "60#D|70#C|80#B|90#A";
            ChoiceFormat form2 = new ChoiceFormat(pattern);

            for (int i = 0; i < score.length; i++) {
                System.out.println(i + " = " + form.format(score[i])); // ChoiceFormat 적용하여 출력
                System.out.println(i + " = " + form2.format(score[i])); // ChoiceFormat 적용하여 출력
            }
        }
        // MessageFormat: 정해진 형식의 문자열에 데이터를 채우거나 뽑아내기
        void messgae () {
            String table = "INFO"; // 테이블
            String pattern = "INSERT INTO " + table + " VALUES (''{0}'', ''{1}'', {2}, {3})";

            String[][] args = {
                    {"Kim", "010-123-1234", "28", "10-19"},
                    {"Lee", "010-123-1234", "28", "10-19"}
            };

            // 데이터 추출
            Object[] data;
            MessageFormat mf = new MessageFormat(pattern);

            for (String[] arg : args) {
                // 데이터 넣기
                String rs = MessageFormat.format(pattern, arg);
                System.out.println(rs);

                // 데이터 뽑기
                try {
                    data = mf.parse(rs);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                for (Object d : data) {
                    System.out.println(d);
                }

            }
        }
    }

    public static void main(String[] args) {
    }

}
