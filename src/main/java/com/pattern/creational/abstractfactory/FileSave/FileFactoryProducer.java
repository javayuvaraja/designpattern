package com.pattern.creational.abstractfactory.FileSave;

public class FileFactoryProducer {

    public static AbstractFileFactory getFileFormat(String choice) {
        if ("Text".equalsIgnoreCase(choice)) {
            return new TextFileFactory();
        }
        else if ("Csv".equalsIgnoreCase(choice)) {
            return new CsvFileFactory();
        }

        return null;
    }
}
