package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

public class GetAllGroupsRequest extends DefaultBoxRequest {

    private static final String URI = "/groups";

    public GetAllGroupsRequest(final IBoxConfig config, final IBoxJSONParser parser, BoxDefaultRequestObject requestObject) throws BoxRestException {
        super(config, parser, getUri(), RestMethod.GET, requestObject);
    }

    public static String getUri() {
        return URI;
    }
}