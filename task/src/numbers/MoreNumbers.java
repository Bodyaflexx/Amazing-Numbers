package numbers;

public class MoreNumbers extends OneNumber {
    Long secondNumber;

    public MoreNumbers(Long number, Long secondNumber) {
        super(number);
        this.secondNumber = secondNumber;
    }

    public String info() {
        StringBuilder result = new StringBuilder();
        result.append(number).append(" is ");
        if (checkOnBuzz()) {
            result.append("buzz, ");
        }
        if (checkOnDuck()) {
            result.append("duck, ");
        }
        if (checkOnPalindromic()) {
            result.append("palindromic, ");
        }
        if (checkOnGapful()) {
            result.append("gapful, ");
        }
        if (checkOnEven()) {
            result.append("even, ");
        } else {
            result.append("odd, ");
        }
        if (checkOnSpy()) {
            result.append("spy, ");
        }
        if(checkOnSquare()){
            result.append("square, ");
        }
        if(checkOnSunny()){
            result.append("sunny, ");
        }
        if(checkOnJumping()){
            result.append("jumping, ");
        }
        if(checkOnHappy()){
            result.append("happy, ");
        }
        if(!checkOnHappy()){
            result.append("sad, ");
        }
        number++;
        result.setLength(result.length() - 2);
        return result.toString();
    }

    @Override
    public String checkOnValid() {
        if (super.checkOnValid() == null) {
            return secondNumber < 0 ? "The second parameter should be a natural number." : null;
        }
        return null;
    }

}
