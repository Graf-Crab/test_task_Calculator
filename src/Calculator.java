import  java.util.Scanner;

public class Calculator {
    public static String calc(String input) throws Exception {
        CheckErr work = new CheckErr();

        String[] strings = input.split(" ");

        if (strings.length == 1) {
            throw new Exception("//т.к. строка не €вл€етс€ математической операцией");
        }

        // ѕроверка, что пользователь ввел ровно 3 элемента
        if (strings.length != 3) {
            throw new Exception();
        }

        //»з строки пользовател€ берем оператор

        String operation = strings[1];

        //ѕроверка, что указан корректный оператор
        try {
            work.checkOperation(operation);
        } catch (Exception e) {
            throw new Exception("throws Exception //т.к. не соответствует ни одной из вышеописанных арифметических операций");
        }

        //«начени€ пользовател€
        String numOne = strings[0];
        String numTwo = strings[2];

        try {
            work.checkValues(numOne,numTwo);
        } catch (Exception e) {
            throw new Exception("throws Exception //т.к. используютс€ одновременно разные системы счислени€");
        }

        //resultCheck получает значение метода checkValues
        // 1 - если оба значени€ int
        //2 - если оба значени€ String

        int resultCheck = work.checkValues(numOne,numTwo);

        Numb numb = new Numb();

        int a = 0;
        int b = 0;
        int c = 0;
        String finalResult = "";

        switch (resultCheck){
            case 1:
                a = Integer.parseInt(numOne);
                b = Integer.parseInt(numTwo);
                //проверка, что значени€ от 1 до 10
                try {
                    int[] numbers1 = work.checkValueNumber(a,b);
                    c = operation(operation, numbers1[0], numbers1[1]);
                    finalResult = Integer.toString(c);
                } catch (Exception e) {
                    throw new Exception("throws Exception //т.к. числа должны быть от 1 до 10");
                }  break;

            case 2:
                a = numb.switchValue(numOne);
                b = numb.switchValue(numTwo);
                //если оба числа равны 10 и будет умножение
                if (a == 10 && b == 10 && operation.equals("*")){
                    finalResult = "C";
                    break;
                }
                c = operation(operation,a,b);

                //ѕроверка, что результат больше 1.
                if (c < 1){
                    throw new Exception("throws Exception //т.к. если результат работы меньше единицы, выбрасываетс€ исключение");
                }

                finalResult = numb.backSwitchValue(c);
                break;
        }
        return finalResult;
    }

    public static void main(String[] args) throws Exception {

        //ѕолучаем строку от пользовател€
        Scanner console = new Scanner(System.in);
        System.out.println("¬ведите значение");
        String userData = console.nextLine();

        System.out.println(calc(userData));
    }
    private static int operation(String operation, int num1, int num2) {
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
