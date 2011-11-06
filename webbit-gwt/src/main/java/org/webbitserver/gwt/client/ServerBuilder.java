/**
 *  Copyright 2011 Colin Alworth
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.webbitserver.gwt.client;

import org.webbitserver.gwt.shared.Server;

/**
 * 
 * @todo setProtocol, setPath, setHost methods
 * 
 */
public interface ServerBuilder<S extends Server<S, ?>> {
	/**
	 * Sets the full url, including protocol, host, port, and path for the next server connection
	 * to be started. If called with a non-null value, will override the other setters in this
	 * builder.
	 * 
	 * @param url
	 * @return
	 */
	ServerBuilder<S> setUrl(String url);

	/**
	 * Sets the path for the next server to be started. Defaults to the RemoteServiceRelativePath
	 * annotation value for the Server interface, if any.
	 * 
	 * @param path
	 * @return
	 */
	ServerBuilder<S> setPath(String path);

	/**
	 * Sets the port of the next server instance to be started. Defaults to the port the current 
	 * page loaded from.
	 * 
	 * @param port
	 * @return
	 */
	ServerBuilder<S> setPort(int port);

	/**
	 * Sets the hostname for the next server to be started. Defaults to the hostname the current
	 * page loaded from.
	 * 
	 * @param hostname
	 * @return
	 */
	ServerBuilder<S> setHostname(String hostname);

	/**
	 * Sets the protocol ("ws" or "wss") to connect with. Defaults to wss if the current page
	 * loaded using https, and ws otherwise.
	 * 
	 * @param protocol
	 * @return
	 */
	ServerBuilder<S> setProtocol(String protocol);

	/**
	 * Creates a new instance of the specified server type, starts, and returns it. May
	 * be called more than once to create additional connections, such as after the first
	 * is closed.
	 * 
	 * @return
	 */
	S start();
}
