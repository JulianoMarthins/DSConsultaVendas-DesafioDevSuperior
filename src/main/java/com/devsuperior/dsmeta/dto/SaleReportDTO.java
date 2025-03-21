package com.devsuperior.dsmeta.dto;


import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleReportProjection;

import java.time.LocalDate;

public class SaleReportDTO {

    // Atributos de classe
    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;


    // Construtores
    public SaleReportDTO(Long id, LocalDate date, Double amount, String sellerName){
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public SaleReportDTO(Sale entity){
        id = entity.getId();
        date = entity.getDate();
        amount = entity.getAmount();
        sellerName = entity.getSeller().getName();
    }

    public SaleReportDTO(SaleReportProjection projection){
        id = projection.getId();
        date = projection.getDate();
        amount = projection.getAmount();
        sellerName = projection.getSellerName();
    }


    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
    }
}
