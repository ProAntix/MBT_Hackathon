package com.company.modelimplementations;


import com.company.FenergoSharedState;
import com.company.helper.Helper;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Implements the model (and interface) FenergoSharedState
 * The default path generator is Random Path.
 * Stop condition is 100% coverage of all edges.
 * The start element in the model is e_StartBrowser.
 */
@GraphWalker(value = "random(edge_coverage(10))", start = "e_StartClient")
public class Fenergo extends ExecutionContext implements FenergoSharedState {

    @Override
    public void e_StartClient() {
        Helper.getInstance().get("https://f-eun-psqa-app1.fenergotest.com/PSFenergoR8.4.1.Web/");
    }

    @Override
    public void v_LandingPage() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='font-header2' and text()='My Tasks']")));
    }


    @Override
    public void v_COICase_CaptureRequestDetails() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void v_NonClientLE360() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void v_ClientLE360() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    public void v_CompleteRequest() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void v_SearchDuplicates() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void v_EnterEntityDetailsPage() {
        Helper.getWaiter().until(ExpectedConditions.textToBe(By.tagName("h1"), "Enter Entity Details"));
        //WebElement table = Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("owners")));
        //org.junit.Assert.assertTrue(table.findElements(By.xpath("id('owners')/tbody/tr")).size() >= 10);
    }

    @Override
    public void e_FillNewRequestIndividual() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void e_FillNewRequestCompany() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void e_ClickFenergoLogoGPI() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void e_CompleteRequest() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void e_ContinueNewRequest() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @Override
    public void e_NewRequest() {
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon fen-icon-plus color']/ancestor::button"))).click();
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='New Request']"))).click();
    }

    @Override
    public void e_ClickLENameGPI() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/header/div[1]/div/a")));
    }

    @BeforeExecution
    public void setup() {
        System.out.println("Fenergo: Any setup steps happens here. " +
                           "The annotation @BeforeExecution makes sure that before any elements in the " +
                           "model is called, this method is called first");
        Helper.setup();
    }

    @AfterExecution
    public void cleanup() {
        System.out.println("Fenergo: Any cleanup  steps happens here. " +
                           "The annotation @AfterExecution makes sure that after the test is done, " +
                           "this method is called last.");
        Helper.tearDown();
    }

    @BeforeElement
    public void printBeforeElement() {
        System.out.println("Before element " + getCurrentElement().getName());
    }

    @AfterElement
    public void printAfterElement() {
        System.out.println("After element " + getCurrentElement().getName());
    }
}
