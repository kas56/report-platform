package ru.plot.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
public class ReportDto {
    private String email;
    private LocalDate reportDate;

    private BigInteger orgId;
    // БИК банка
    private String bankBik;
    // наименование банка
    private String bankName;
    // комментарий
    private String comment;
    // валюта счетов в банке
    private String valCode;
    // остаток по счетам в банке
    private String balanceSumm;
    // вид договора
    private String typeDog;
    // дата подписания договора
    private LocalDate signDog;
    // дата начал действия договора
    private LocalDate startDog;
    // дата окончания действия договора
    private LocalDate endDog;
    // расчётная ставка годовых
    private BigDecimal percent;
    // валюта договора (такая же как валюта счетов в банке)
    private String valCodeDog;
    // сумма по договору
    private BigDecimal operSum;
}
