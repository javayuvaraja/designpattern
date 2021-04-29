package com.pattern.creational.abstractfactory.FileSave;

public class FileSaveDemo {

    public static int[] arr = {1, 2, 3, 4, 5};

    public static void main(String... args) throws Exception {

        AbstractFileFactory textFileFactory = FileFactoryProducer.getFileFormat("text");

        TextFile textFileFormat = textFileFactory.saveAsTextFile("same");
        textFileFormat.saveTextFileFormatted(arr);

        TextFile textFileFormat2 = textFileFactory.saveAsTextFile("different");
        textFileFormat2.saveTextFileFormatted(arr);

        AbstractFileFactory csvFileFactory = FileFactoryProducer.getFileFormat("csv");

        CsvFile csvFileFormat = csvFileFactory.saveAsCsvFile("same");
        csvFileFormat.saveCsvFileFormatted(arr);

        CsvFile csvFileFormat2 = csvFileFactory.saveAsCsvFile("different");
        csvFileFormat2.saveCsvFileFormatted(arr);
    }
}
