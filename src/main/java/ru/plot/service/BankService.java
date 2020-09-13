package ru.plot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plot.entity.Bank;
import ru.plot.entity.BankBic;
import ru.plot.entity.CurrencyRate;
import ru.plot.entity.Okv;
import ru.plot.jaxb.cb.ValCursType;
import ru.plot.jaxb.cb.bic.BicCodeType;
import ru.plot.jaxb.cb.bic.RecordType;
import ru.plot.repo.BankBicRepository;
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
    private BankBicRepository bankBicRepository;


    public void saveBankBic(BicCodeType bicCodeType) {
        List<BankBic> bankBics = new ArrayList<>();

        for (RecordType recordType : bicCodeType.getRecord()) {
            Optional<BankBic> bankBicOpt = bankBicRepository.findByBic(recordType.getBic());
            BankBic bankBic = null;
            if (bankBicOpt.isPresent()) {
                bankBic = bankBicOpt.get();
                if (
                        !bankBic.getRegnum().equals(recordType.getRegNum().getValue())
                                || !bankBic.getShortname().equals(recordType.getShortName())
                ) {
                    bankBic.setRegnum(recordType.getRegNum().getValue());
                    bankBic.setShortname(recordType.getShortName());
                    bankBics.add(bankBic);
                }
            } else {
                bankBic = new BankBic();
                bankBic.setRegnum(recordType.getRegNum().getValue());
                bankBic.setShortname(recordType.getShortName());
                bankBic.setBic(recordType.getBic());
                bankBics.add(bankBic);
            }
        }
        bankBicRepository.saveAll(bankBics);
    }

    public List<BankBic> getBankBics() {
        return (List<BankBic>) bankBicRepository.findAll();
    }
}
