package attendance.controller;

import attendance.util.CSVReader;
import attendance.util.InputHandler;
import attendance.view.OutputView;

import java.util.List;

public class AttendanceController {

    public void run() {
        List<List<String>> crewAttendance = CSVReader.readCSV();
        while (true) {
            OutputView.functionInfo();
            int function = InputHandler.getFunctionNumber();
            if (function == 0) {
                break;
            } else if (function == 1) {
                // 출석 확인
            } else if (function == 2) {
                // 출석 수정
            } else if (function == 3) {
                // 크루별 출석 기록 확인
            } else if (function == 4) {
                // 제적 위험자 확인
            }
        }
    }
}
