package attendance.util;

import attendance.domain.AttendanceManager;
import attendance.view.InputView;

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

        attendanceManager.addAttendance(nickname, attendanceTime);
        return " " + attendanceTime + " (" + DateChecker.checkOnTime(attendanceTime) + ")";
    }
}
