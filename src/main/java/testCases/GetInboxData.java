package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.InboxPageObjects;

import static utilities.Create_CSV.enterData;

public class GetInboxData extends BaseClass
{
   @Test
    public void InboxData(){
       PageFactory.initElements(driver,InboxPageObjects.class);
       Object emailData[][]=new Object[InboxPageObjects.subject.size()][3];
       for(int rowIndex=0;rowIndex<InboxPageObjects.subject.size();rowIndex++){
           for (int cellIndex=0;cellIndex<3;cellIndex++){
               switch (cellIndex){
                   case 0:emailData[rowIndex][cellIndex]=InboxPageObjects.sender.get(rowIndex).getText();
                   break;
                   case 1:emailData[rowIndex][cellIndex]=InboxPageObjects.subject.get(rowIndex).getText();
                   break;
                   case 2:emailData[rowIndex][cellIndex]=InboxPageObjects.time.get(rowIndex).getText();
                   break;

               }

           }
       }
       logger.info("Store the Sender Subject Time in Objects");
       logger.info("Creating csv file");
       enterData(emailData);


   }

}
