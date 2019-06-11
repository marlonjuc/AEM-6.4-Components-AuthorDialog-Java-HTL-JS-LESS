package edu.devry.dvu_marketing.core.utils;

import java.net.URI;
import java.net.URISyntaxException;

public class LinkUtil {
    /**
     * Formats the link to add .html in cases where it doesn't already exist.
     *
     * @param linkStr
     *            The link to be formatted.
     * @return String value of formatted link.
     */
    public static String formatLink(String linkStr) {
        String link = "";
        if (linkStr == null || linkStr.length() < 2) {
            return link;
        }
        // if link doesn't end with .html or .pdf and is an internal link
        if (!linkStr.endsWith(".html") && !linkStr.endsWith(".pdf") && isInternal(linkStr)) {
            link = linkStr.concat(".html");
        } else {
            // link either ends with .html, .pdf, or isn't internal
            link = linkStr;
        }
        return link;
    }

    public static String appendUrlParameters(String uri, String[] parameters) {
        if (parameters == null) {
            return uri;
        }
        for (String param : parameters) {
            uri = appendUriParameter(uri, param);
        }
        return uri;
    }

    /**
     * Checks to see if link is an AEM link.
     *
     * @param linkStr
     *            The link being checked.
     * @return boolean value of whether link is internal.
     */
    public static boolean isInternal(final String linkStr) {
        return linkStr.startsWith("/content/") && !linkStr.startsWith("/content/dam");
    }

    public static String appendUriParameter(String uri, String appendQuery) {
        try {
            URI oldUri = new URI(uri);

            String newQuery = oldUri.getQuery();
            if (newQuery == null) {
                newQuery = appendQuery;
            } else {
                newQuery += "&" + appendQuery;
            }

            URI newUri;
            newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(), oldUri.getPath(), newQuery,
                    oldUri.getFragment());
            return newUri.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uri;
    }
}
