package pers.jianfeic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
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
