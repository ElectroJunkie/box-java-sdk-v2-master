package com.box.boxjavalibv2.request.requestobjects;

import junit.framework.Assert;

import org.junit.Test;

import com.box.boxjavalibv2.dao.BoxGroup;
import com.box.boxjavalibv2.dao.BoxGroupMembership;
import com.box.boxjavalibv2.dao.BoxUser;
import com.box.boxjavalibv2.jsonentities.MapJSONStringEntity;
import com.box.boxjavalibv2.requests.requestobjects.BoxGroupRequestObject;

public class BoxGroupsRequestObjectTest {

    @Test
    public void testCreateGroupRequestObject() {
        String name = "testname";
        BoxGroupRequestObject obj = BoxGroupRequestObject.createGroupRequestObject(name);
        Assert.assertEquals(name, obj.get(BoxGroup.FIELD_NAME));
    }

    @Test
    public void testUpdateGroupRequestObject() {
        String name = "testname";
        BoxGroupRequestObject obj = BoxGroupRequestObject.updateGroupRequestObject(name);
        Assert.assertEquals(name, obj.get(BoxGroup.FIELD_NAME));
    }

    @Test
    public void testAddMembershipRequest() {
        String groupId = "testgroupid";
        String userId = "testuserid";
        String role = "testrole";
        BoxGroupRequestObject obj = BoxGroupRequestObject.addMembershipRequest(groupId, userId, role);
        Object groupObj = obj.get(BoxGroupMembership.FIELD_GROUP);
        Assert.assertTrue(groupObj instanceof MapJSONStringEntity);
        MapJSONStringEntity groupEntity = (MapJSONStringEntity) groupObj;
        Assert.assertEquals(groupId, groupEntity.get(BoxGroup.FIELD_ID));

        Object userObj = obj.get(BoxGroupMembership.FIELD_USER);
        Assert.assertTrue(userObj instanceof MapJSONStringEntity);
        MapJSONStringEntity userEntity = (MapJSONStringEntity) userObj;
        Assert.assertEquals(userId, userEntity.get(BoxUser.FIELD_ID));

        Assert.assertEquals(role, obj.get(BoxGroupMembership.FIELD_ROLE));
    }

    @Test
    public void testUpdateMembershipRequest() {
        String role = "testrole";
        BoxGroupRequestObject obj = BoxGroupRequestObject.updateMembershipRequest(role);

        Assert.assertEquals(role, obj.get(BoxGroupMembership.FIELD_ROLE));
    }
}
