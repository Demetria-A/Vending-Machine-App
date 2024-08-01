package com.techelevator.util;

import com.techelevator.Exceptions.TransLogException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TransLog {

private static FileWriter fw = null;

    public static void log(String message) {
        File logFile = new File("log/Log.txt");
       try {
           if (fw == null) {
            fw = new FileWriter(logFile, true);
       }
            Date currentdate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            fw.write(String.format("%s %s\n",dateFormat.format(currentdate),message));
            fw.flush();

       } catch (IOException e) {
            throw new TransLogException(e.getMessage());
        }

    }
    }
