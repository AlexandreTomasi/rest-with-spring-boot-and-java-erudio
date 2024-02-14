package br.com.erudio.controllers;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.sub(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.multi(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.div(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.media(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
    public Double raiz(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if(!NumberConverter.isNumeric(numberOne)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.raiz(NumberConverter.convertToDouble(numberOne));
    }
}
