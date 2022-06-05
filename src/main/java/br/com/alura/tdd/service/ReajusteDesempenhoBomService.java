package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteDesempenhoBomService implements CalculoReajuste {

    public void concederReajuste(Funcionario funcionario) {
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
        funcionario.reajustarSalario(reajuste);
    }
}
