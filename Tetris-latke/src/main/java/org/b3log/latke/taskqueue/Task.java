/*
 * Copyright (c) 2009-2017, b3log.org & hacpai.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.latke.taskqueue;


import java.io.Serializable;
import org.b3log.latke.servlet.HTTPRequestMethod;


/**
 * Task.
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.3, Sep 20, 2012
 */
public final class Task implements Serializable {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    /**
     * URL.
     */
    private String url;

    /**
     * Name.
     */
    private String name;

    /**
     * HTTP method.
     */
    private HTTPRequestMethod requestMethod = HTTPRequestMethod.GET;

    /**
     * Payload.
     */
    private byte[] payload;

    /**
     * Gets the request method.
     *
     * @return request method of this task
     */
    public HTTPRequestMethod getRequestMethod() {
        return requestMethod;
    }

    /**
     * Sets the request method with the specified request method.
     *
     * @param requestMethod the specified request method
     */
    public void setRequestMethod(final HTTPRequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * Gets the payload ({@link HTTPRequestMethod#POST POST} data body).
     *
     * <p>
     * Certain HTTP methods ({@linkplain HTTPRequestMethod#GET GET}) will NOT have any payload, and this method will return
     * {@code null}. 
     * </p>
     *
     * @return payload
     */
    public byte[] getPayload() {
        return payload;
    }

    /**
     * Sets the payload with the specified payload.
     *
     * <p>
     * This method should NOT be called for certain HTTP methods (e.g. {@link HTTPRequestMethod#GET GET}). 
     * </p>
     *
     * @param payload the specified payload
     */
    public void setPayload(final byte[] payload) {
        this.payload = payload;
    }

    /**
     * Gets the URL of this task.
     *
     * @return URI of this task
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the URL with the specified URL.
     *
     * @param url the specified URL
     */
    public void setURL(final String url) {
        this.url = url;
    }

    /**
     * Gets the name of this task.
     *
     * @return name of this task
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name with the specified name.
     *
     * @param name the specified name
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder().append("url=").append(url).append(", name=").append(name).append(", requestMethod=").append(
            requestMethod);

        return stringBuilder.toString();
    }
}
