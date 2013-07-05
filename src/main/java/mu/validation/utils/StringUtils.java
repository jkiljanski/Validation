package mu.validation.utils;

public class StringUtils {

	private static final String ARG_INDICATOR = "\\{\\}";

	private static final String SQL_LIKE = "%";

	public static String interpolate(String template, Object... args) {
		if (args != null) {
			for (Object arg : args) {
				template.replaceFirst(ARG_INDICATOR, toString(arg));
				//template = replaceOnce(template, ARG_INDICATOR, toString(format(arg)));
			}
		}

		return template;
	}

	private static String toString(Object arg) {
		return arg != null ? arg.toString() : "null";
	}

	public static String wrapForSqlLikeEnd(Object str) {
		return str + SQL_LIKE;
	}

	public static String wrapForSqlLikeBoth(Object str) {
		return SQL_LIKE + str + SQL_LIKE;
	}

	public static void removeSuffix(StringBuilder sb, String suffix) {
		if (sb.toString().endsWith(suffix)) {
			sb.delete(sb.length() - suffix.length(), sb.length());
		}
	}

}
