package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

/**
 * Request to get a comment.
 */
public class GetCommentRequest extends DefaultBoxRequest {

    private static final String URI = "/comments/%s";

    /**
     * Constructor.
     * 
     * @param config
     *            config
     * @param parser
     *            json parser
     * @param commentId
     *            id of the comment to be fetched
     * @param requestObject
     *            request object
     * @throws BoxRestException
     *             exception
     */
    public GetCommentRequest(final IBoxConfig config, final IBoxJSONParser parser, String commentId, BoxDefaultRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(commentId), RestMethod.GET, requestObject);
    }

    /**
     * Get uri.
     * 
     * @param commentId
     *            id of the comment to be fetched
     * @return uri
     */
    public static String getUri(String commentId) {
        return String.format(URI, commentId);
    }
}
