package com.pattern.creational.abstractfactory.FileSave;

public class TextFileFactory extends AbstractFileFactory {
    @Override
    CsvFile saveAsCsvFile(String fileFormat) {
        return null;
    }

    @Override
    TextFile saveAsTextFile(String fileFormat) {

        if ("Same".equalsIgnoreCase(fileFormat)) {
            return new TextFileOnSameLine();
        }
        else if ("Different".equalsIgnoreCase(fileFormat)) {
            return new TextFileOnDifferentLine();
        }

        return null;
    }
}
