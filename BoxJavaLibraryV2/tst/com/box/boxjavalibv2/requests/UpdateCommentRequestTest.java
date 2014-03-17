package com.box.boxjavalibv2.requests;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import com.box.boxjavalibv2.BoxConfig;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxJSONException;
import com.box.boxjavalibv2.requests.requestobjects.BoxCommentRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;

public class UpdateCommentRequestTest extends RequestTestBase {

    @Test
    public void testUri() {
        Assert.assertEquals("/comments/123", UpdateCommentRequest.getUri("123"));
    }

    @Test
    public void testRequestIsWellFormed() throws BoxRestException, IllegalStateException, IOException, AuthFatalFailureException, BoxJSONException {
        String id = "testid123";
        String message = "testmessage456";

        UpdateCommentRequest request = new UpdateCommentRequest(CONFIG, JSON_PARSER, id, BoxCommentRequestObject.updateCommentRequestObject(message));
        testRequestIsWellFormed(request, BoxConfig.getInstance().getApiUrlAuthority(),
            BoxConfig.getInstance().getApiUrlPath().concat(UpdateCommentRequest.getUri(id)), HttpStatus.SC_OK, RestMethod.PUT);

        HttpEntity entity = request.getRequestEntity();
        Assert.assertTrue(entity instanceof StringEntity);
        assertEqualStringEntity(BoxCommentRequestObject.updateCommentRequestObject(message).getJSONEntity(), entity);
    }
}