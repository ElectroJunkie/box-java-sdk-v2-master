package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

/**
 * Request to get a shared item. This requires SharedItemAuth.
 */
public class GetSharedItemRequest extends DefaultBoxRequest {

    private static final String URI = "/shared_items";

    /**
     * Constructor.
     * 
     * @param config
     *            config
     * @param parser
     *            json parser
     * @param requestObject
     *            request object
     * @throws BoxRestException
     *             exception
     */
    public GetSharedItemRequest(final IBoxConfig config, final IBoxJSONParser parser, final BoxDefaultRequestObject requestObject) throws BoxRestException {
        super(config, parser, getUri(), RestMethod.GET, requestObject);
    }

    /**
     * Get uri.
     * 
     * @return uri
     */
    public static String getUri() {
        return URI;
    }
}
