package com.naat.bontu.api.bontu.utils;

/**
 *
 * @author David
 */
public class Constants {
    public static final String APP_PREFERENCES = "appPreferences";
    public static final String EMPTY = "";
    public static final String DEMO_TOKEN = "iesjioewrwoiruwieriweyriueywiwrwiyreiuywuiryweiuywreihy";
    public static final String DEMO_USER_FULL_NAME = "Juan Carlos Perez Lopez";
    public static final String DEMO_CLIENT_NUMBER = "100117";
    private static final String PROTOCOL = "https://";
    public static final String BASE_URL = PROTOCOL + "xaaai51gna.execute-api.us-east-1.amazonaws.com/";
    public static final String PRICE_FORMAT = "$%,.2f";
    public static final String DOCUMENT_AVAILABLE="document_available";
    public static final String PENDING_DOCUMENTS="pending_documents";
    public static final String STATUS_TICKET_TURN="Turno";
    public static final String FIRST_TIME="first_time";
    public class Preferences {
        public static final String APP_MODE = "appMode";
        public static final String TOKEN = "token";
        public static final String USER_FULL_NAME = "fullName";
        public static final String CLIENT_NUMBER = "clientNumber";
        public static final String CLIENT_NUMBER_SAFE = "clientNumberSafe";
    }

    public class HTTPHeaders {
        public static final String AUTHORIZATION = "Authorization";
        public static final String API_KEY="x-api-key";
        public static final String API_KEY_VALUE="v3foX6e4Xo7KDbHVoLyIZ2ODbhHD78NNjybACMD1";
    }

    public class CreditTypes {
        public static final String TYPE_1 = "REVOLTING";
        public static final String TYPE_2 = "FIXED_TERM";
    }


}