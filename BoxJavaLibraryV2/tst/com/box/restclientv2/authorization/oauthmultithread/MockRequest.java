package com.box.restclientv2.authorization.oauthmultithread;

import com.box.boxjavalibv2.BoxConfig;
import com.box.boxjavalibv2.jsonparsing.BoxJSONParser;
import com.box.boxjavalibv2.jsonparsing.BoxResourceHub;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.requests.DefaultBoxRequest;

public class MockRequest extends DefaultBoxRequest {

    public MockRequest() throws BoxRestException {
        super(BoxConfig.getInstance(), new BoxJSONParser(new BoxResourceHub()), "uri", RestMethod.GET, null);
    }

}
