package com.techelevator.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SalesReport {
    public static FileWriter sr;

    public static void writeToSalesReport(String message) {
        try {
            if(sr == null) {
                Date currentdate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                File report = new File(String.format("sales/%s-Report.txt",dateFormat.format(currentdate)));
                sr = new FileWriter(report, true);
            }
            sr.write(message);
            sr.flush();

        } catch (IOException e) {
            System.out.println("Error Writing To File");
        }
    }

    public static void finalizeSalesReport() {
        try {
            if(sr != null) {
                sr.close();
                sr = null;
            }
        } catch(IOException ignored) {
        }
    }
}
