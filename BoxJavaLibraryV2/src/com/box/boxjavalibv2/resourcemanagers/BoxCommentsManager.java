package com.box.boxjavalibv2.resourcemanagers;

import java.util.ArrayList;
import java.util.List;

import com.box.boxjavalibv2.dao.BoxCollection;
import com.box.boxjavalibv2.dao.BoxComment;
import com.box.boxjavalibv2.dao.BoxResourceType;
import com.box.boxjavalibv2.dao.BoxTypedObject;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxServerException;
import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.interfaces.IBoxResourceHub;
import com.box.boxjavalibv2.requests.CreateCommentRequest;
import com.box.boxjavalibv2.requests.DeleteCommentRequest;
import com.box.boxjavalibv2.requests.GetCommentRequest;
import com.box.boxjavalibv2.requests.UpdateCommentRequest;
import com.box.boxjavalibv2.requests.requestobjects.BoxCommentRequestObject;
import com.box.boxjavalibv2.requests.requestobjects.BoxDefaultRequestObject;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.interfaces.IBoxRESTClient;
import com.box.restclientv2.interfaces.IBoxRequestAuth;

/**
 * Use this class to execute requests <b>synchronously</b> against the Box REST API(V2), comments endpints. Full details about the Box API can be found at <a
 * href="http://developers.box.com/docs">http://developers.box.com/docs</a> . You must have an OpenBox application with a valid API key to use the Box API. All
 * methods in this class are executed in the invoking thread, and therefore are NOT safe to execute in the UI thread of your application. You should only use
 * this class if you already have worker threads or AsyncTasks that you want to incorporate the Box API into.
 */
public final class BoxCommentsManager extends BoxResourceManager {

    /**
     * Constructor.
     * 
     * @param config
     *            Config
     * @param resourceHub
     *            IResourceHub
     * @param parser
     *            json parser
     * @param auth
     *            auth for api calls
     * @param restClient
     *            REST client to make api calls.
     */
    public BoxCommentsManager(IBoxConfig config, final IBoxResourceHub resourceHub, final IBoxJSONParser parser, final IBoxRequestAuth auth,
        final IBoxRESTClient restClient) {
        super(config, resourceHub, parser, auth, restClient);
    }

    /**
     * Add a comment to an item.
     * 
     * @param requestObject
     *            comment request object.
     * @throws BoxRestException
     *             exception
     * @throws BoxServerException
     *             exception
     * @throws AuthFatalFailureException
     *             exception indicating authentication totally failed
     */
    public BoxComment addComment(final BoxCommentRequestObject requestObject) throws BoxRestException, BoxServerException, AuthFatalFailureException {
        CreateCommentRequest request = new CreateCommentRequest(getConfig(), getJSONParser(), requestObject);
        return (BoxComment) getResponseAndParseAndTryCast(request, BoxResourceType.COMMENT, getJSONParser());
    }

    /**
     * Get a comment, given a comment id.
     * 
     * @param commentId
     *            id of the comment
     * @param requestObject
     *            object that goes into request.
     * @return comment
     * @throws BoxRestException
     *             exception
     * @throws BoxServerException
     *             exception
     * @throws AuthFatalFailureException
     *             exception indicating authentication totally failed
     */
    public BoxComment getComment(final String commentId, BoxDefaultRequestObject requestObject) throws BoxRestException, BoxServerException,
        AuthFatalFailureException {
        GetCommentRequest request = new GetCommentRequest(getConfig(), getJSONParser(), commentId, requestObject);
        return (BoxComment) getResponseAndParseAndTryCast(request, BoxResourceType.COMMENT, getJSONParser());
    }

    /**
     * Update a comment.
     * 
     * @param commentId
     *            id of the comment
     * @param requestObject
     *            comment request object.s
     * @return comment
     * @throws BoxRestException
     *             exception
     * @throws BoxServerException
     *             exception
     * @throws AuthFatalFailureException
     *             exception indicating authentication totally failed
     */
    public BoxComment updateComment(final String commentId, final BoxCommentRequestObject requestObject) throws BoxRestException, BoxServerException,
        AuthFatalFailureException {
        UpdateCommentRequest request = new UpdateCommentRequest(getConfig(), getJSONParser(), commentId, requestObject);
        return (BoxComment) getResponseAndParseAndTryCast(request, BoxResourceType.COMMENT, getJSONParser());
    }

    /**
     * Delete a comment.
     * 
     * @param commentId
     *            id of the comment
     * @param requestObject
     *            object that goes into request.
     * @throws BoxRestException
     *             exception
     * @throws BoxServerException
     *             exception
     * @throws AuthFatalFailureException
     *             exception indicating authentication totally failed
     */
    public void deleteComment(final String commentId, BoxDefaultRequestObject requestObject) throws BoxRestException, BoxServerException,
        AuthFatalFailureException {
        DeleteCommentRequest request = new DeleteCommentRequest(getConfig(), getJSONParser(), commentId, requestObject);
        executeRequestWithNoResponseBody(request);
    }

    /**
     * Get comments from a collection.
     * 
     * @param collection
     *            collection
     * @return comments
     */
    public static List<BoxComment> getComments(BoxCollection collection) {
        List<BoxComment> comments = new ArrayList<BoxComment>();
        List<BoxTypedObject> list = collection.getEntries();
        for (BoxTypedObject object : list) {
            if (object instanceof BoxComment) {
                comments.add((BoxComment) object);
            }
        }
        return comments;
    }
}
