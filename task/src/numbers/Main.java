package numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");
        printRequests();
        System.out.println("Enter a request:");
        String number = scanner.nextLine();
        while (true) {
            String[] numbers = number.split(" ");
            if (numbers.length == 0) {
                printRequests();
            } else if (Long.parseLong(Arrays.stream(numbers).toList().get(0)) == 0) {
                System.out.println("Goodbye!");
                return;
            } else if (numbers.length == 1) {
                forOneNumber(numbers);
            } else if (numbers.length == 2) {
                forTwoNumbers(numbers);
            } else {
                forNumbersAndProperties(numbers);
            }
            System.out.println("Enter a request:");
            number = scanner.nextLine();
        }
    }

    private static void printRequests() {
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
    }

    private static void forOneNumber(String[] numbers) {
        OneNumber buzzNumber = new OneNumber(Long.parseLong(Arrays.stream(numbers).toList().get(0)));
        if (buzzNumber.checkOnValid() != null) {
            System.out.println(buzzNumber.checkOnValid());
        } else {
            buzzNumber.printNum();
            System.out.println();
            System.out.println("    buzz: " + buzzNumber.checkOnBuzz());
            System.out.println("    duck: " + buzzNumber.checkOnDuck());
            System.out.println("    palindromic: " + buzzNumber.checkOnPalindromic());
            System.out.println("    gapful: " + buzzNumber.checkOnGapful());
            System.out.println("    spy: " + buzzNumber.checkOnSpy());
            System.out.println("    sunny: " + buzzNumber.checkOnSunny());
            System.out.println("    square: " + buzzNumber.checkOnSquare());
            System.out.println("    jumping: " + buzzNumber.checkOnJumping());
            System.out.println("    happy: " + buzzNumber.checkOnHappy());
            System.out.println("    sad: " + !buzzNumber.checkOnHappy());
            if (buzzNumber.checkOnEven()) {
                System.out.println("""
                            even: true
                            odd: false
                        """);
            } else {
                System.out.println("""
                            even: false
                            odd: true
                        """);
            }
        }
    }

    private static void forTwoNumbers(String[] numbers) {
        MoreNumbers buzzNumber = new MoreNumbers(
                Long.parseLong(Arrays.stream(numbers).toList().get(0)),
                Long.parseLong(Arrays.stream(numbers).toList().get(1)));
        if (buzzNumber.checkOnValid() != null) {
            System.out.println(buzzNumber.checkOnValid());
        } else {
            for (int i = 0; i < Long.parseLong(Arrays.stream(numbers).toList().get(1)); i++) {
                System.out.println(buzzNumber.info());
            }
        }
    }

    private static void forNumbersAndProperties(String[] numbers) {
        String[] properties = new String[numbers.length - 2];
        System.arraycopy(numbers, 2, properties, 0, numbers.length - 2);
        NumbersAndProperty numbersAndProperty = new NumbersAndProperty(
                Long.parseLong(Arrays.stream(numbers).toList().get(0)),
                Long.parseLong(Arrays.stream(numbers).toList().get(1)),
                properties);
        if (numbersAndProperty.checkProperties().size() > 0) {
            if (numbersAndProperty.checkProperties().size() > 1) {
                System.out.println("The properties " + numbersAndProperty.checkProperties() + " are wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            } else if (numbersAndProperty.checkProperties().size() == 1) {
                System.out.println("The property " + numbersAndProperty.checkProperties() + " is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            }
        } else {
            if (numbersAndProperty.checkOnExclusive()) {
                System.out.println(numbersAndProperty.info());
            } else {
                System.out.println("The request contains mutually exclusive properties: " + Arrays.toString(properties) + "\n" +
                        "There are no numbers with these properties.");
            }
        }
    }
}
