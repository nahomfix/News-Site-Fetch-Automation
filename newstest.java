import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.util.List;

public class newstest {

    public static void main(String []args){
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bbc.com");

//        driver.get("file:///C:/Users/Nahom/Downloads/BBC%20-%20Homepage.html");

        Grabber grabber = new Grabber();

        List<WebElement> headlines = driver.findElements(By.className("media__title"));

        for (WebElement i : headlines){
            String headline = i.findElement(By.tagName("a")).getText();
            grabber.insertHeadlines(headline);
//            System.out.println(headline);


//            i.click();
//            String story = driver.findElement(By.className("story-body__inner")).findElement(By.tagName("p")).getText();
//            System.out.println(story);
        }

        List<WebElement> stories = driver.findElements(By.className("media__summary"));

        for (WebElement j: stories){
            String story = j.getText();
            grabber.insertStory(story);

        }

//        System.out.println(grabber.getHeadlines().size());
//        System.out.println(grabber.getStories().size());

        grabber.displaySite();







    }
}
