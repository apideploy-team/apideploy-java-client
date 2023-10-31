package com.kalman03.apideploy.swagger2.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;

import com.kalman03.apideploy.core.builder.ApiBuilderService;
import com.kalman03.apideploy.core.constants.ApiBuilderType;
import com.kalman03.apideploy.core.domain.ApibuilderParam;
import com.kalman03.apideploy.core.domain.ApideployData;

import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * @author kalman03
 * @since 2023-08-20
 */
@Order(8)
@Component
@ConditionalOnBean(value = Swagger2Controller.class)
public class Swagger2WebMVCApiBuilder implements ApiBuilderService<ApideployData> {

	@Autowired
	private Swagger2Controller swagger2Controller;
	@Autowired
	private Docket docket;

	@Override
	public ApideployData getApiObjects(ApibuilderParam apibuilderParam) {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setMethod("GET");
		request.setRequestURI("/");
		ResponseEntity<Json> responseEntity = swagger2Controller.getDocumentation(docket.getGroupName(), request);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			String openAPI = responseEntity.getBody().value();
			ApideployData apiSyncData = new ApideployData();
			apiSyncData.setOpenAPI(openAPI);
			apiSyncData.setApiBuilderType(ApiBuilderType.SWAGGER2_WEBMVC);
			return apiSyncData;
		}
		throw new RuntimeException(
				"Swagger API document build error with response code:" + responseEntity.getStatusCode().value());
	}

}
