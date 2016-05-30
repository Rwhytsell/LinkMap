package spiderBot;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderEgg {
	//USER_AGENT is to make the webserver think that the spider is a vivaldi browser
    private static final String USER_AGENT ="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 "
    		+ "(KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36 Vivaldi/1.1.453.59";
    
    
    private List<String> links = new LinkedList<String>();
    
    public boolean crawl(String url)
    {
    	try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            if(connection.response().statusCode() == 200) // 200 status code means HTTP request is good.
            	
            {
                System.out.println("\n**Visiting** Received web page at " + url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href"));
            }
            if(getLinks().size() != 0){
                LinkMapDB.addNode(url,getLinks());
            }
            return true;
        }
        catch(IOException ioe)
        {
        	System.err.println("HTTP request failed");	// HTTP request failed
            System.err.println(ioe.getMessage());
            return false;
        }
    }
    


    public List<String> getLinks()
    {
        return this.links;
    }
}
