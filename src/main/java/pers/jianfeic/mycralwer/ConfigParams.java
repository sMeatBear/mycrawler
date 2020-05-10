package pers.jianfeic.mycralwer;

public class ConfigParams {
	// TODO: storage path and basic info
	public static final String storageFolder = "data/crawler4j/gcores/";
	public static final int politenessDelay = 800;
	public static final int maxDepthOfCrawling = 4;
	public static final int maxPagesToFetch = 1000;
	public static final String[] seeds = new String[] {"https://www.gcores.com/radios/"};
	public static final String restrictDomain = "https://www.gcores.com/radios/";
	public static final int numOfCrawlers = 6;
	public static final String ACCEPT_FILES = ".*(\\.html)$";
	
	public static final String GC_OUTPUT_NAME = ConfigParams.storageFolder + "result.csv";
}
