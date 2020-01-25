package com.nsnieto.keepinmind.util.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CSVWordModel {

    @CsvBindByName(column = "word", required = true)
    private String word;

    @CsvBindByName(column = "mean", required = true)
    private String mean;
}
