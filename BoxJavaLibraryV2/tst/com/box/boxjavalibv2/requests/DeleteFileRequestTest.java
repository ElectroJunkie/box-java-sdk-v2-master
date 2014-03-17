package com.box.boxjavalibv2.requests;

import junit.framework.Assert;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.junit.Test;

import com.box.boxjavalibv2.BoxConfig;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.requests.requestobjects.BoxFileRequestObject;
import com.box.boxjavalibv2.utils.Constants;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;

public class DeleteFileRequestTest extends RequestTestBase {

    @Test
    public void testUri() {
        Assert.assertEquals("/files/123", DeleteFileRequest.getUri("123"));
    }

    @Test
    public void testRequestIsWellFormed() throws BoxRestException, AuthFatalFailureException {
        String id = "testid123";
        String sha1 = "testsha1456";

        DeleteFileRequest request = new DeleteFileRequest(CONFIG, JSON_PARSER, id, (BoxFileRequestObject) BoxFileRequestObject.deleteFileRequestObject()
            .setIfMatch(sha1));
        testRequestIsWellFormed(request, BoxConfig.getInstance().getApiUrlAuthority(),
            BoxConfig.getInstance().getApiUrlPath().concat(DeleteFileRequest.getUri(id)), HttpStatus.SC_NO_CONTENT, RestMethod.DELETE);

        Header header = request.getRawRequest().getFirstHeader(Constants.IF_MATCH);
        Assert.assertNotNull(header);
        Assert.assertEquals(sha1, header.getValue());

    }
}
