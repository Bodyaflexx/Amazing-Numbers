package numbers;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersAndProperty extends MoreNumbers {
    private final String[] needProperties;

    public NumbersAndProperty(Long number, Long secondNumber, String[] needProperties) {
        super(number, secondNumber);
        this.needProperties = needProperties;
    }


    public void setProperty(String property) {
    }

    public String[] getProperty() {
        return needProperties;
    }


    public List<String> checkProperties() {
        List<String> result = new ArrayList<>();
        for (String needProperty : needProperties) {
            StringBuilder tmp = new StringBuilder(needProperty);
            boolean itHas = false;
            for (Properties property : Properties.values()) {
                if (tmp.toString().replace("-", "").equalsIgnoreCase(property.toString())) {
                    itHas = true;
                    break;
                }
            }
            if (!itHas) {
                result.add(needProperty);
            }
        }
        return result;
    }

    @Override
    public String info() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < secondNumber; i++) {
            boolean isTrue = false;
            String tmp = null;
            while (!isTrue) {
                tmp = super.info();
                isTrue = true;
                for (String s : needProperties) {
                    if (s.startsWith("-")) {
                        if (tmp.contains(s.replace("-", "").toLowerCase())) {
                            isTrue = false;
                            break;
                        }
                        continue;
                    }
                    if (!tmp.contains(s.toLowerCase())) {
                        isTrue = false;
                        break;
                    }
                }
            }
            result.append(tmp).append("\n");
        }
        return result.toString();
    }

    public boolean checkOnExclusive() {
        List<List<String>> exclusives = new ArrayList<>();
        exclusives.add(List.of("even", "odd"));
        exclusives.add(List.of("-even", "-odd"));
        exclusives.add(List.of("duck", "spy"));
        exclusives.add(List.of("-duck", "-spy"));
        exclusives.add(List.of("sunny", "square"));
        exclusives.add(List.of("-sunny", "-square"));
        exclusives.add(List.of("sad", "happy"));
        exclusives.add(List.of("-sad", "-happy"));
        exclusives.add(List.of("-odd", "odd"));
        exclusives.add(List.of("-even", "even"));
        exclusives.add(List.of("-duck", "duck"));
        exclusives.add(List.of("-sunny", "sunny"));
        exclusives.add(List.of("-square", "square"));
        exclusives.add(List.of("-sad", "sad"));
        exclusives.add(List.of("-happy", "happy"));
        for (List<String> exclusive : exclusives) {
            int counter = 0;
            for (String exs : exclusive) {
                for (String needProperty : needProperties) {
                    if (needProperty.equalsIgnoreCase(exs)) {
                        counter++;
                        break;
                    }
                }
                if (counter == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public enum Properties {
        EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, SAD, HAPPY
    }

}
