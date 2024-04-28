import java.util.Scanner;

public class Calculator {

        public static int taxEarnings(int earnings) {
            int tax = earnings * 6 / 100;
            return tax;

        }

        public static int taxEarningsMinusSpendings(int earnings, int spendings) {
            int tax = (earnings - spendings) * 15 / 100;
            if (tax >= 0) {
                return tax;
            } else {
              return 0;
            }
        }

    public static int substract(int a, int b) {
        return a - b;
    }


    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);

            int earnings = 0;    // доходы
            int spendings = 0;   // расходы

             while (true) {


                System.out.println("Выберите операцию и введите её номер:\n" + "1. Добавить новый доход\n" + "2. Добавить новый расход\n" + "3. Выбрать систему налогообложения\n");
                String input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }

                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine();
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        String moneyStr1 = scanner.nextLine();
                        int money1 = Integer.parseInt(moneyStr1);
                        spendings += money1;
                        break;

                    case 3:
                        int p1 = taxEarningsMinusSpendings(earnings, spendings);
                        int p2 = taxEarnings(earnings);
                        if (p1>p2) {
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: " + p2 + " рублей");
                            System.out.println(" Налог на другой системе: " + p1 + " рублей");
                            System.out.println("Экономия: " + substract(p1,p2) + " рублей");
                        } else {
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: " + p1 + " рублей");
                            System.out.println(" Налог на другой системе: " + p2 + " рублей");
                            System.out.println("Экономия: " + substract(p2,p1) + " рублей");}
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }




            }


            System.out.println("Программа завершена!");



        }
    }


