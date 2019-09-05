package com.marketlogicsoftware.cs.surveyservice;

import com.marketlogicsoftware.cs.surveyservice.survey.SurveyService;
import com.marketlogicsoftware.cs.surveyservice.survey.models.Survey;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SurveyServiceTest {
	@TestConfiguration
	static class SurveyServiceContextConfiguration {

		@Bean
		public SurveyService employeeService() {
			return new SurveyService();
		}
	}

	@Autowired
	private SurveyService surveyService;

	@Test
	public void testCreateSurvey() {
		Assert.assertNotEquals(null, surveyService.createSurvey(new Survey()));
	}

}
