package attendance.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static String readLineWithInfo(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
