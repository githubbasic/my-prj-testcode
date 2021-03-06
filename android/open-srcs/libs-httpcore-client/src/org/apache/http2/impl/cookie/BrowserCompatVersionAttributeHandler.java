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

package org.apache.http2.impl.cookie;

import org.apache.http2.annotation.Immutable;
import org.apache.http2.cookie.MalformedCookieException;
import org.apache.http2.cookie.SetCookie;

/**
 * <tt>"Version"</tt> cookie attribute handler for BrowserCompat cookie spec.
 *
 * @since 4.3
 */
@Immutable
class BrowserCompatVersionAttributeHandler extends
		AbstractCookieAttributeHandler {

	public BrowserCompatVersionAttributeHandler() {
		super();
	}

	/**
	 * Parse cookie version attribute.
	 */
	public void parse(final SetCookie cookie, final String value)
			throws MalformedCookieException {
		if (cookie == null) {
			throw new IllegalArgumentException("Cookie may not be null");
		}
		if (value == null) {
			throw new MalformedCookieException("Missing value for version attribute");
		}
		int version = 0;
		try {
			version = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// Just ignore invalid versions
		}
		cookie.setVersion(version);
	}

}
