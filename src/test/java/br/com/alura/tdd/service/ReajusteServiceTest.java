package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    @Test
    void reajusteDeveriaSer3PorCentoQuandoDesempenhoForADesejar() {
        ReajusteDesempenhoService reajusteService = new ReajusteDesempenhoService();
        Funcionario funcionario = new Funcionario("Tarcio", LocalDate.now(), new BigDecimal("1000.0"));
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.0"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSer15PorCentoQuandoDesempenhoForBom() {
        ReajusteDesempenhoService reajusteService = new ReajusteDesempenhoService();
        Funcionario funcionario = new Funcionario("Tarcio", LocalDate.now(), new BigDecimal("1000.0"));
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.0"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSer20PorCentoQuandoDesempenhoForOtimo() {
        ReajusteDesempenhoService reajusteService = new ReajusteDesempenhoService();
        Funcionario funcionario = new Funcionario("Tarcio", LocalDate.now(), new BigDecimal("1000.0"));
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.0"), funcionario.getSalario());
    }
}