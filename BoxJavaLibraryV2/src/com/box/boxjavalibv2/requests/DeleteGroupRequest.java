package com.box.boxjavalibv2.requests;

import org.apache.http.HttpStatus;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

public class DeleteGroupRequest extends DefaultBoxRequest {

    private static String URI = "/groups/%s";

    public DeleteGroupRequest(final IBoxConfig config, final IBoxJSONParser parser, final String groupId, BoxDefaultRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(groupId), RestMethod.DELETE, requestObject);
        setExpectedResponseCode(HttpStatus.SC_NO_CONTENT);
    }

    /**
     * Get uri.
     * 
     * @param commentId
     *            id of the comment
     * @return uri
     */
    public static String getUri(final String groupId) {
        return String.format(URI, groupId);
    }
}
