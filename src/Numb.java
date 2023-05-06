public class Numb {

    public static int switchValue(String string) throws Exception {
        int result = 0;
        switch (string) {
            case "I":
                result = 1;
                break;
            case "II":
                result = 2;
                break;
            case "III":
                result = 3;
                break;
            case "IV":
                result = 4;
                break;
            case "V":
                result = 5;
                break;
            case "VI":
                result = 6;
                break;
            case "VII":
                result = 7;
                break;
            case "VIII":
                result = 8;
                break;
            case "IX":
                result = 9;
                break;
            case "X":
                result = 10;
                break;
            default:
                throw new Exception("throws Exception //т.к. числа должны быть от 1 до 10");
        }
        return result;
    }

    public static String backSwitchValue(int number) {

        String result = "";
        int one;
        int two;
        String oneStr = "";
        String twoStr = "";

        if (number < 10) {
            result = switchNumb(number);
        } else {
            one = number % 10;
            two = number / 10;
            oneStr = switchNumb(one);
            twoStr= switchNumbNext(two);
            result = twoStr + oneStr;
        }


        return result;
    }

    public static String switchNumb(int number) {
        String result = "";

        switch (number) {
            case 1:
                result = "I";
                break;
            case 2:
                result = "II";
                break;
            case 3:
                result = "III";
                break;
            case 4:
                result = "IV";
                break;
            case 5:
                result = "V";
                break;
            case 6:
                result = "VI";
                break;
            case 7:
                result = "VII";
                break;
            case 8:
                result = "VIII";
                break;
            case 9:
                result = "IX";
                break;
        }

        return result;
    }
    public static String switchNumbNext(int number) {
        String result = "";

        switch (number) {
            case 1:
                result = "X";
                break;
            case 2:
                result = "XX";
                break;
            case 3:
                result = "XXX";
                break;
            case 4:
                result = "XL";
                break;
            case 5:
                result = "L";
                break;
            case 6:
                result = "LX";
                break;
            case 7:
                result = "LXX";
                break;
            case 8:
                result = "LXXX";
                break;
            case 9:
                result = "XC";
                break;
        }

        return result;
    }
}


