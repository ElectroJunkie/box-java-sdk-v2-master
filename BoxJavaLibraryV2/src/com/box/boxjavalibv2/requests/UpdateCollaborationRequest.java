package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxCollabRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

/**
 * Request to edit an existing collaboration.
 */
public class UpdateCollaborationRequest extends DefaultBoxRequest {

    private static final String URI = "/collaboration/%s";

    /**
     * Constructor.
     * 
     * @param config
     *            config
     * @param parser
     *            json parser
     * @param id
     *            id of the collaboration
     * @param requestObject
     *            request object
     * @throws BoxRestException
     *             exception
     */
    public UpdateCollaborationRequest(final IBoxConfig config, final IBoxJSONParser parser, String id, BoxCollabRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(id), RestMethod.PUT, requestObject);
    }

    /**
     * Get uri.
     * 
     * @param id
     *            uri
     * @return
     */
    public static String getUri(final String id) {
        return String.format(URI, id);
    }
}
