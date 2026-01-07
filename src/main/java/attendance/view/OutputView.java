package attendance.view;

import attendance.util.DateChecker;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDateTime;

public class OutputView {
    public static LocalDateTime today = DateTimes.now();

    public static void printFunctionInfo() {
        System.out.println("오늘은 " + today.getMonthValue() + "월 " + today.getDayOfMonth() + "일 " + DateChecker.getDayOfWeek(today.getDayOfMonth()) + "입니다. 기능을 선택해 주세요.");
        System.out.println("1. 출석 확인");
        System.out.println("2. 출석 수정");
        System.out.println("3. 크루별 출석 기록 확인");
        System.out.println("4. 제적 위험자 확인");
        System.out.println("Q. 종료");
    }

    public static void printAttendance(String status) {
        System.out.println(today.getMonthValue() + "월 " + today.getDayOfMonth() + "일 " + DateChecker.getDayOfWeek(today.getDayOfMonth()) + status);
    }
}
