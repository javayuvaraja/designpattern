package com.pattern.creational.abstractfactory.FileSave;

public class CsvFileFactory extends AbstractFileFactory {
    @Override
    CsvFile saveAsCsvFile(String fileFormat) {
        if ("Same".equalsIgnoreCase(fileFormat)) {
            return new CsvFileSameLine();
        }
        else if ("Different".equalsIgnoreCase(fileFormat)) {
            return new CsvFileOnDifferentLine();
        }

        return null;
    }

    @Override
    TextFile saveAsTextFile(String fileFormat) {
        return null;
    }
}
