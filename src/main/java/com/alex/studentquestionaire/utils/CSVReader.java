package com.alex.studentquestionaire.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.NonNull;
import lombok.val;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class CSVReader {
    //Took from baeldung

    public <T> List<T> loadObjectList(@NonNull Class<T> type, @NonNull String fileName) {
        try {
            val mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.readerFor(type).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
