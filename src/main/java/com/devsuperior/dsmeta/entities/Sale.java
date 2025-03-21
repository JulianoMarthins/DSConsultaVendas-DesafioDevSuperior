package com.devsuperior.dsmeta.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // Define classe como tabela no banco de dados
@Table(name = "tb_sales") // Nomeia a tabela no banco de dados
public class Sale {

    // Atributos de Classe
    @Id // Define o proximo atributo como chave primária do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cria a chave primaria automaticamente conforme ordem de criaçaõ
    private Long id;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;


    // Relacionamentos
    @ManyToOne // Define que a classe Sale tem relacionamento de muitos para um com a classe Seller
    @JoinColumn(name = "seller_id") // Cria coluna na tabela do banco de dados com o nome seller_id
    private Seller seller;


    // Construtores
    public Sale() {
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVisited() {
        return visited;
    }

    public void setVisited(Integer visited) {
        this.visited = visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
