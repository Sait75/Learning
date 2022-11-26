package Kata.Calculator;

import java.util.Scanner;

class Calculator {
    static byte key;

    int strToInt(String arg) throws Exception {
        int num;
        switch (arg) {
            case "1":
                num = 1;
                key++;
                break;
            case "2":
                num = 2;
                key++;
                break;
            case "3":
                num = 3;
                key++;
                break;
            case "4":
                num = 4;
                key++;
                break;
            case "5":
                num = 5;
                key++;
                break;
            case "6":
                num = 6;
                key++;
                break;
            case "7":
                num = 7;
                key++;
                break;
            case "8":
                num = 8;
                key++;
                break;
            case "9":
                num = 9;
                key++;
                break;
            case "10":
                num = 10;
                key++;
                break;
// Соответствие римских чисел арабским
            case "I":
                num = 1;
                key--;
                break;
            case "II":
                num = 2;
                key--;
                break;
            case "III":
                num = 3;
                key--;
                break;
            case "IV":
                num = 4;
                key--;
                break;
            case "V":
                num = 5;
                key--;
                break;
            case "VI":
                num = 6;
                key--;
                break;
            case "VII":
                num = 7;
                key--;
                break;
            case "VIII":
                num = 8;
                key--;
                break;
            case "IX":
                num = 9;
                key--;
                break;
            case "X":
                num = 10;
                key--;
                break;
            default:
                throw new FormatOperandException();
        }
        return num;
    }

    int result(int _arg1, int _arg2, String _operator) throws Exception {
        return switch (_operator) {
            case "+" -> _arg1 + _arg2;
            case "-" -> _arg1 - _arg2;
            case "/" -> _arg1 / _arg2;
            case "*" -> _arg1 * _arg2;
            default -> throw new FormatException();
        };
    }

    // Перевод из арабских чисел в римские
    String toRome(int argIn) {
        int uni = argIn % 10;
        int dec = (argIn % 100) / 10;
        String _uni;
        String _dec;
        if (argIn == 100)
            return "C";
        _dec = switch (dec) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> "";
        };

        _uni = switch (uni) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
        return _dec + _uni;
    }

    static String calc(String input) throws Exception {
        int resultat;
        int arg1, arg2;
        String operator;
        String resultatInString = "";
        Calculator calc = new Calculator();

        try {
            String[] primMass = input.split(" ");
// Проверка на соответствие требуемому формату ввода /операнд1 оператор операнд2/
            if (primMass.length != 3) throw new FormatException();

            arg1 = calc.strToInt(primMass[0]);
            arg2 = calc.strToInt(primMass[2]);
// Проверка на соответствие обоих числа одному формату (арабскому или римскому)
            if (key == 0)
                throw new ArabicAndRomeException();

            operator = primMass[1];
            resultat = calc.result(arg1, arg2, operator);
            if (key == 2)
                resultatInString = String.valueOf(resultat);
            if (key == -2) {
                if (resultat < 1) //проверка на результат в римском исчислении
                    throw new NegativRome();
                else resultatInString = calc.toRome(resultat); // перевод из арабских в римские
            }

        } catch (FormatOperandException e) {
            System.err.println("Неверный формат числа. Требуемый диапазон (1 - 10) или (I - X)");
            System.exit(1);
        } catch (FormatException e) {
            System.err.println("Формат математической операции не удовлетворяет " +
                    "заданию - два операнда и один оператор (+, -, /, *) через пробел");
            System.exit(1);
        } catch (NegativRome e) {
            System.err.println("Результат в Римском исчислени не может быть меньше единицы");
            System.exit(1);
        } catch (ArabicAndRomeException e) {
            System.err.println("Используются одновременно разные системы счисления");
            System.exit(1);
        }
        return resultatInString;
    }

    public static void main(String[] args) throws Exception {
//        String otvet;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку для вычисления:");
        String primer = scan.nextLine();
//        otvet = calc(primer);
        System.out.println("Результат: " + calc(primer));
    }
}







