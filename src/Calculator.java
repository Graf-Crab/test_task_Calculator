import  java.util.Scanner;

public class Calculator {
    public static String calc(String input) throws Exception {
        CheckErr work = new CheckErr();

        String[] strings = input.split(" ");

        if (strings.length == 1) {
            throw new Exception("//�.�. ������ �� �������� �������������� ���������");
        }

        // ��������, ��� ������������ ���� ����� 3 ��������
        if (strings.length != 3) {
            throw new Exception();
        }

        //�� ������ ������������ ����� ��������

        String operation = strings[1];

        //��������, ��� ������ ���������� ��������
        try {
            work.checkOperation(operation);
        } catch (Exception e) {
            throw new Exception("throws Exception //�.�. �� ������������� �� ����� �� ������������� �������������� ��������");
        }

        //�������� ������������
        String numOne = strings[0];
        String numTwo = strings[2];

        try {
            work.checkValues(numOne,numTwo);
        } catch (Exception e) {
            throw new Exception("throws Exception //�.�. ������������ ������������ ������ ������� ���������");
        }

        //resultCheck �������� �������� ������ checkValues
        // 1 - ���� ��� �������� int
        //2 - ���� ��� �������� String

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
                //��������, ��� �������� �� 1 �� 10
                try {
                    int[] numbers1 = work.checkValueNumber(a,b);
                    c = operation(operation, numbers1[0], numbers1[1]);
                    finalResult = Integer.toString(c);
                } catch (Exception e) {
                    throw new Exception("throws Exception //�.�. ����� ������ ���� �� 1 �� 10");
                }  break;

            case 2:
                a = numb.switchValue(numOne);
                b = numb.switchValue(numTwo);
                //���� ��� ����� ����� 10 � ����� ���������
                if (a == 10 && b == 10 && operation.equals("*")){
                    finalResult = "C";
                    break;
                }
                c = operation(operation,a,b);

                //��������, ��� ��������� ������ 1.
                if (c < 1){
                    throw new Exception("throws Exception //�.�. ���� ��������� ������ ������ �������, ������������� ����������");
                }

                finalResult = numb.backSwitchValue(c);
                break;
        }
        return finalResult;
    }

    public static void main(String[] args) throws Exception {

        //�������� ������ �� ������������
        Scanner console = new Scanner(System.in);
        System.out.println("������� ��������");
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
