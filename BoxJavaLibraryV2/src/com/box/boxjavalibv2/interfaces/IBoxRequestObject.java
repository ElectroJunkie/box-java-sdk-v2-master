package com.box.boxjavalibv2.interfaces;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;

import com.box.restclientv2.exceptions.BoxRestException;

/**
 * Interface for objects to be put into api requests.
 */
public interface IBoxRequestObject {

    /**
     * Get entity, which will be put into request body.
     * 
     * @return HttpEntity.
     * @throws BoxRestException
     * @throws UnsupportedEncodingException
     */
    public HttpEntity getEntity() throws BoxRestException;

    /**
     * Get fields, these fields (Please check "Fields" part in <a href="http://developers.box.com/docs/">developer doc</a> will end up as fields query parameter
     * in the url.
     * 
     * @return
     */
    public List<String> getFields();

    /**
     * Query parameters. Which eventually will go into url.
     * 
     * @return query parameters.
     */
    public Map<String, String> getQueryParams();

    /**
     * Headers.
     * 
     * @return headers
     */
    public Map<String, String> getHeaders();
}
