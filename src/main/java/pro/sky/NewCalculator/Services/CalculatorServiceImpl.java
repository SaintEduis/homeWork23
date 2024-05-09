package pro.sky.NewCalculator.Services;

import org.springframework.stereotype.Service;
import pro.sky.NewCalculator.Exceptions.DivideByZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String plus(int firstNumb, int secondNumb) {
        return firstNumb + " + " + secondNumb + " = " + (firstNumb + secondNumb);
    }

    @Override
    public String minus(int firstNumb, int secondNumb) {
        return firstNumb + " - " + secondNumb + " = " + (firstNumb - secondNumb);
    }

    @Override
    public String multiply(int firstNumb, int secondNumb) {
        return firstNumb + " * " + secondNumb + " = " + (firstNumb * secondNumb);
    }

    @Override
    public String divide(int firstNumb, int secondNumb) {
        if (secondNumb != 0) {
            return firstNumb + " / " + secondNumb + " = " + (firstNumb / secondNumb);
        }
        else {
            throw new DivideByZeroException();
        }
    }
}
