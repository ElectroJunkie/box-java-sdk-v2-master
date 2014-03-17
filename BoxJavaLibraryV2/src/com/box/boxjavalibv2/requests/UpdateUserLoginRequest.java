package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxUserRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

/**
 * Request to convert one of the user's confirmed email aliases into the user's primary login.
 */
public class UpdateUserLoginRequest extends DefaultBoxRequest {

    private static final String URI = "/users/%s";

    /**
     * Constructor.
     * 
     * @param config
     *            config
     * @param parser
     *            json parser
     * @param userId
     *            id of user
     * @param requestObject
     *            request object
     * @throws BoxRestException
     *             exception
     */
    public UpdateUserLoginRequest(final IBoxConfig config, final IBoxJSONParser parser, final String userId, final BoxUserRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(userId), RestMethod.PUT, requestObject);
    }

    /**
     * Get uri.
     * 
     * @param userId
     *            id of user.
     * @return uri
     */
    public static String getUri(final String userId) {
        return String.format(URI, userId);
    }
}
