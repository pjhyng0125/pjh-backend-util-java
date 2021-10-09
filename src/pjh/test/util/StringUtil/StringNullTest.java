package pjh.test.util.StringUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.StringUtil;

/**
 * 문자열 Null 확인 테스트
 */
class StringNullTest {
	final String STR = "문자열";

	@Test
	void stringNullTrueTest() {
		assertEquals(StringUtil.isEmptyTrim(null), false);
	}
	
	@Test
	void stringNullFalseTest() {
		assertEquals(StringUtil.isEmptyTrim(STR), false);
	}
}
