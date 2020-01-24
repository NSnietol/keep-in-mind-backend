package com.nsnieto.keepinmind.util.component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nsnieto.keepinmind.util.model.CSVWordModel;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class ReadCSV {

	public List<CSVWordModel> getListWords(String SAMPLE_CSV_FILE_PATH) throws IOException {


		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));

		CsvToBean<CSVWordModel> csvToBean = new CsvToBeanBuilder(reader)
				.withType(CSVWordModel.class)
				.withIgnoreLeadingWhiteSpace(true).build();


		return csvToBean.parse();
	

	}
}
