package com.box.boxjavalibv2.requests;

import org.apache.http.HttpStatus;

import com.box.boxjavalibv2.interfaces.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxFileUploadRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.interfaces.IBoxConfig;
import com.box.restclientv2.requests.DefaultBoxRequest;

/**
 * Request to upload a new version of a file.
 */
public class UploadNewVersionFileRequest extends DefaultBoxRequest {

    private static final String URI = "/files/%s/content";

    /**
     * Constructor.
     * 
     * @param config
     *            config
     * @param parser
     *            json parser
     * @param fileId
     *            id of the file to be updated
     * @param BoxFileUploadRequestObject
     *            requestObject
     * @throws BoxRestException
     *             exception
     */
    public UploadNewVersionFileRequest(final IBoxConfig config, final IBoxJSONParser parser, final String fileId, BoxFileUploadRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(fileId), RestMethod.POST, requestObject);
        this.setExpectedResponseCode(HttpStatus.SC_CREATED);
    }

    /**
     * Get uri.
     * 
     * @param fileId
     *            id of the file
     * @return uri
     */
    public static String getUri(final String fileId) {
        return String.format(URI, fileId);
    }

    @Override
    public String getScheme() {
        return getConfig().getUploadUrlScheme();
    }

    @Override
    public String getAuthority() {
        return getConfig().getUploadUrlAuthority();
    }

    @Override
    public String getApiUrlPath() {
        return getConfig().getUploadUrlPath();
    }
}
