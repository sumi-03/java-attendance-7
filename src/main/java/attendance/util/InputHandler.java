package attendance.util;

import attendance.domain.AttendanceManager;
import attendance.view.InputView;
import camp.nextstep.edu.missionutils.DateTimes;

public class InputHandler {
    private InputHandler() {
    }

    public static int getFunctionNumber() {
        String input = InputView.readLine();
        InputValidator.validateFunctionNumber(input);
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
            return Integer.parseInt(input);
        } else if (input.equals("Q")) {
            return 0;
        }
        return 0;
    }

    public static String checkAttendance(AttendanceManager attendanceManager) {
        String nickname = InputView.readLineWithInfo("닉네임을 입력해 주세요.");
        InputValidator.validateNickname(attendanceManager.containsNickname(nickname));

        String attendanceTime = InputView.readLineWithInfo("등교 시간을 입력해 주세요.");
        InputValidator.validateAttendanceTime(attendanceTime);

        attendanceManager.addAttendance(nickname, "2024-12-" + DateTimes.now().getDayOfWeek() + " " + attendanceTime);
        return " " + attendanceTime + " (" + DateChecker.checkOnTime(DateTimes.now().getDayOfMonth(), attendanceTime) + ")";
    }

    public static String modifyAttendance(AttendanceManager attendanceManager) {
        String nickname = InputView.readLineWithInfo("출석을 수정하려는 크루의 닉네임을 입력해 주세요.");
        InputValidator.validateNickname(attendanceManager.containsNickname(nickname));

        String modifyDay = InputView.readLineWithInfo("수정하려는 날짜(일)를 입력해 주세요.");
        InputValidator.validateModifyDay(modifyDay);

        String modifyTime = InputView.readLineWithInfo("언제로 변경하겠습니까?");
        InputValidator.validateAttendanceTime(modifyTime);

        String oldTime = attendanceManager.modifyAttendance(nickname, modifyDay, modifyTime);

        return modifyDay + "일 " + DateChecker.getDayOfWeek(Integer.parseInt(modifyDay)) + " " + oldTime + " (" + DateChecker.checkOnTime(Integer.parseInt(modifyDay), oldTime) + ") -> " + modifyTime + " (" + DateChecker.checkOnTime(Integer.parseInt(modifyDay), modifyTime) + ")";
    }
}
