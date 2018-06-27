package com.company.modelimplementations;


import com.company.EnterEntityDetailsSharedState;
import com.company.helper.Helper;
import org.apache.commons.lang3.RandomStringUtils;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the model (and interface) NewOwnerSharedState
 * The default path generator is Random Path.
 * Stop condition is 100% coverage of all edges.
 */
@GraphWalker(value = "random(edge_coverage(100))")
public class EnterEntityDetails extends ExecutionContext implements EnterEntityDetailsSharedState {

    private static final Logger log = LoggerFactory.getLogger(EnterEntityDetails.class);

    @Override
    public void v_EnterEntityDetailsPage() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fen-panel-header enterentitydetails']/h1[text()='Enter Entity Details']")));
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }

    @Override
    public void e_CorrectData() {
        //Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys("Bank");
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys(Keys.RETURN);

        //Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys("Ireland");
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys(Keys.RETURN);

        //Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='LegalEntity_Name']"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='LegalEntity_Name']")))
                .sendKeys("GraphWalker 1");
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='LegalEntity_Name']")))
                .sendKeys(Keys.RETURN);

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=' fen-button button-primary  ']/span/span[text()='Search']"))).click();
    }

    @Override
    public void e_IncorrectData() {
        //Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys("uiqwueuioeur");
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys("Ireland");
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys(Keys.RETURN);

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }

    @Override
    public void v_IncorrectData() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='message-text' and contains(text(), 'Legal Entity Type is required')]")));
    }

    @Override
    public void v_SearchResults() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='caption'][contains(text(),'Fenergo')]")));
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }


    @Override
    public void e_ContinueNewRequest() {
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Continue']"))).click();
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }


    @Override
    public void v_CompleteRequest() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fen-panel-header complete']/h1[text()='Complete']")));
        //Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LEAssociation_AssociateTypeID']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LEAssociation_AssociateTypeID']/following-sibling::div//input")))
                .sendKeys("Broker");
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LEAssociation_AssociateTypeID']/following-sibling::div//input")))
                .sendKeys(Keys.RETURN);
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create entity']"))).click();
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }

    @Override
    public void e_LandingPage() {
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='icon-link' and @href='/app/landingPage']"))).click();
    }

    @Override
    public void v_LandingPage() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='font-header2' and text()='My Tasks']")));
    }

    @Override
    public void e_ClearData() {
        //Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys("Bank");
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input[@role='combobox']")))
                .sendKeys(Keys.RETURN);
    }

}
