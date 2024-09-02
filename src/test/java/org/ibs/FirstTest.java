package org.ibs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    void testAddVegetable() {

        ChromeOptions options = new ChromeOptions();
        String version = "127.0.6533.120";
        options.setBrowserVersion(version);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/food");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement buttonAdd = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        buttonAdd.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));
        inputName.click();
        inputName.sendKeys("Картошка");

        WebElement selectType = driver.findElement(By.xpath("//select[@id='type']"));
        WebElement vegetable = driver.findElement(By.xpath("//option[@value='VEGETABLE']"));
        selectType.sendKeys(vegetable.getText());

        WebElement buttonSave = driver.findElement(By.xpath("//button[@id='save']"));
        buttonSave.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement newVegetableName = driver.findElement(By.ByCssSelector.cssSelector(
                "tbody tr:last-child td:nth-of-type(1)"));
        Assertions.assertEquals("Картошка", newVegetableName.getText());

        WebElement newVegetableType = driver.findElement(By.ByCssSelector.cssSelector(
                "tbody tr:last-child td:nth-of-type(2)"));
        Assertions.assertEquals("Овощ", newVegetableType.getText());

        WebElement newVegetableIsExotic = driver.findElement(By.ByCssSelector.cssSelector(
                "tbody tr:last-child td:nth-of-type(3)"));
        Assertions.assertEquals("false", newVegetableIsExotic.getText());

        driver.quit();
    }

    @Test
    void testAddFruit() {

        ChromeOptions options = new ChromeOptions();
        String version = "127.0.6533.120";
        options.setBrowserVersion(version);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/food");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement buttonAdd = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        buttonAdd.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));
        inputName.click();
        inputName.sendKeys("Манго");

        WebElement selectType = driver.findElement(By.xpath("//select[@id='type']"));
        WebElement fruit = driver.findElement(By.xpath("//option[@value='FRUIT']"));
        selectType.sendKeys(fruit.getText());

        WebElement inputExotic = driver.findElement(By.xpath("//input[@id='exotic']"));
        inputExotic.click();

        WebElement buttonSave = driver.findElement(By.xpath("//button[@id='save']"));
        buttonSave.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement newFruitName = driver.findElement(By.ByCssSelector.cssSelector(
                "tbody tr:last-child td:nth-of-type(1)"));
        Assertions.assertEquals("Манго", newFruitName.getText());

        WebElement newFruitType = driver.findElement(By.ByCssSelector.cssSelector(
                "tbody tr:last-child td:nth-of-type(2)"));
        Assertions.assertEquals("Фрукт", newFruitType.getText());

        WebElement newFruitIsExotic = driver.findElement(By.ByCssSelector.cssSelector(
                "tbody tr:last-child td:nth-of-type(3)"));
        Assertions.assertEquals("true", newFruitIsExotic.getText());

        driver.quit();
    }

}
