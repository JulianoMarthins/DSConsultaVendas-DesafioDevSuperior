package com.devsuperior.dsmeta.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Define que esta classe será uma tabela no banco de dados
@Table(name = "tb_seller") // Nomeia a tabela do banco de dados
public class Seller {

    // Atributos de Classe
    @Id // Define o próximo atributo como chave primária do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cria automaticamente por indentação as chaves primarias
    private Long id;
    private String name;
    private String email;
    private String phone;

    // Relacionamentos
    @OneToMany(mappedBy = "seller") // Cria relacionamento da classe Seller de um para muitos com o Sale, sendo esta relação
    // O atributo sales da classe Sale
    private List<Sale> sales = new ArrayList<>();

    // Construtores
    public Seller() {
    }

    public Seller(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
