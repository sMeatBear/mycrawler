package pers.jianfeic.mycralwer;

public class ConfigParams {
	// TODO: storage path and basic info
	public static final String storageFolder = "data/crawler4j/yonmin_shen";
	public static final int politenessDelay = 1000;
	public static final int maxDepthOfCrawling = 3;
	public static final int maxPagesToFetch = 1000;
	public static final String[] seeds = new String[] {"http://www-scf.usc.edu/~shin630/Youngmin/"};
	public static final String restrictDomain = "http://www-scf.usc.edu/";
	public static final int numOfCrawlers = 3;
}
