package br.ufscar.dc.latosensu.web.bolaodacopa2.forms.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.ufscar.dc.latosensu.web.bolaodacopa2.forms.NovoUsuario;

public class SenhaConfirmadaValidator implements ConstraintValidator<SenhaConfirmada, NovoUsuario> {
    public boolean isValid(NovoUsuario nu, ConstraintValidatorContext context) {
        // A senha e confirmação de senha são iguais?
        boolean valido=nu.getSenha().equals(nu.getConfirmarSenha());
        if(!valido) {
            // Se não for, vamos adicionar o erro no campo "confirmarSenha"
            // Para que o ThymeLeaf possa exibir a mensagem no campo de confirmação
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode( "confirmarSenha" ).addConstraintViolation();
        }
        return valido;   
    }
}
