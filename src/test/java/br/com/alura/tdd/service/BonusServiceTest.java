package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(new Funcionario("Tarcio", LocalDate.now(), new BigDecimal(250000))));
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAltoComTryCatch() {
        try {
            BonusService bonusService = new BonusService();
        bonusService.calcularBonus(new Funcionario("Tarcio", LocalDate.now(), new BigDecimal(250000)));
        } catch (Exception e) {
            assertEquals("Funcionario com salario maior que do que RS 10.000,0 nao recebe bonus", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Tarcio", LocalDate.now(), new BigDecimal(1000)));

        assertEquals(new BigDecimal("100.0"), bonus);

    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Tarcio", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.0"), bonus);

    }
}