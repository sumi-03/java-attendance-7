package attendance.util;

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
}
