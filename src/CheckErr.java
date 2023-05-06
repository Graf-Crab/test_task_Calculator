public class CheckErr {
    public static void checkOperation(String string) throws Exception {
        String[] array = {"+", "-", "/", "*"};

        boolean exit = false;
        for (String element : array) {
            if (element.equals(string)) {
                exit = true;
                break;
            }
        }

        if (!exit) {
            throw new Exception();
        }
    }

    public static int checkValues(String str1, String str2) throws Exception {
        boolean canConvert1, canConvert2;
        try {
            Integer.parseInt(str1);
            canConvert1 = true;
        } catch (NumberFormatException e) {
            canConvert1 = false;
        }
        try {
            Integer.parseInt(str2);
            canConvert2 = true;
        } catch (NumberFormatException e) {
            canConvert2 = false;
        }
        if (canConvert1 && canConvert2) {
            return 1;
        } else if (!canConvert1 && !canConvert2) {
            return 2;
        } else {
            throw new Exception("One of the values cannot be converted to int");
        }
    }

    public static int[] checkValueNumber(int int1, int int2) throws Exception {
        int[] result1 = {int1, int2};
        if (int1 < 0 || int1 > 10 || int2 < 0 || int2 > 10) {
            throw new Exception();
        }
        return result1;
    }
}