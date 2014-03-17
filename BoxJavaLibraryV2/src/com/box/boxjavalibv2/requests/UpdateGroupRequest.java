package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

public class UpdateGroupRequest extends DefaultBoxRequest {

    private static final String URI = "/groups/%s";

    public UpdateGroupRequest(final IBoxConfig config, final IBoxJSONParser parser, final String groupId, final BoxDefaultRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(groupId), RestMethod.PUT, requestObject);
    }

    /**
     * Get uri.
     * 
     * @return uri
     */
    public static String getUri(String id) {
        return String.format(URI, id);
    }
}