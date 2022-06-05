package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {
    private ReajusteDesempenhoService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.reajusteService = new ReajusteDesempenhoService();
        this.funcionario = new Funcionario("Tarcio", LocalDate.now(), new BigDecimal("1000.0"));
    }

    @Test
    void reajusteDeveriaSer3PorCentoQuandoDesempenhoForADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.0"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSer15PorCentoQuandoDesempenhoForBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.0"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSer20PorCentoQuandoDesempenhoForOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.0"), funcionario.getSalario());
    }
}