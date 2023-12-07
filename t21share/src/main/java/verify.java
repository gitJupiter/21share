import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class verify {

    @Test
    public void hello() {

        WebDriver share= new ChromeDriver();
        share.manage().window().maximize();
        share.get("https://21shares.com/");
        String sh= share.getTitle();
        System.out.println(sh);
        if(sh.equalsIgnoreCase("21Shares - Crypto made easy.")) {
            System.out.println("verified page");
        }else {
            System.out.println("Wrong page");
        }
        share.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
        share.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/button[2]/span")).click(); //cookies

        share.findElement(By.xpath("//*[@id=\"__next\"]/main/section/div/div/div/div[1]/div/a[2]/span")).click();
        share.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

        Set<String> win = share.getWindowHandles();
        java.util.Iterator<String> it = win.iterator();


        String Home=it.next();
        share.switchTo().window(Home);
        String con=it.next();
        share.switchTo().window(con);

        share.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/button[2]/span")).click(); //cookies

        try
        {String Act =share.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[2]/div/div[2]/div/span[2]")).getText(); // From Coding

            String Exp = "+1 646 370 6016";
            assertTrue(Act.contains(Exp));
        }catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
        System.out.println("Assert Test Passed\n");

        share.close();
        share.quit();
    }

}




