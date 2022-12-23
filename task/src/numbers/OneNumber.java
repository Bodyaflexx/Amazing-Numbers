package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OneNumber {
    public Long number;

    public OneNumber(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void printNum() {
        System.out.printf("Properties of %d", number);
    }

    public String checkOnValid() {
        return number < 0 ? "The first parameter should be a natural number or zero." : null;
    }

    public boolean checkOnEven() {
        return number % 2 == 0;
    }

    public boolean checkOnBuzz() {
        return number % 10 == 7 || number % 7 == 0;
    }

    public boolean checkOnDuck() {
        int countOfZeroes = 0;
        long numberForThisMethod = number;
        while (numberForThisMethod > 9) {
            if (numberForThisMethod % 10 == 0) {
                countOfZeroes++;
            }
            numberForThisMethod /= 10;
        }
        return countOfZeroes > 0;
    }

    public boolean checkOnPalindromic() {
        List<Long> ourNumber = new ArrayList<>();
        boolean isPalindromic = true;
        long numberForThisMethod = number;
        while (numberForThisMethod > 0) {
            ourNumber.add(numberForThisMethod % 10);
            numberForThisMethod /= 10;
        }
        for (int i = 0; i < ourNumber.size(); i++) {
            if (!Objects.equals(ourNumber.get(i), ourNumber.get(ourNumber.size() - i - 1))) {
                isPalindromic = false;
                break;
            }
        }
        return isPalindromic;
    }

    public boolean checkOnGapful() {
        StringBuilder num = new StringBuilder(String.valueOf(number));
        if (num.length() < 3) {
            return false;
        } else {
            String str = String.valueOf(num.charAt(0)) +
                    num.charAt(num.length() - 1);
            return number % Long.parseLong(str) == 0;
        }
    }

    public boolean checkOnSpy() {
        StringBuilder num = new StringBuilder(String.valueOf(number));
        int sum = 0;
        int product = 1;
        for (int i = 0; i < num.length(); i++) {
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        for (int i = 0; i < num.length(); i++) {
            product *= Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return sum == product;
    }

    public boolean checkOnSunny() {
        return Math.sqrt(1 + number) % 1 == 0;
    }

    public boolean checkOnJumping() {
        StringBuilder num = new StringBuilder(String.valueOf(number));
        for (int i = 0; i < num.length() - 1; i++) {
            if (Integer.parseInt(String.valueOf(num.charAt(i))) + 1 != Integer.parseInt(String.valueOf(num.charAt(i + 1))) && Integer.parseInt(String.valueOf(num.charAt(i))) - 1 != Integer.parseInt(String.valueOf(num.charAt(i + 1)))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkOnHappy() {
        StringBuilder num = new StringBuilder(String.valueOf(number));
        long temp = 0;
        while (temp != number) {
            for (int i = 0; i < num.length(); i++) {
                temp += (long) Math.pow(Long.parseLong(String.valueOf(num.charAt(i))), 2);
            }
            num = new StringBuilder(String.valueOf(temp));
            if (temp == 1) {
                return true;
            }
            if (num.length() == 1) {
                return false;
            }
            temp = 0;
        }
        return false;
    }

    public boolean checkOnSquare() {
        return Math.sqrt(number) % 1 == 0;
    }
}

