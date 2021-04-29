package com.pattern.creational.abstractfactory.FileSave;


public abstract class AbstractFileFactory {

    abstract CsvFile saveAsCsvFile(String fileFormat);
    abstract TextFile saveAsTextFile(String fileFormat);
}
