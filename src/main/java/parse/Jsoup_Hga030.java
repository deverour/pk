package parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.FileUtils;

import java.io.IOException;

public class Jsoup_Hga030 {

    public static void main(String[] args) throws IOException {
        String html = FileUtils.readHTML("hga030.html");

        Document document= Jsoup.parse(html);//
        long l1 = System.currentTimeMillis();
        System.out.println("开始解析"+l1);
        Elements elements = document.select("div.showtable_normal").select("table.bet_game_table");
        for(Element el:elements){

            String text1 = el.select("tr.bet_game_tr_top").text();
            String text2 = el.select("tr.col-bet_game_tr_other").text();
            String text3 = el.select("tr.bet_game_tr_other-name").text();

            System.out.println("1"+text1);
            System.out.println("2"+text2);
            System.out.println("3"+text3);



        }
        long l2 = System.currentTimeMillis();
        System.out.println("解析结束"+l2);
        System.out.println("耗时"+(l2-l1));


    }
}
