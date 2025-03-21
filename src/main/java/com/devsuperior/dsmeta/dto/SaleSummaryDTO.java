package com.devsuperior.dsmeta.dto;


import com.devsuperior.dsmeta.projections.SaleSummaryProtection;

public class SaleSummaryDTO {

    // Atributos de Classe
    private final String sellerName;
    private Double total;


    // Construtores
    public SaleSummaryDTO(String sellerName, Double total){
        this.sellerName = sellerName;
        this.total = total;
    }

    public SaleSummaryDTO(SaleSummaryProtection projection){
        sellerName = projection.getSellerName();
        total = projection.getTotal();
    }

    // Getters

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }
}
