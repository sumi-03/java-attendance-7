package attendance.controller;

import attendance.domain.AttendanceManager;
import attendance.util.CSVReader;
import attendance.util.DateChecker;
import attendance.util.InputHandler;
import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDateTime;


public class AttendanceController {

    public void run() {
        AttendanceManager attendanceManager = new AttendanceManager(CSVReader.readCSV());
        LocalDateTime today = DateTimes.now();
        while (true) {
            OutputView.printFunctionInfo();
            int function = InputHandler.getFunctionNumber();
            if (function == 0) {
                break;
            } else if (function == 1) {
                DateChecker.checkWeekendOrHoliday(today.getDayOfMonth());
                String contents = InputHandler.checkAttendance(attendanceManager);
                OutputView.printAttendance(contents);
            } else if (function == 2) {
                String contents = InputHandler.modifyAttendance(attendanceManager);
                OutputView.printModifidAttendance(contents);
            } else if (function == 3) {
                // 크루별 출석 기록 확인
            } else if (function == 4) {
                // 제적 위험자 확인
            }
        }
    }
}
