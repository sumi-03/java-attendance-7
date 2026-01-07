package attendance.util;

import camp.nextstep.edu.missionutils.DateTimes;

public class InputValidator {
    public static void validateFunctionNumber(String input) {
        if (!isNumeric(input)) {
            if (!input.equals("Q")) {
                throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
            }
        }
    }

    private static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

    public static void validateNickname(boolean isContain) {
        if (!isContain) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 닉네임입니다.");
        }
    }

    public static void validateAttendanceTime(String attendanceTime) {
        String[] time = attendanceTime.split(":");
        if (time.length != 2) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
        if (!isNumeric(time[0]) || !isNumeric(time[1])) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
        if (Integer.parseInt(time[0]) > 23 || Integer.parseInt(time[0]) < 0 || Integer.parseInt(time[1]) < 0 || Integer.parseInt(time[1]) > 59) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
    }

    public static void validateModifyDay(String modifyDay) {
        if (!isNumeric(modifyDay)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
        if (DateTimes.now().getDayOfMonth() > Integer.parseInt(modifyDay)) {
            throw new IllegalArgumentException("[ERROR] 아직 수정할 수 없습니다.");
        }
        DateChecker.checkWeekendOrHoliday(Integer.parseInt(modifyDay));
    }
}
