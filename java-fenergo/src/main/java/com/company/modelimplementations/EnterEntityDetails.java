package com.company.modelimplementations;


import com.company.EnterEntityDetailsSharedState;
import com.company.helper.Helper;
import org.apache.commons.lang3.RandomStringUtils;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        //WebElement table = Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("owners")));
        //org.junit.Assert.assertTrue(table.findElements(By.xpath("id('owners')/tbody/tr")).size() >= 10);
    }

    @Override
    public void e_CorrectData() {
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input")))
                .sendKeys("Bank");

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input")))
                .sendKeys("Ireland");

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='LegalEntity_Name']"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='LegalEntity_Name']")))
                .sendKeys("GraphWalker 1");

        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=' fen-button button-primary  ']/span/span[text()='Search']"))).click();
    }

    @Override
    public void e_IncorrectData() {
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntity_SubtypeId']/following-sibling::div//input")))
                .sendKeys("uiqwueuioeur");

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='LegalEntityCompany_CountryOfIncorporationId']/following-sibling::div//input")))
                .sendKeys("Ireland");
    }

    @Override
    public void v_IncorrectData() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='message-text' and contains(text(), 'Legal Entity Type is required')]")));
    }

    @Override
    public void v_SearchResults() {
        Helper.getWaiter().until(ExpectedConditions.textToBe(By.tagName("h1"), "Search For Duplicates"));
        setAttribute("duplicateFound", Helper.getInstance().findElements(By.xpath("//table/tbody/tr/td//dl")).size());
        log.info("Number of Duplicates: " + getAttribute("duplicateFound"));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td[2]/img")));
    }

    @Override
    public void e_DuplicateFound() {
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")))
                .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));
    }

    @Override
    public void e_ContinueNewRequest() {
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")))
                .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));
    }

    public void v_CompleteRequest() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }
}
