package parse;

import org.jsoup.Jsoup;
import utils.FileUtils;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class Jsoup_Pinnacle {

    public static void main(String[] args) throws IOException {
        String html = FileUtils.readHTML("Pinnacle.html");
        int startndex = html.indexOf("<div id=\"oddspage\"");
        int endindex = html.indexOf("<div id=\"outrightpage\"");
        html = html.substring(startndex,endindex);
        System.out.println(html.length());
        //System.out.println(html);
        //Document document=Jsoup.parse(new File("src\\main\\resources\\Pinnacle2.html"),"UTF-8");
        Document document= Jsoup.parse(html);//
        long l1 = System.currentTimeMillis();
        System.out.println("开始解析"+l1);
        for(Element el:document.select("div.double-line")){

            String text1 = el.select("div.league").text();
            String text2 = el.select("td.col-time").text();
            String text3 = el.select("td.col-name").text();
            String text4 = el.select("td.col-1x2.col-1x2-0").text();
            String text5 = el.select("td.col-hdp.hdp-0").text();
            String text6 = el.select("td.col-ou.ou-0").text();
            String text7 = el.select("td.col-1x2.ht.col-1x2-1").text();
            String text8 = el.select("td.col-hdp.ht.hdp-1").text();
            String text9 = el.select("td.col-ou.ht.ou-1").text();
            System.out.println("1"+text1);
            System.out.println("2"+text2);
            System.out.println("3"+text3);
            System.out.println("4"+text4);
            System.out.println("5"+text5);
            System.out.println("6"+text6);
            System.out.println("7"+text7);
            System.out.println("8"+text8);
            System.out.println("9"+text9);



        }
        long l2 = System.currentTimeMillis();
        System.out.println("解析结束"+l2);
        System.out.println("耗时"+(l2-l1));
    }
}
