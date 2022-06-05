package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteDesempenhoService{

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.reajutaPeloValor());
        funcionario.reajustarSalario(reajuste);
    }
}
