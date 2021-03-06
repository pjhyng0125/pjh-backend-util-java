package pjh.cmn.util;

public class StringUtil {
	/**
	 * 인스턴스화 방지
	 */
	private StringUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * 공백제거한 String 값이 Empty 인지 확인
	 * @param String
	 * @return boolean
	 */
	public static boolean isEmptyTrim(String val) {
		return TypeUtil.isNull(val) ? true : val.trim().isEmpty();
	}
	
	/**
	 * null 체크하여 "" 반환
	 * @param String
	 * @return String
	 */
	public static String nvl(String val) {
		return isEmptyTrim(val) ? "" : val;
	}
	
	/**
	 * 금액 단위 버림
	 * @param String am 금액
	 * @param String cutStart 단위 버림 시작점 (뒤에서부터 count)
	 * @return String
	 * 
	 */
	public static String cutUnit(String am, int cutStart) {
		String cutAm = "0";
		if (cutStart < 0) {
			cutAm = am;
		} else if (TypeUtil.isNotNull(am)) {
			int len = am.length();
			int printLen = len - cutStart;
			if (printLen > 0) {
				cutAm = am.substring(0, printLen);
			}
		}
		return cutAm;
	}
}