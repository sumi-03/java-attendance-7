package attendance.util;

public class DateParser {
    public static String getDayOfWeek(int day) {
        int dayOfWeek = day % 7;
        if (dayOfWeek == 0) {
            return "일요일";
        }
        if (dayOfWeek == 1) {
            return "월요일";
        }
        if (dayOfWeek == 2) {
            return "화요일";
        }
        if (dayOfWeek == 3) {
            return "수요일";
        }
        if (dayOfWeek == 4) {
            return "목요일";
        }
        if (dayOfWeek == 5) {
            return "금요일";
        }
        if (dayOfWeek == 6) {
            return "토요일";
        }
        return "";
    }
}
