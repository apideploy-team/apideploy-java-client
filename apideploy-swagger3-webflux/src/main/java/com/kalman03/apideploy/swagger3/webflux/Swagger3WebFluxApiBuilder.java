package com.kalman03.apideploy.swagger3.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.stereotype.Component;

import com.kalman03.apideploy.core.builder.ApiBuilderService;
import com.kalman03.apideploy.core.constants.ApiBuilderType;
import com.kalman03.apideploy.core.domain.ApibuilderParam;
import com.kalman03.apideploy.core.domain.ApideployData;

import springfox.documentation.oas.web.OpenApiControllerWebFlux;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author kalman03
 * @since 2023-08-20
 */
@Order(7)
@Component
public class Swagger3WebFluxApiBuilder implements ApiBuilderService<ApideployData> {

	@Autowired
	private OpenApiControllerWebFlux openApiControllerWebFlux;
	@Autowired
	private Docket docket;

	@Override
	public ApideployData getApiObjects(ApibuilderParam apibuilderParam) {
		MockServerHttpRequest request = MockServerHttpRequest.get("/", new Object[] {}).build();
		ResponseEntity<Json> responseEntity = openApiControllerWebFlux.getDocumentation(docket.getGroupName(), request);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			String openAPI = responseEntity.getBody().value();
			ApideployData apiSyncData = new ApideployData();
			apiSyncData.setOpenAPI(openAPI);
			apiSyncData.setApiBuilderType(ApiBuilderType.SWAGGER3_WEBFLUX);
			return apiSyncData;
		}
		throw new RuntimeException(
				"Swagger API document build error with response code:" + responseEntity.getStatusCode().value());
	}

}
