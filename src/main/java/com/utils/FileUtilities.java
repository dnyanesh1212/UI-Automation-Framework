package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtilities {
    String filePath = "./src/test/resources/config.properties";

    // utility to read properties file
    public Properties getProp() {
        Properties prop = new Properties();
        FileInputStream fis;
        {
            try {
                fis = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
