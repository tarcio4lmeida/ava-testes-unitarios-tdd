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
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Tarcio", LocalDate.now(), new BigDecimal(250000)));

        assertEquals(BigDecimal.ZERO, bonus);

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