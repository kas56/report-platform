package ru.plot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plot.entity.CurrencyRate;
import ru.plot.entity.Okv;
import ru.plot.jaxb.cb.ValCursType;
import ru.plot.repo.CurrencyRateRepository;
import ru.plot.repo.OkvRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BicService {
    @Autowired
    private CurrencyRateRepository currencyRateRepository;
    @Autowired
    private OkvRepository okvRepository;

    public void saveCurse(ValCursType valCurs) {
        List<CurrencyRate> curss = valCurs.getValute().stream().map(valuteType -> {
            CurrencyRate rate = new CurrencyRate();
            rate.setNominal(Integer.valueOf(valuteType.getNominal()));
            rate.setValue(new BigDecimal(valuteType.getValue().replace(",", ".")));
            Okv okvByCharcode = okvRepository.findOkvByCharcode(valuteType.getCharCode());
            rate.setOkv(okvByCharcode);
            return rate;
        }).collect(Collectors.toList());
        currencyRateRepository.saveAll(curss);
    }
}
