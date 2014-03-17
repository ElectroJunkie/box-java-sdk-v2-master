package com.box.boxjavalibv2.requests;

import java.io.IOException;
import java.util.Map;

import junit.framework.Assert;

import org.apache.http.HttpStatus;
import org.junit.Test;

import com.box.boxjavalibv2.BoxConfig;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.requests.requestobjects.BoxCollabRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;

public class GetAllCollaborationsRequestTest extends RequestTestBase {

    @Test
    public void testUri() {
        Assert.assertEquals("/collaborations", GetAllCollaborationsRequest.getUri());
    }

    @Test
    public void testRequestIsWellFormed() throws BoxRestException, IllegalStateException, IOException, AuthFatalFailureException {
        String status = "teststatus789";

        GetAllCollaborationsRequest request = new GetAllCollaborationsRequest(CONFIG, JSON_PARSER,
            BoxCollabRequestObject.getAllCollaborationsRequestObject(status));
        testRequestIsWellFormed(request, BoxConfig.getInstance().getApiUrlAuthority(),
            BoxConfig.getInstance().getApiUrlPath().concat(GetAllCollaborationsRequest.getUri()), HttpStatus.SC_OK, RestMethod.GET);

        Map<String, String> queries = request.getQueryParams();
        Assert.assertEquals(status, queries.get("status"));
    }
}
