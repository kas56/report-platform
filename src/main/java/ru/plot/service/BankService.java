package ru.plot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plot.entity.Bank;
import ru.plot.entity.CurrencyRate;
import ru.plot.entity.Okv;
import ru.plot.jaxb.cb.ValCursType;
import ru.plot.jaxb.cb.bic.BicCodeType;
import ru.plot.repo.BankRepository;
import ru.plot.repo.CurrencyRateRepository;
import ru.plot.repo.OkvRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;


    public void saveBik(BicCodeType bicCodeType) {
        List<Bank> banks = new ArrayList<>();
        bicCodeType.getRecord().stream().forEach(valuteType -> {
            Optional<Bank> bankopt = bankRepository.findById(1L);
            Bank bank = null;
            if (bankopt.isPresent()) {
                bank = bankopt.get();
                //bank.setNamep();
            } else {
                bank = new Bank();
                //bank.setNamep();
            }
            banks.add(bank);
        });
        bankRepository.saveAll(banks);
    }
}
