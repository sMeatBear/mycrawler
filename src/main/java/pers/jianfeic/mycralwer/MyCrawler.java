package pers.jianfeic.mycralwer;

import static pers.jianfeic.mycralwer.ConfigParams.restrictDomain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import pers.jianfeic.util.RegexMatcher;
import pers.jianfeic.util.csvio.CSVResultWrite;

/**
 * My crawler extends from crawler4j
 *
 */
public class MyCrawler extends WebCrawler {
	// private final static Pattern FILTERS = Pattern.compile(ConfigParams.ACCEPT_FILES);
	private static int idOfPage = 0;
	
	/**
     * Creates a new crawler instance.
     *
     * @param numSeenImages This is just an example to demonstrate how you can pass objects to crawlers. In this
     * example, we pass an AtomicInteger to all crawlers and they increment it whenever they see a url which points
     * to an image.
     */
	/*
	 * public BasicCrawler(AtomicInteger numSeenImages) { this.numSeenImages =
	 * numSeenImages; }
	 */
    
	/**
	 * It's like an intercepter
	 * 
	 * This method receives two parameters. The first parameter is the page in which
	 * we have discovered this new url and the second parameter is the new url. You
	 * should implement this function to specify whether the given url should be
	 * crawled or not (based on your crawling logic). In this example, we are
	 * instructing the crawler to ignore urls that have css, js, git, ... extensions
	 * and to only accept urls that start with "https://www.ics.uci.edu/". In this
	 * case, we didn't need the referringPage parameter to make the decision.
	 */
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		// no filters type files and only within the designated domain
		// return !FILTERS.matcher(href).matches() && href.startsWith(restrictDomain);
		return href.startsWith(restrictDomain);
	}

	/**
	 * This function is called when a page is fetched and ready to be processed by
	 * your program.
	 */
	@Override
	public void visit(Page page) {
		System.out.println("Now it's visiting No. " + idOfPage++ + " page.");
		String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();
            // Storage the html file
            System.out.println(page.getContentType());
            if (page.getContentType().startsWith("text/html")) {
//            	writeHTML(html, ConfigParams.storageFolder + "/" + htmlParseData.getTitle() + idOfPage + ".html");
            	String title = RegexMatcher.match(html, RegexMatcher.GC_TITLE),
            		   comments = RegexMatcher.match(html, RegexMatcher.GC_COMMENT);
            	if (!title.equals("") || !comments.equals("")) {
            		writeHTML(html, "data/crawler4j/gcores/" + idOfPage + ".html");
            		CSVResultWrite.appendCSV(ConfigParams.GC_OUTPUT_NAME, new String[] {title, comments});
            	}
            }
            System.out.println("Number of outgoing links: " + links.size());
            System.out.println("===============================================");
        }
		
//		int docid = page.getWebURL().getDocid();
//        String url = page.getWebURL().getURL();
//        String domain = page.getWebURL().getDomain();
//        String path = page.getWebURL().getPath();
//        String subDomain = page.getWebURL().getSubDomain();
//        String parentUrl = page.getWebURL().getParentUrl();
//        String anchor = page.getWebURL().getAnchor();

//        logger.debug("Docid: {}", docid);
//        logger.info("URL: {}", url);
//        logger.debug("Domain: '{}'", domain);
//        logger.debug("Sub-domain: '{}'", subDomain);
//        logger.debug("Path: '{}'", path);
//        logger.debug("Parent page: {}", parentUrl);
//        logger.debug("Anchor text: {}", anchor);

        /*
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            logger.debug("Text length: {}", text.length());
            logger.debug("Html length: {}", html.length());
            logger.debug("Number of outgoing links: {}", links.size());
        }

        Header[] responseHeaders = page.getFetchResponseHeaders();
        if (responseHeaders != null) {
            logger.debug("Response headers:");
            for (Header header : responseHeaders) {
                logger.debug("\t{}: {}", header.getName(), header.getValue());
            }
        }
         */
//        logger.debug("=============");
	}
	
	public void writeHTML(String content, String path) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(path));
			System.out.println("Start writing: " + path);
			bw.write(content);
			bw.close();
			System.out.println("Success saved: " + path);
		} catch (IOException e) {
			System.err.println("Writing failed: " + path);
		}
	}
}
