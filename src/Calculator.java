import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> arrayListCalcHistory;

    public ArrayList<String> getArrayListCalcHistory() {
        return arrayListCalcHistory;
    }

    public void setArrayListCalcHistory(ArrayList<String> arrayListCalcHistory) {
        this.arrayListCalcHistory = arrayListCalcHistory;
    }

    public Calculator() {

    }

    public void removeFirstResult() {
        if(!arrayListCalcHistory.isEmpty()) {
            arrayListCalcHistory.remove(0);
        }
    }

    public double calculate(int firstNum, int secondNum, String operator) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = (double) firstNum / secondNum;
                break;
            default:
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(firstNum);
        sb.append(operator);
        sb.append(secondNum);
        sb.append("=");
        sb.append(result);
        arrayListCalcHistory.add(sb.toString());
        return result;
    }
}
