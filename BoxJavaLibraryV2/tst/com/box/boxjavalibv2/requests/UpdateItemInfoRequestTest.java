package com.box.boxjavalibv2.requests;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import com.box.boxjavalibv2.BoxConfig;
import com.box.boxjavalibv2.dao.BoxResourceType;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxJSONException;
import com.box.boxjavalibv2.requests.requestobjects.BoxFileRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;

public class UpdateItemInfoRequestTest extends RequestTestBase {

    @Test
    public void testUri() {
        Assert.assertEquals("/files/123", UpdateItemInfoRequest.getUri("123", BoxResourceType.FILE));
        Assert.assertEquals("/folders/123", UpdateItemInfoRequest.getUri("123", BoxResourceType.FOLDER));
    }

    @Test
    public void testFolderRequestIsWellFormed() throws IllegalStateException, BoxRestException, IOException, AuthFatalFailureException, BoxJSONException {
        testRequestIsWellFormed(BoxResourceType.FOLDER);
    }

    @Test
    public void testFileRequestIsWellFormed() throws IllegalStateException, BoxRestException, IOException, AuthFatalFailureException, BoxJSONException {
        testRequestIsWellFormed(BoxResourceType.FILE);
    }

    public void testRequestIsWellFormed(BoxResourceType type) throws BoxRestException, IllegalStateException, IOException, AuthFatalFailureException,
        BoxJSONException {
        String id = "testid123";
        String parentId = "testparentid456";

        UpdateItemInfoRequest request = new UpdateItemInfoRequest(CONFIG, JSON_PARSER, id, BoxFileRequestObject.updateFileRequestObject().setParent(parentId),
            type);
        testRequestIsWellFormed(request, BoxConfig.getInstance().getApiUrlAuthority(),
            BoxConfig.getInstance().getApiUrlPath().concat(UpdateItemInfoRequest.getUri(id, type)), HttpStatus.SC_OK, RestMethod.PUT);

        HttpEntity entity = request.getRequestEntity();
        Assert.assertTrue(entity instanceof StringEntity);
        assertEqualStringEntity(BoxFileRequestObject.updateFileRequestObject().setParent(parentId).getJSONEntity(), entity);
    }
}