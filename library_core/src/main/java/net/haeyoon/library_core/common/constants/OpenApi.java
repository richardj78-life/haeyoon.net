package net.haeyoon.library_core.common.constants;

public final class OpenApi {
    private static final String API_URL = "https://www.nl.go.kr/seoji/SearchApi.do?";
    private static final String API_KEY_PARAM = "cert_key=3246fe2d363f81179b1368f334e40ea974b9994210b94bfbed1fc17258f4f8c5";
    private static final String RESULT_STYLE_PARAM = "&result_style=json";
    private static final String PAGE_PARAM = "&page_no=1&page_size=10";
    private static final String SEARCH_PARAM = "&isbn=";

    public static final String BookUrl =
            API_URL + API_KEY_PARAM + RESULT_STYLE_PARAM + PAGE_PARAM + SEARCH_PARAM;
}
