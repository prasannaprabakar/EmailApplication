package utilities;

import pageObjects.InboxPageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Create_CSV
{
   public static PrintWriter printWriter;
    public static void enterData(Object data[][])
    {
        try
        {
            String userDir=System.getProperty("user.dir");
            String pathSeparator = System.getProperty("file.separator");
            String filePath=userDir+pathSeparator+"output.csv";
            printWriter = new PrintWriter(new File(filePath));
            StringBuilder builder= new StringBuilder();
            builder.append("SENDER,SUBJECT,TIME");
            builder.append("\n");
            for(int rowIndex = 0; rowIndex< InboxPageObjects.subject.size(); rowIndex++){
                for (int cellIndex=0;cellIndex<3;cellIndex++){
                   builder.append(data[rowIndex][cellIndex]);
                   builder.append(",");
                }
                builder.append("\n");
            }
            printWriter.write(builder.toString());
            printWriter.close();
        } catch (FileNotFoundException e)
        {
            e.getMessage();
        }
    }
}
