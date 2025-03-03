package org.pmtool;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.pmtool.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,json:build/reports/cucumber/cucumber.json")
public class CucumberTest {
    // Esta clase no necesita métodos, solo sirve como punto de entrada para Cucumber
} 
