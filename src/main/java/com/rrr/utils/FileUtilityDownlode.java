package com.rrr.utils;

import java.io.File;

public class FileUtilityDownlode {

    public static void deleteOldTickets() {

        File folder = new File("C:\\Users\\Foxberry\\Downloads");

        File[] files = folder.listFiles();

        if (files != null) {
        	
            for (File file : files) {
            	
                if (file.getName().startsWith("ticket-TICKET")) {

                    file.delete();
                }
            }
        }
    }

    public static boolean isTicketDownloaded() {

        File folder = new File("C:\\Users\\Foxberry\\Downloads");

        for (int i = 0; i < 10; i++) {

            File[] files = folder.listFiles();

            if (files != null) {

                for (File file : files) {

                    if (file.getName().startsWith("ticket-TICKET")
                            && !file.getName().endsWith(".crdownload")) {

                        return true;
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return false;
    }
}