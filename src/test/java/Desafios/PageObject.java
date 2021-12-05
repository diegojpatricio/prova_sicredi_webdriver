package Desafios;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageObject {

    private static final String URL_GROCERYCRUD =  "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap/add";
    private WebDriver browser;

    public PageObject(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_GROCERYCRUD);
    }

    public void quitBrowser() {
        browser.quit();
    }

    public void registerClient(String name, String lastName, String firstName, String phone, String addressOne, String addressTwo, String city, String state, String postalCode, String country, String salesRepEmployeeNumber, String creditLimit) {
        browser.findElement(By.linkText("Add Record")).click();
        browser.findElement(By.id("field-customerName")).sendKeys(name);
        browser.findElement(By.id("field-contactLastName")).sendKeys(lastName);
        browser.findElement(By.id("field-contactFirstName")).sendKeys(firstName);
        browser.findElement(By.id("field-phone")).sendKeys(phone);
        browser.findElement(By.id("field-addressLine1")).sendKeys(addressOne);
        browser.findElement(By.id("field-addressLine2")).sendKeys(addressTwo);
        browser.findElement(By.id("field-city")).sendKeys(city);
        browser.findElement(By.id("field-state")).sendKeys(state);
        browser.findElement(By.id("field-postalCode")).sendKeys(postalCode);
        browser.findElement(By.id("field-country")).sendKeys(country);
        browser.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys(salesRepEmployeeNumber);
        browser.findElement(By.id("field-creditLimit")).sendKeys(creditLimit);
        browser.findElement(By.id("form-button-save")).click();
    }

    public void themeBootstrapV4() {
        browser.findElement(By.id("switch-version-select")).click();
        WebElement dropdown = browser.findElement(By.id("switch-version-select"));
        dropdown.findElement(By.xpath("//option[. = 'Bootstrap V4 Theme']")).click();
    }

    public String getMensage() {
        return browser.findElement(By.id("report-success")).getText();
    }

    public String getMensageDelete() {
        return browser.findElement(By.cssSelector(".alert-delete-multiple-one")).getText();
    }

    public String getMensageDeleteSucessFull() {
        return browser.findElement(By.cssSelector("span > p")).getText();
    }

    public void rename(String rename) {
        browser.findElement(By.id("save-and-go-back-button")).click();
        stopTime();
        browser.findElement(By.name("customerName")).click();
        browser.findElement(By.name("customerName")).sendKeys(rename);
        browser.findElement(By.name("customerName")).sendKeys(Keys.ENTER);
        stopTime();
        browser.findElement(By.cssSelector(".select-row")).click();
        stopTime();
        browser.findElement(By.cssSelector(".btn > .text-danger:nth-child(2)")).click();
    }

    public void deleteSucessFull(){
        stopTime();
        browser.findElement(By.cssSelector(".delete-multiple-confirmation-button")).click();
        stopTime();
    }

    public void stopTime(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
