public class PasswordChecker {

    public static boolean checkPassword(String pass) {
        // min 6 chars, max 12 chars
        if (pass.length() < 6 || pass.length() > 12)
            return false;

        // No white space
        if (pass.contains(" "))
            return false;

        // At least 1 upper case letter
        boolean hasUpperCase = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                hasUpperCase = true;
                break;
            }
        }
        if (!hasUpperCase)
            return false;

        // At least 1 lower case letter
        boolean hasLowerCase = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLowerCase(pass.charAt(i))) {
                hasLowerCase = true;
                break;
            }
        }
        if (!hasLowerCase)
            return false;

        // No two similar chars consecutively
        for (int i = 0; i < pass.length() - 1; i++) {
            if (pass.charAt(i) == pass.charAt(i + 1))
                return false;
        }

        // At least 1 special char
        String specialCharacters = "!%@$^&*()?/>.<,:;'\\|}]{[_~`+=-\"";
        boolean hasSpecialChar = false;
        for (int i = 0; i < pass.length(); i++) {
            if (specialCharacters.contains(Character.toString(pass.charAt(i)))) {
                hasSpecialChar = true;
                break;
            }
        }
        if (!hasSpecialChar)
            return false;

        return true;
    }

    public static void main(String[] args) {
        String password1 = "ValidPassword123!";
        String password2 = "Invalid1";
        
        System.out.println("Password 1 is valid: " + checkPassword(password1));
        System.out.println("Password 2 is valid: " + checkPassword(password2));
    }
}
