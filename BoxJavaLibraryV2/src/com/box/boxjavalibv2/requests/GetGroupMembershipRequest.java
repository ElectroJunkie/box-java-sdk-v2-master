package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

public class GetGroupMembershipRequest extends DefaultBoxRequest {

    private static final String URI = "/group_memberships/%s";

    public GetGroupMembershipRequest(final IBoxConfig config, final IBoxJSONParser parser, final String membershipId, final BoxDefaultRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(membershipId), RestMethod.GET, requestObject);
    }

    public static String getUri(final String id) {
        return String.format(URI, id);
    }
}