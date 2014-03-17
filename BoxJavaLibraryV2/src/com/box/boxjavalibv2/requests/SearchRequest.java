package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

/**
 * Request to get the items inside a folder. These items can be files, sub-folders, weblinks, and etc.
 */
public class SearchRequest extends DefaultBoxRequest {

    private static final String URI = "/search";

    /**
     * Constructor.
     * 
     * @param config
     *            config
     * @param parser
     *            json parser
     * @param searchQuery
     *            search query
     * @param requestObject
     *            request object
     * @throws BoxRestException
     *             exception
     */
    public SearchRequest(final IBoxConfig config, final IBoxJSONParser parser, final String searchQuery, BoxDefaultRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, URI, RestMethod.GET, requestObject);
        addQueryParam("query", searchQuery);
    }
}
