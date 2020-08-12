package crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.FileUtils;

import java.io.IOException;

public class CrawlerHga030_httpUnit {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebClient wc = new WebClient();
        wc.setJavaScriptTimeout(5000);
        wc.getOptions().setUseInsecureSSL(true);//接受任何主机连接 无论是否有有效证书
        wc.getOptions().setJavaScriptEnabled(true);//设置支持javascript脚本
        wc.getOptions().setCssEnabled(false);//禁用css支持
        wc.getOptions().setThrowExceptionOnScriptError(false);//js运行错误时不抛出异常
        wc.getOptions().setTimeout(100000);//设置连接超时时间
        wc.getOptions().setDoNotTrackEnabled(false);

        String url = "https://www.baidu.com/";

        Page page = wc.getPage(url);

        System.out.println(page.getWebResponse());
    }

    @Test
    public void test() {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX

        HtmlPage page = null;
        try {
            page = webClient.getPage("http://www.hga030.com/");//尝试加载上面图片例子给出的网页
        } catch (Exception e) {
           // e.printStackTrace();
        }finally {
            webClient.close();
        }
        HtmlPage currentPage = (HtmlPage)webClient.getWebWindowByName("SI2_mem_index").getEnclosedPage();

        HtmlElement descifr = page.getElementByName("SI2_mem_index");
        webClient.waitForBackgroundJavaScript(5000);//异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束
        String pageXml = currentPage.asXml();//直接将加载完成的页面转换成xml格式的字符串
        System.out.println(pageXml);
    }
}
