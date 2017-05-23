package com.languagePoc;

import java.io.*;

public class CreateHtmlDocument {

    public void createHTML(String results[],String translate[],String label[]){
        try {
            //define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
            //append html header and title
            htmlStringBuilder.append("<html><head><title>Selenium Test </title></head>");
            //append body
            htmlStringBuilder.append("<body>");
            //append table
            htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
            //append row
            htmlStringBuilder.append("<tr><td><b>TestId</b></td><td><b>Label</b></td><td><b>Translate</b></td><td><b>TestResult</b></td></tr>");
            int j = 0;
            for(int i=0;i<results.length;i++){
            	j = i+1;
            	//append row
                htmlStringBuilder.append("<tr><td>" + j + "</td><td>" + label[i] + "</td><td>" + translate[i] + "</td><td>" + results[i] + " </td></tr> ");
                
            }
            
            
            //close html file
            htmlStringBuilder.append("</table></body></html>");
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),"testfile.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    public static void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }
    
}