/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.redhat.xpaas.qe;

import javax.inject.Named;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.fabric8.annotations.ServiceName;
import io.fabric8.annotations.Endpoint;
import javax.enterprise.inject.Instance;

@Singleton
@Named("counterBean")
public class SomeBean {

    @Inject
    @Endpoint
    @ServiceName("foo-service")
    Instance<List<String>> fooEndpoints;

    public String someMethod(String body) {
        return "Endpoints: " + fooEndpoints.stream().collect(Collectors.joining(", "));
    }
}
