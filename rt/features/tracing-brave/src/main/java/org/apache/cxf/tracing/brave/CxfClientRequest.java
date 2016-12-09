/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.tracing.brave;

import java.net.URI;

import com.github.kristofa.brave.http.HttpClientRequest;
import org.apache.cxf.message.Message;

public class CxfClientRequest implements HttpClientRequest {

    private ParsedMessage message;

    public CxfClientRequest(Message message) {
        this.message = new ParsedMessage(message);
    }

    @Override
    public URI getUri() {
        return message.getUri();
    }

    @Override
    public String getHttpMethod() {
        return message.getHttpMethod();
    }

    @Override
    public void addHeader(String header, String value) {
        message.addHeader(header, value);
    }
    
}