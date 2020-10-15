package pl.test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

        action.moveToElement(search).click().sendKeys("Plecak damski skórzany").perform();

        WebElement searchButton = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(2) > header > div > " +
                "div > div > div > form > button"));
        action.moveToElement(searchButton).click().perform();
        Thread.sleep(2000);

        WebElement bag = driver.findElement(By.linkText("TOREBKA SKÓRZANA torba PLECAK SKÓRA A4 worek 3w1"));
        action.moveToElement(bag).click().perform();
        Thread.sleep(2000);

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        action.moveToElement(addToCart).click().perform();
        Thread.sleep(2000);

        WebElement goToCart = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(7) > div > " +
                "div._fvroe._1yyhi.m389_6m_s.m7f5_6m_s.m7er_k4.m7er_k4.m7er_wn.mjru_ey_x.munh_0.munh_56_x.m3h2_56_x._e3a48_vlVgu > " +
                "div > div > div > div > div.m7er_k4.m7er_k4.m7er_wn.mpof_ki.myre_6m.myre_8v_s._e3a48_gZbN9.mryx_24 > a"));
        action.moveToElement(goToCart).click().perform();


//        driver.close();
    }
}
