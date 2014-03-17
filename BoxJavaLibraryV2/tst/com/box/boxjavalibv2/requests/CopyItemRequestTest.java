package com.box.boxjavalibv2.requests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.junit.Test;

import com.box.boxjavalibv2.BoxConfig;
import com.box.boxjavalibv2.dao.BoxResourceType;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxJSONException;
import com.box.boxjavalibv2.requests.requestobjects.BoxFileRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;

public class CopyItemRequestTest extends RequestTestBase {

    @Test
    public void uriTest() {
        Assert.assertEquals("/files/123/copy", CopyItemRequest.getUri("123", BoxResourceType.FILE));
        Assert.assertEquals("/folders/1234/copy", CopyItemRequest.getUri("1234", BoxResourceType.FOLDER));
    }

    @Test
    public void testFolderRequestWellFormed() throws BoxRestException, IllegalStateException, IOException, AuthFatalFailureException, BoxJSONException {
        testRequestIsWellFormed(BoxResourceType.FOLDER);
    }

    @Test
    public void testFileRequestWellFormed() throws BoxRestException, IllegalStateException, IOException, AuthFatalFailureException, BoxJSONException {
        testRequestIsWellFormed(BoxResourceType.FILE);
    }

    private void testRequestIsWellFormed(BoxResourceType type) throws BoxRestException, IllegalStateException, IOException, AuthFatalFailureException,
        BoxJSONException {
        String id = "testid123";
        String parentId = "testparentid456";
        String newName = "testnewname789";

        CopyItemRequest request = new CopyItemRequest(CONFIG, JSON_PARSER, id, BoxFileRequestObject.copyFileRequestObject(parentId).setName(newName), type);
        testRequestIsWellFormed(request, BoxConfig.getInstance().getApiUrlAuthority(),
            BoxConfig.getInstance().getApiUrlPath().concat(CopyItemRequest.getUri(id, type)), HttpStatus.SC_CREATED, RestMethod.POST);

        HttpEntity entity = request.getRequestEntity();
        Assert.assertTrue(entity instanceof StringEntity);
        assertEqualStringEntity(BoxFileRequestObject.copyFileRequestObject(parentId).setName(newName).getJSONEntity(), entity);

    }
}
