package com.wavefront.dto;

import junit.framework.TestCase;
import org.junit.Test;
import wavefront.report.Annotation;
import wavefront.report.ReportLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class LogTest {
    @Test
    public void testToString_NoAnnotations() {

        Log log1 = new Log(new ReportLog(1234567L, "oops", "myApp", "myService", "myHost", "myLevel", "myException", new ArrayList<>()));
        String expected = "{\"timestamp\":1234567, \"text\":\"oops\", \"source\":\"myHost\", \"application\":\"myApp\"," +
                " \"service\":\"myService\", \"log_level\":\"myLevel\", \"error_name\":\"myException\"}";
        assertEquals(expected, log1.toString());
    }

    @Test
    public void testToString_WithAnnotations() {

        Log log1 = new Log(new ReportLog(1234567L, "oops", "myApp", "myService", "myHost", "myLevel", "myException", Collections.singletonList(
                new Annotation("key1", "value1")
        )));

        String expected = "{\"key1\":\"value1\", \"timestamp\":1234567, \"text\":\"oops\", \"source\":\"myHost\", \"application\":\"myApp\", \"service\":\"myService\", \"log_level\":\"myLevel\", \"error_name\":\"myException\"}";
        assertEquals(expected, log1.toString());
    }
}