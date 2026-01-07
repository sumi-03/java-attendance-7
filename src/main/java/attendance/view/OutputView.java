package attendance.view;

import attendance.util.DateParser;
import camp.nextstep.edu.missionutils.DateTimes;

public class OutputView {
    public static void functionInfo() {
        System.out.println("오늘은 " + DateTimes.now().getMonthValue() + "월 " + DateTimes.now().getDayOfMonth() + "일 " + DateParser.getDayOfWeek(DateTimes.now().getDayOfMonth()) + "입니다. 기능을 선택해 주세요.");
        System.out.println("1. 출석 확인");
        System.out.println("2. 출석 수정");
        System.out.println("3. 크루별 출석 기록 확인");
        System.out.println("4. 제적 위험자 확인");
        System.out.println("Q. 종료");
    }
}
