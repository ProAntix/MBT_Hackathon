package com.company.modelimplementations;


import com.company.FenergoSharedState;
import com.company.helper.Helper;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Implements the model (and interface) FenergoSharedState
 * The default path generator is Random Path.
 * Stop condition is 100% coverage of all edges.
 * The start element in the model is e_StartBrowser.
 */
@GraphWalker(value = "random(edge_coverage(1000))", start = "e_StartClient")
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
    public void e_NewRequest() {
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon fen-icon-plus color']/ancestor::button"))).click();
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='New Request']"))).click();
    }

    @Override
    public void v_EnterEntityDetailsPage() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fen-panel-header enterentitydetails']/h1[text()='Enter Entity Details']")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }

    @Override
    public void e_EntitySearchPage() {
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='icon fen-icon-search']"))).click();
        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Legal Entity']"))).click();
    }

    @Override
    public void v_EntitySearchPage() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_lblPageTitle']")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
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
