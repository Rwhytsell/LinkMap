package spiderBot;

import java.util.*;


/* Created by Ryan Whytsell, project started on 5/4/16 for educational purposes only*/

public class Spider {

    
	 public void search(String url, String searchWord, int mxThreads, int MaxLinkDepth)
	  {
		 	System.out.println("Max threads set at " +mxThreads);
			System.out.println("Link depth set at " +MaxLinkDepth);
			System.out.println("Origin URL set to " +url);
			System.out.println("Keyword is " +searchWord);
			
	      while(this.pagesVisited.size() < MaxLinkDepth)
	      {
	          String currentUrl;
	          SpiderEgg egg = new SpiderEgg();
	          if(this.pagesToVisit.isEmpty())
	          {
	              currentUrl = url;
	              this.pagesVisited.add(url);
	          }
	          else
	          {
	              currentUrl = this.nextUrl();
	          }
	          egg.crawl(currentUrl);
	          
	          boolean success = egg.searchForWord(searchWord);
	          if(success)
	          {
	              System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
	              break;
	          }
	          this.pagesToVisit.addAll(egg.getLinks());
	      }
	      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
	  }
    
	 private String nextUrl()
	  {
	      String nextUrl;
	      do
	      {
	          nextUrl = this.pagesToVisit.remove(0);
	      } while(this.pagesVisited.contains(nextUrl));
	      this.pagesVisited.add(nextUrl);
	      return nextUrl;
	  }
	 
   
    
    
    //Variable declaration									
	private Set<String> pagesVisited = new HashSet<String>();   		//Pages that have already been visited/crawled
    private List<String> pagesToVisit = new LinkedList<String>();		//Origin URL or URLs resulting from previous crawled pages
    //End variable declaration
}
