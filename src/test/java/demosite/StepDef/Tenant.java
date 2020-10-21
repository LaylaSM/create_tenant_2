package demosite.StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demosite.Page.TenantPage;
import org.openqa.selenium.By;

import static demosite.WebUtility.*;

public class Tenant {
    TenantPage tenantPage = new TenantPage();


    @Given("^User access APM Cloud Login Page$")
    public void user_access_apm_cloud_login_page() {
        redirectTo("https://dev-identity.andalsoftware.com");
    }


    @Then("^System display textbox email$")
    public void system_display_textbox_email() {
        waitForElementVisible(By.id("Username"));
    }

    @And("^System display textbox password$")
    public void system_display_textbox_password() {
        try {
            waitForElementVisible(By.id("passwordID"));
        } catch (Exception e) {
            e.printStackTrace();
            System.console().printf("Error!");

        }
    }

    @And("^System display button login$")
    public void system_display_button_login() {
        waitForElementVisible(By.id("btn_login"));
    }

    @And("^System display button sign up$")
    public void system_display_button_sign_up() {
        waitForElementVisible(By.id("btn_signUp"));
    }

    @When("^User fill \"([^\"]*)\" on textbox email$")
    public void user_fill_email(String email) {
        waitForAction(2000);
        waitAndFill(By.id("Username"), email);
    }

    @And("^User click button login$")
    public void user_click_button_login() {
        waitAndClick(By.id("btn_login"));
    }

    @Then("^System display label validation password mandatory$")
    public void system_display_label_validation_password_mandatory() {
        waitForElementVisible(By.id("msg_invalidUser"));
    }

    @And("^User fill \"([^\"]*)\" on textbox password$")
    public void user_fill_password(String password) {
        waitForAction(2000);
        waitAndFill(By.id("passwordID"), password);
    }

    @Then("^System display label validation password wrong$")
    public void system_display_label_validation_wrong_password() {
        waitForElementVisible(By.id("msg_invalidUser"));
    }

    @Then("^System display label validation email wrong$")
    public void system_label_validation_email_wrong() {
        waitForElementVisible(By.id("msg_invalidUser"));
    }

    @Then("^System display label validation email mandatory$")
    public void system_diplay_label_validation_email_mandatory() {
        waitForElementVisible(By.id("msg_invalidUser"));
    }

    @Then("^System display payroll system page$")
    public void system_display_payroll_system_page() {
        redirectTo("https://dev-identity.andalsoftware.com/PayrollSystem/ViewCreate");
    }

    @And("^User click button create payroll system$")
    public void user_click_button_create_payroll_system(){
        waitAndClick(By.id("btn_createPayrollSystem"));
    }


}
