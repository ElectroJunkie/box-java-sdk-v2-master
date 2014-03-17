package com.box.boxjavalibv2.request.requestobjects;

import junit.framework.Assert;

import org.junit.Test;

import com.box.boxjavalibv2.jsonentities.MapJSONStringEntity;
import com.box.boxjavalibv2.requests.requestobjects.BoxOAuthRequestObject;
import com.box.restclientv2.exceptions.BoxRestException;

public class BoxOAuthRequestObjectTest {

    private static final String CLIENT_ID = "testclientId123";
    private static final String CLIENT_SECRET = "testClientSecret324324";

    @Test
    public void testRevokeRequestObject() throws BoxRestException {
        String token = "testtoken1212";
        BoxOAuthRequestObject obj = BoxOAuthRequestObject.revokeOAuthRequestObject(token, CLIENT_ID, CLIENT_SECRET);
        MapJSONStringEntity jEntity = obj.getJSONEntity();
        Assert.assertEquals(CLIENT_ID, jEntity.get("client_id"));
        Assert.assertEquals(CLIENT_SECRET, jEntity.get("client_secret"));
        Assert.assertEquals(token, jEntity.get("token"));
    }

    @Test
    public void testCreateRequestObject() throws BoxRestException {
        String code = "testcode";
        String url = "testurl";
        BoxOAuthRequestObject obj = BoxOAuthRequestObject.createOAuthRequestObject(code, CLIENT_ID, CLIENT_SECRET, url);
        MapJSONStringEntity jEntity = obj.getJSONEntity();
        Assert.assertEquals(CLIENT_ID, jEntity.get("client_id"));
        Assert.assertEquals(CLIENT_SECRET, jEntity.get("client_secret"));
        Assert.assertEquals(code, jEntity.get("code"));
        Assert.assertEquals(url, jEntity.get("redirect_url"));
    }

    @Test
    public void testRefreshRequestObject() throws BoxRestException {
        String token = "testrefreshtoken";
        BoxOAuthRequestObject obj = BoxOAuthRequestObject.refreshOAuthRequestObject(token, CLIENT_ID, CLIENT_SECRET);
        MapJSONStringEntity jEntity = obj.getJSONEntity();
        Assert.assertEquals(CLIENT_ID, jEntity.get("client_id"));
        Assert.assertEquals(CLIENT_SECRET, jEntity.get("client_secret"));
        Assert.assertEquals(token, jEntity.get("refresh_token"));
    }
}
