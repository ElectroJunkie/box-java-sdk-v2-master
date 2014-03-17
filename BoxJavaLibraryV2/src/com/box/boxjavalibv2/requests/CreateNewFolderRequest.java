package com.box.boxjavalibv2.requests;

import org.apache.http.HttpStatus;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxFolderRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

/**
 * Request to create a new folder.
 */
public class CreateNewFolderRequest extends DefaultBoxRequest {

    private static final String URI = "/folders";

    /**
     * Constructor.
     * 
     * @param config
     *            configv
     * @param requestObject
     *            request object
     * @throws BoxRestException
     *             exception
     */
    public CreateNewFolderRequest(final IBoxConfig config, final IBoxJSONParser parser, BoxFolderRequestObject requestObject) throws BoxRestException {
        super(config, parser, getUri(), RestMethod.POST, requestObject);
        setExpectedResponseCode(HttpStatus.SC_CREATED);
    }

    /**
     * Get uri.
     * 
     * @return uri
     */
    public static String getUri() {
        return URI;
    }
}
