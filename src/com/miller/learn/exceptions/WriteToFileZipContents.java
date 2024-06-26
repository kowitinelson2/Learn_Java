package com.miller.learn.exceptions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class WriteToFileZipContents {

    public static void writeToFileZipFileContents(String zipFileName, String outputFileName) throws IOException {
        Charset charset = StandardCharsets.US_ASCII;
        Path outputFilePath = Paths.get(outputFileName);

        //open zip file and create output file
        // with try-with-resources  statement

        try (ZipFile zf = new ZipFile(zipFileName);
             BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset)) {
            // Enumerate each entry
            for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine  = System.lineSeparator();
                String zipEntryName = ((ZipEntry)entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());

            }
        }
    }

}
