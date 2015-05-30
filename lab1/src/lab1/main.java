package lab1;
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.safety.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.function.Consumer;

public class main {	
	public static void main(String[] args){
		System.out.println("Hello world!");
		
		String url = "https://afisha.yandex.ru"; // args[0];
		

        Elements links = null;
        Elements media = null;
        Elements imports = null;
		
		Document doc;
		try {
			PrintWriter writer = new PrintWriter("log.txt", "UTF-8");
			
			doc = Jsoup.connect(url).get();
			
			Elements contents = doc.getElementsByClass("content");
			
			for(int i = 0; i < (contents.toArray()).length; i++ ){
				links = contents.select("a[href]");
			//	writer.println(links);

			}
			
			System.out.println(links.get(9).attr("abs:href"));
			getlocation(links.get(9), writer);
			writer.close();

		} catch (IOException e) {
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
		
	}
	
	
	public static void getlocation(Element href, PrintWriter w) throws IOException{
		Document doc = Jsoup.connect(href.attr("abs:href")).get();
		Elements eventInfo = doc.getElementsByClass("b-premiere__info");
		Elements listLocation = doc.getElementsByClass("chooser_data");
		w.println(eventInfo);
		w.println("___");w.println("___");w.println("___");w.println("___");w.println("___");
		w.println(listLocation);
	}
}
