package com.pattern.creational.abstractfactory.FileSave;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileOnDifferentLine implements TextFile {

    public final String DIR_PATH = "/home/varunu28/Documents/JavaPrac/src/DesignPatterns/";
    public File file = new File(DIR_PATH + "fileDiffLine.txt");

    @Override
    public void saveTextFileFormatted(int... arr) throws Exception {

        if (file.exists()) {
            file.delete();
        }
        else {
            file.createNewFile();
        }

        try {
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(file, true));

            for (int n : arr) {
                writer.write(n + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Updated to Text file with data on different line");
    }
}
