package pers.jianfeic.util;

import org.junit.jupiter.api.Test;

class RegexMatcherTest {

	@Test
	void testMatch() {
		String content = "<p class=\"commentsMana_sortTabs\"><span>共 394 条评论</span>", regex = RegexMatcher.GC_COMMENT;
		String res = RegexMatcher.match(content, regex);
		System.out.println(res);
	}

}
