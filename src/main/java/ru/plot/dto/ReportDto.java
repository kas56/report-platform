package ru.plot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
public class ReportDto {
    private BigInteger userId;
    private BigInteger reportId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateReport;

    private BigInteger bankId;

    private BigInteger typeDogId;

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
    private BigDecimal balanceSumm;
    // вид договора
    private String typeDog;
    // дата подписания договора
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate signDog;
    // дата начал действия договора
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDog;
    // дата окончания действия договора
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDog;
    // расчётная ставка годовых
    private BigDecimal percent;
    // валюта договора (такая же как валюта счетов в банке)
    private String valCodeDog;
    // сумма по договору
    private BigDecimal operSum;
}
