package pers.jianfeic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
	public static final String GC_COMMENT = "(?<=<p class=\"commentsMana_sortTabs\"><span>)(.*)(?=<\\/span>)";
	public static final String GC_TITLE = "(?<=<title>)(.*)(?=<\\/title>)";
	
	public static String match(final String content, final String regex) {
		String res = "";
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(content);
		// return first
		if (matcher.find()) {
			res = matcher.group();
		}
		
		return res;
	}
}
