package com.viettel.demo.dto;

import javax.persistence.Column;

public class ClientDto {
    private Long id;

    private String cliNo;

    private String fullName;

    private String birthDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliNo() {
        return cliNo;
    }

    public void setCliNo(String cliNo) {
        this.cliNo = cliNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
