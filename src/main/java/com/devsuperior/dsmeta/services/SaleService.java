package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    // Busco ao banco de dados por ID
    @Transactional(readOnly = true)
    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }

    // Report
    public Page<SaleReportDTO> getReport(String minDate, String maxDate, String sellerName, Pageable pageable) {

        // Uso de função auxiliar para validação das datas
        LocalDate[] dates = getMinAndMaxDates(minDate, maxDate);

        LocalDate startDate = dates[0];
        LocalDate endDate = dates[1];

        return repository.salesReport(startDate.toString(), endDate.toString(),
                sellerName, pageable).map(SaleReportDTO::new);

    }


    // Summary
    public List<SaleSummaryDTO> getSummary(String minDate, String maxDate) {

        // Uso de função auxiliar para validação das datas
        LocalDate[] dates = getMinAndMaxDates(minDate, maxDate);

        LocalDate startDate = dates[0];
        LocalDate endDate = dates[1];

        return repository.salesSummary(startDate.toString(), endDate.toString()).stream().map(SaleSummaryDTO::new).toList();
    }


    // Função auxiliar
    private LocalDate[] getMinAndMaxDates(String minDate, String maxDate) {
        LocalDate startDate;
        LocalDate endDate;

        // Tratamento da data Máxima
        if (!maxDate.isEmpty()) {
            endDate = LocalDate.parse(maxDate);
        } else {
            endDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        }

        // Tratamento da data Mínima
        if (!minDate.isEmpty()) {
            startDate = LocalDate.parse(maxDate);
        } else {
            startDate = endDate.minusYears(1L);
        }

        // Retorna vetor com duas datas com indices 0 para startDate e 1 para endDate
        return new LocalDate[]{startDate, endDate};

    }

}
