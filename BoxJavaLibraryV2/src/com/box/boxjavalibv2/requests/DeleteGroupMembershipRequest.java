package com.box.boxjavalibv2.requests;

import org.apache.http.HttpStatus;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

public class DeleteGroupMembershipRequest extends DefaultBoxRequest {

    private static String URI = "/group_memberships/%s";

    public DeleteGroupMembershipRequest(final IBoxConfig config, final IBoxJSONParser parser, final String groupId, BoxDefaultRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(groupId), RestMethod.DELETE, requestObject);
        setExpectedResponseCode(HttpStatus.SC_NO_CONTENT);
    }

    public static String getUri(final String membershipId) {
        return String.format(URI, membershipId);
    }
}
