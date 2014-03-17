package com.box.boxjavalibv2.requests.requestobjects;

public class BoxEventRequestObject extends BoxItemRequestObject {

    /**
     * Stream position of "now",See http://developers.box.com/docs/#events. Currently it's only supported for regular events, not enterprise events(admin_logs).
     */
    public static final int STREAM_POSITION_NOW = -1;

    public static final String STREAM_TYPE_ALL = "all";
    public static final String STREAM_TYPE_CHANGES = "changes";
    public static final String STREAM_TYPE_SYNC = "sync";

    private BoxEventRequestObject() {
    }

    /**
     * Construct a new events object for fetching the event stream.
     * 
     * @param streamPosition
     *            Stream position. See http://developers.box.com/docs/#events for how to set this. To set this to "now", use
     *            BoxEventRequestObject.STREAM_POSITION_NOW.Don't use STREAM_POSITION_NOW if you are requesting for enterprise
     *            events(admin_logs),STREAM_POSITION_NOW is only supported for regular events.
     * @return BoxEventRequestObject.
     */
    public static BoxEventRequestObject getEventsRequestObject(final long streamPosition) {
        BoxEventRequestObject req = new BoxEventRequestObject();
        if (streamPosition == STREAM_POSITION_NOW) {
            req.addQueryParam("stream_position", "now");
        }
        else {
            req.addQueryParam("stream_position", String.valueOf(streamPosition));
        }
        return req;
    }

    /**
     * Set the stream_type.
     * 
     * @param streamType
     *            Use STREAM_TYPE_ALL (default), STREAM_TYPE_CHANGES or STREAM_TYPE_SYNC.
     * @return BoxEventRequestObject.
     */
    public BoxEventRequestObject setStreamType(String streamType) {
        addQueryParam("stream_type", streamType);
        return this;
    }

    /**
     * Set the limit for the number of events that will be returned.
     * 
     * @param limit
     *            Default is 100.
     * @return BoxEventRequestObject.
     */
    public BoxEventRequestObject setLimit(int limit) {
        addQueryParam("limit", String.valueOf(limit));
        return this;
    }

}
