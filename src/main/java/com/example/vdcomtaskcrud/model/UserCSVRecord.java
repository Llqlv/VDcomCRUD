package com.example.vdcomtaskcrud.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCSVRecord {

    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName
    private Integer age;
    @CsvBindByName
    private String vacancy;
    @CsvBindByName
    private String email;
}
