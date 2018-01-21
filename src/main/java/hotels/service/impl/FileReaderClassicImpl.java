package hotels.service.impl;


import hotels.service.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileReaderClassicImpl implements FileReader {
    @Override
    public List<String> readFile(String sourcePath) {
        URL resource = getClass().getResource(sourcePath);
        List<String> lines = new ArrayList<>();

        if (resource != null) {
            try (BufferedReader br = new BufferedReader(new java.io.FileReader(resource.getPath()))) {
                String currentLine;

                while ((currentLine = br.readLine()) != null) {
                    lines.add(currentLine);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("File doesn't exist");
        }

        return lines;
    }

}
