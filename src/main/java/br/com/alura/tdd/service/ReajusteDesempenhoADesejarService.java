package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteDesempenhoADesejarService implements CalculoReajuste {

    public void concederReajuste(Funcionario funcionario) {
        BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
        funcionario.reajustarSalario(reajuste);
    }
}
