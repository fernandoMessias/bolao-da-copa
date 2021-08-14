package br.ufscar.dc.latosensu.web.bolaodacopa2.forms.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FormatoDataValidator implements ConstraintValidator<FormatoData, String> {
    public boolean isValid(String data, ConstraintValidatorContext context) {
        // Tenta converter a data com o formato específico
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            // Se acontecer algum erro, é porque a data está
            // em formato errado
            return false;
        }
    }
}
