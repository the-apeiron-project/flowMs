package org.apeiron.flow.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.apeiron.flow.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@IntegrationTest
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
