package calculator;

import java.util.Scanner;

public class ConsoleCalculator extends Calculator implements Plus, Minus, Multiply, Division {

    private boolean isOn = true;
    private int resultValue = 0;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (isOn) {
            boolean isClear = false;
            System.out.println("Введите первый операнд (s - выход)");

            if (scanner.hasNextInt()) {
                resultValue = resultValue + scanner.nextInt();
            } else {
                char command = scanner.next().charAt(0);
                if (command == 's') {
                    isOn = false;
                    continue;
                } else {
                    System.out.println("Недопустимая команда или операнд!");
                    continue;
                }
            }

            while (!isClear) {
                System.out.println("Введите операцию или команду (+, -, *, /, с - очистить, s - выход)");
                String operationString = scanner.next();
                char operation;
                if (operationString.length() == 1) {
                    operation = operationString.charAt(0);
                } else {
                    System.out.println("Недопустимая операция или команда!");
                    continue;
                }

                switch (operation) {
                    case '+':
                        System.out.println("Введите следующий операнд");
                        if (scanner.hasNextInt()) {
                            resultValue = plus(resultValue, scanner.nextInt());
                            System.out.println("Итог - " + resultValue);
                        }
                        break;
                    case '-':
                        System.out.println("Введите следующий операнд");
                        if (scanner.hasNextInt()) {
                            resultValue = minus(resultValue, scanner.nextInt());
                            System.out.println("Итог - " + resultValue);
                        }
                        break;
                    case '*':
                        System.out.println("Введите следующий операнд");
                        if (scanner.hasNextInt()) {
                            resultValue = multiply(resultValue, scanner.nextInt());
                            System.out.println("Итог - " + resultValue);
                        }
                        break;
                    case '/':
                        System.out.println("Введите следующий операнд");
                        if (scanner.hasNextInt()) {
                            int sc = scanner.nextInt();
                            if (sc == 0) {
                                System.out.println("На ноль делить нельзя!");
                                break;
                            }
                            resultValue = division(resultValue, sc);
                            System.out.println("Итог - " + resultValue);
                        }
                        break;
                    case 's':
                        isOn = false;
                        break;
                    case 'c':
                        isClear = true;
                        resultValue = 0;
                        System.out.println("Итог - " + resultValue);
                        break;
                    default:
                        System.out.println("Неподдерживаемая операция!");
                }
            }
        }
    }


    @Override
    public int division(int a, int b) {
        return a / b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int plus(int a, int b) {
        return a + b;
    }
}
