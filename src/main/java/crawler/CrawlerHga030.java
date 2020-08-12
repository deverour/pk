package crawler;

import jdk.nashorn.internal.runtime.options.Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.FileUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CrawlerHga030 {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        WebDriver.Options options = driver.manage();
        driver.get("http://www.hga030.com/");

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout();
        Thread.sleep(3000);
        String pageSource1 = driver.getPageSource();
        FileUtils.writeHTML(pageSource1,"登录.html");
        System.out.println("1.length>>>>"+pageSource1.length());
        driver.switchTo().frame("SI2_mem_index");
        //driver.switchTo().defaultContent();
        Thread.sleep(3000);

        String pageSource2 = driver.getPageSource();
        System.out.println("2.length>>>>"+pageSource2.length());

        WebElement username = driver.findElement(By.id("username"));

        Thread.sleep(1000);
        username.clear();
        Thread.sleep(1000);
        username.sendKeys("Accjkk666");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("passwords"));
        Thread.sleep(1000);
        password.sendKeys("zc134158");
        Thread.sleep(1000);

        WebElement do_login = driver.findElement(By.className("za_button"));
        do_login.click();
        System.out.println("登录中.......");

        Thread.sleep(10000);
        String pageSource3 = driver.getPageSource();
        System.out.println("3.length>>>>"+pageSource3.length());
        //driver.switchTo().defaultContent();
        driver.switchTo().frame("SI2_mem_index");
        Thread.sleep(5000);
        String pageSource4 = driver.getPageSource();
        System.out.println("4.length>>>>"+pageSource4.length());


        System.out.println("开始写入");

        FileUtils.writeHTML(pageSource2,"登录_转入框架.html");
        FileUtils.writeHTML(pageSource3,"登录成功.html");
        FileUtils.writeHTML(pageSource4,"登录成功_转入框架.html");

        WebElement body;
       /* System.out.println(body);
        System.out.println("TagName>>>>"+body.getTagName());
        System.out.println("wait:10");
*/
        try {
            body = driver.findElement(By.xpath("//div[@id=\"body_view\"]/iframe"));
            driver.switchTo().activeElement();
            driver.switchTo().frame(body);
            String bodyHtml = driver.getPageSource();
            System.out.println("bodyHtml.length>>>>"+bodyHtml.length());
            FileUtils.writeHTML(bodyHtml,"body.html");
            System.out.println("0body.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("0body.error");
            e.printStackTrace();
        }
        Thread.sleep(5000);
        try {
            //body = driver.findElement(By.xpath("//td[@id=\"top_tv\"]/iframe"));
            driver.switchTo().frame("1");
            String show_tv = driver.getPageSource();
            System.out.println("show_tv.length>>>>"+show_tv.length());
            FileUtils.writeHTML(show_tv,"show_tv.html");
            System.out.println("1show_tv.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("1show_tv.error");
            e.printStackTrace();
        }
        Thread.sleep(5000);
        try {
            //body = driver.findElement(By.xpath("//td[@id=\"top_tv\"]/iframe"));
            driver.switchTo().frame("body");
            String show_tv = driver.getPageSource();
            System.out.println("show_tv.length>>>>"+show_tv.length());
            FileUtils.writeHTML(show_tv,"show_tv.html");
            System.out.println("0body.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("0body.error");
            e.printStackTrace();
        }
        Thread.sleep(5000);
        try {
            driver.switchTo().frame("memOnline");
            String memOnline = driver.getPageSource();
            System.out.println("memOnline.length>>>>"+memOnline.length());
            FileUtils.writeHTML(memOnline,"memOnline.html");
            System.out.println("2memOnline.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("2memOnline.error");
            e.printStackTrace();
        }

        Thread.sleep(5000);
        try {
            driver.switchTo().frame("reloadPHP");
            String reloadPHP = driver.getPageSource();
            System.out.println("reloadPHP.length>>>>"+reloadPHP.length());
            FileUtils.writeHTML(reloadPHP,"reloadPHP.html");
            System.out.println("3reloadPHP.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("3reloadPHP.error");
            e.printStackTrace();
        }
        Thread.sleep(5000);
        try {
            driver.switchTo().frame("reloadPHP1");
            String reloadPHP1 = driver.getPageSource();
            System.out.println("reloadPHP1.length>>>>"+reloadPHP1.length());
            FileUtils.writeHTML(reloadPHP1,"reloadPHP1.html");
            System.out.println("4reloadPHP1.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("4reloadPHP1.error");
            e.printStackTrace();
        }
        Thread.sleep(5000);

        try {
            driver.switchTo().frame("mem_order");
            String mem_order = driver.getPageSource();
            System.out.println("mem_order.length>>>>"+mem_order.length());
            FileUtils.writeHTML(mem_order,"mem_order.html");
            System.out.println("5mem_order.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("5mem_order.error");
            e.printStackTrace();
        }

        try {
            driver.switchTo().frame(5);
            String mem_order = driver.getPageSource();
            System.out.println("5.length>>>>"+mem_order.length());
            FileUtils.writeHTML(mem_order,"5.html");
            System.out.println("5.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("5.error");
            e.printStackTrace();
        }

        try {
            driver.switchTo().frame(6);
            String mem_order = driver.getPageSource();
            System.out.println("6.length>>>>"+mem_order.length());
            FileUtils.writeHTML(mem_order,"6.html");
            System.out.println("6.ok");
            driver.switchTo().parentFrame();
        }catch (Exception e){
            System.out.println("6.error");
            e.printStackTrace();
        }


        Thread.sleep(5000);
        System.out.println("写入结束");

    }


}
