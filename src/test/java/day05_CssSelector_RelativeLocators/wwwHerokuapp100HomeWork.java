package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class wwwHerokuapp100HomeWork {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//            https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

//            Add Element butonuna basin 100 kez basınız

        WebElement addEl = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i=1; i<101; i++){
            addEl.click();
        }

//            Delete butonuna 90 kez basınız

        List<WebElement> deleteList = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("deleteList size : "+deleteList.size());
        Thread.sleep(2000);

        for (int i=1; i<91; i++){
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        }

        Thread.sleep(1000);
        List<WebElement> deleteList2 = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("deleteList2 size : "+deleteList2.size());

//            Ve 90 kez basıldığını doğrulayınız

        if (deleteList.size()-deleteList2.size()==90){
            System.out.println("Delete butonuna 90 kez basildi");
        } else {
            System.out.println("Delete butonuna "+(deleteList.size()- deleteList2.size())+" kez basildi");
        }
// sayfayi kapat
        driver.close();
    }
}
