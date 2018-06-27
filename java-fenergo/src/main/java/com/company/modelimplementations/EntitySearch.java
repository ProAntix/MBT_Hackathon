package com.company.modelimplementations;


import com.company.EntitySearchSharedState;
import com.company.helper.Helper;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the model (and interface) NewOwnerSharedState
 * The default path generator is Random Path.
 * Stop condition is 100% coverage of all edges.
 */
@GraphWalker(value = "random(edge_coverage(1000))")
public class EntitySearch extends ExecutionContext implements EntitySearchSharedState {

    private static final Logger log = LoggerFactory.getLogger(EntitySearch.class);

    @Override
    public void v_EntitySearchPage() {
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_lblPageTitle']")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
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

}
