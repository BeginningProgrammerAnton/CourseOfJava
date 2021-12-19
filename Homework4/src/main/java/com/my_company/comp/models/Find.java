package com.my_company.comp.models;

import java.io.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Find {

    private String firstName;
    private String lastName;
    private String info;
    private String browser;
    private Date date = new Date();
    String strDateFormat = "hh:mm:ss a";
    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    String formattedDate= dateFormat.format(date);
    public Date getDate() {
        return date;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    public boolean checkInto(String firstName,String lastName) {
        try {
            java.io.File file = new File("src/main/java/res.txt");

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            {
                int index = line.indexOf(',');
                String substr = line.substring(0, index);
                String cur = lastName + " " + firstName;
                if (cur.equals(substr)) {
                    info = line;
                    return true;
                }
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null)
                {
                    int index = line.indexOf(',');
                    String substr = line.substring(0, index);
                    if ((lastName + " " + firstName).equals(substr)) {
                        info = line;
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public String getInfo() {
        return info;
    }
}
