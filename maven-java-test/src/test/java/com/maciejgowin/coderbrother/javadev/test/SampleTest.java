package com.maciejgowin.coderbrother.javadev.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest {

    @Test
    public void ensureValue() {
        assertThat(Main.upperCase("test")).isEqualTo("TEST");
    }
}
