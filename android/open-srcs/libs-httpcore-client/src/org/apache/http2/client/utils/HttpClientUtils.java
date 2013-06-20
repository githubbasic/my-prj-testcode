/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.http2.client.utils;

import java.io.IOException;

import org.apache.http2.HttpEntity;
import org.apache.http2.HttpResponse;
import org.apache.http2.client.HttpClient;
import org.apache.http2.util.EntityUtils;

/**
 * Static helpers for dealing with {@link HttpResponse}s and {@link HttpClient}s.
 * 
 * @since 4.2
 */
public class HttpClientUtils {

    private HttpClientUtils() {
    }

    /**
     * Unconditionally close a response.
     * <p>
     * Example Code:
     * 
     * <pre>
     * HttpResponse httpResponse = null;
     * try {
     *     httpResponse = httpClient.execute(httpGet);
     * } catch (Exception e) {
     *     // error handling
     * } finally {
     *     HttpClientUtils.closeQuietly(httpResponse);
     * }
     * </pre>
     * 
     * @param response
     *            the HttpResponse to release resources, may be null or already
     *            closed.
     * 
     * @since 4.2
     */
    public static void closeQuietly(final HttpResponse response) {
        if (response != null) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    EntityUtils.consume(entity);
                } catch (final IOException ex) {
                }
            }
        }
    }

    /**
     * Unconditionally close a httpClient. Shuts down the underlying connection
     * manager and releases the resources.
     * <p>
     * Example Code:
     * 
     * <pre>
     * HttpClient httpClient = null;
     * try {
     *   httpClient = new DefaultHttpClient(...);
     * } catch (Exception e) {
     *   // error handling
     * } finally {
     *   HttpClientUtils.closeQuietly(httpClient);
     * }
     * </pre>
     * 
     * @param httpClient
     *            the HttpClient to close, may be null or already closed.
     * @since 4.2
     */
    public static void closeQuietly(final HttpClient httpClient) {
        if (httpClient != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

}