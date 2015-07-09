/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.pilhuhn.jfs2015.runtime;

import de.pilhuhn.jfs2015.annotations.Hello;

/**
 * A Sample :)
 *
 * @author Heiko W. Rupp
 */
public class UseHello {
    @Hello("Java Forum")
    public void greet() { }

    @Hello()
    public void greet2() { }

    @de.pilhuhn.jfs2015.annotations.Deprecated(seit = "0.9", alternative = "UseHello.greet")
    public void greetMe() {
        System.out.println("Hello JFS");
    }

}
