package com.schedules.hotel_schedules.dtos;

public class ClientDto {

    private Integer id;
    private String name;
    private String cpf;

    public ClientDto() {
    }

    public ClientDto(Integer id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClientDto\nId: " + id + "\nName: " + name + "\nCpf: " + cpf;
    }

}