package attendance.util;

import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDateTime;

public class DateChecker {
    public static String getDayOfWeek(int day) {
        int dayOfWeek = day % 7;
        if (dayOfWeek == 0) {
            return "토요일";
        }
        if (dayOfWeek == 1) {
            return "일요일";
        }
        if (dayOfWeek == 2) {
            return "월요일";
        }
        if (dayOfWeek == 3) {
            return "화요일";
        }
        if (dayOfWeek == 4) {
            return "수요일";
        }
        if (dayOfWeek == 5) {
            return "목요일";
        }
        if (dayOfWeek == 6) {
            return "금요일";
        }
        return "";
    }

    public static void checkWeekendOrHoliday(int day) {
        int dayOfWeek = day % 7;
        if (dayOfWeek == 1 || dayOfWeek == 0 || day == 25) {
            throw new IllegalArgumentException("[ERROR] 12월 " + day + "일 " + getDayOfWeek(day) + "은 등교일이 아닙니다.");
        }
    }

    public static String checkOnTime(String attendanceTime) {
        LocalDateTime today = DateTimes.now();
        int dayOfWeek = today.getDayOfMonth() % 7;
        String[] time = attendanceTime.split(":");

        if (dayOfWeek == 2) {
            if ((Integer.parseInt(time[0]) < 13 && (Integer.parseInt(time[1]) >= 0 || Integer.parseInt(time[1]) <= 59)) || (Integer.parseInt(time[0]) == 13 && Integer.parseInt(time[1]) == 0)) {
                return "출석";
            }
            if (Integer.parseInt(time[0]) == 13 && (Integer.parseInt(time[1]) >= 0 || Integer.parseInt(time[1]) <= 5)) {
                return "출석";
            }
            if (Integer.parseInt(time[0]) == 13 && Integer.parseInt(time[1]) > 5) {
                return "지각";
            }
            if (Integer.parseInt(time[0]) > 13) {
                return "지각";
            }
        }

        if (dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 5 || dayOfWeek == 6) {
            if ((Integer.parseInt(time[0]) < 10 && (Integer.parseInt(time[1]) >= 0 || Integer.parseInt(time[1]) <= 59)) || (Integer.parseInt(time[0]) == 13 && Integer.parseInt(time[1]) == 0)) {
                return "출석";
            }
            if (Integer.parseInt(time[0]) == 10 && (Integer.parseInt(time[1]) >= 0 || Integer.parseInt(time[1]) <= 5)) {
                return "출석";
            }
            if (Integer.parseInt(time[0]) == 10 && Integer.parseInt(time[1]) > 5) {
                return "지각";
            }
            if (Integer.parseInt(time[0]) > 10) {
                return "지각";
            }
        }
        return "";
    }
}
