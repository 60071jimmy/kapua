/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.kapua.commons.setting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractKapuaSettingTest {

    @Test
    public void shouldReadPathFromEnv() {
        // When
        String path = new TestSetting().property("PATH");

        // Then
        assertThat(path).isNotEmpty();
    }

    @Test
    public void shouldReadEnvUsingDotNotation() {
        // Given
        System.setProperty("FOO_BAR_BAZ", "qux");

        // When
        String path = new TestSetting().property("foo.bar.baz");

        // Then
        assertThat(path).isEqualTo("qux");
    }

    static class TestSetting extends AbstractKapuaSetting {

        String property(String key) {
            return config.getString(key);
        }

        protected TestSetting() {
            super("test.properties");
        }

    }

}
