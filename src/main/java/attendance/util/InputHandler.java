package attendance.util;

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
}
