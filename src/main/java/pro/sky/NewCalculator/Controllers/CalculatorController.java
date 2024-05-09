package pro.sky.NewCalculator.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pro.sky.NewCalculator.Exceptions.DivideByZeroException;
import pro.sky.NewCalculator.Services.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        return "Неверный тип введённых данных!";
    }

    @ExceptionHandler(DivideByZeroException.class)
    public String handleDivideByZero(DivideByZeroException e) {
        return "Деление на ноль!";
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1,
                    @RequestParam("num2") int num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1,
                    @RequestParam("num2") int num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1,
                    @RequestParam("num2") int num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1,
                    @RequestParam("num2") int num2) {
        try {
            return calculatorService.divide(num1, num2);
        }
        catch (DivideByZeroException e) {
            throw new DivideByZeroException();
        }
    }
}
