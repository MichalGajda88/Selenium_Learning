package pl.test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class launchbrowser {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium test\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://allegro.pl/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        if (title.equalsIgnoreCase("Allegro - atrakcyjne ceny"))
            System.out.println("Title matches");
        else
            System.out.println(title);

        String tagname = " ";
        tagname = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(5) > div > div > div:nth-child(1) > " +
                "div > div > div > div > div > div:nth-child(2) > div > nav > div > div > div._1hmar.mjyo_6x > div._1w8vu > a:nth-child(2) > span")).getText();
        System.out.println(tagname);

        WebElement przejdz = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(8) > div > div._1yyhi > " +
                "div > div._9f0v0._jkrtd.mpof_ki_s > button._13q9y._8hkto.munh_56_m.m7er_k4.m7er_56_m"));
        Actions action = new Actions(driver);
        action.moveToElement(przejdz).click().perform();
        Thread.sleep(1000);

        WebElement search = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(2) > header > div >" +
                " div > div > div > form > input"));

        action.moveToElement(search).click().sendKeys("Torba dla Misiaczka").perform();

        WebElement searchButton = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(2) > header > div > " +
                "div > div > div > form > button"));
        action.moveToElement(searchButton).click().perform();
        Thread.sleep(5000);
        driver.close();
        System.out.println("Sukces!");

    }
}
