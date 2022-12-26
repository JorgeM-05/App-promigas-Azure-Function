package com.promigas;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.promigas.domain.dto.OpportunitiesAllByCountryDto;
import com.promigas.domain.dto.OpportunitiesDto;
import com.promigas.service.OpportunitiesByCountryService;
import com.promigas.service.OpportunitiesService;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */
    @FunctionName("get-list-opportunities")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        OpportunitiesService opportunitiesService = new OpportunitiesService();
        OpportunitiesDto opportunitiesDto = opportunitiesService.getDataAllOpportunities();
//        ResponseEntity<OpportunitiesDto> responseEntity = null;

        if (opportunitiesDto == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("query string is null").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body(opportunitiesDto).build();
        }
    }



    @FunctionName("/list-all-opp")
    public HttpResponseMessage listAllOpp(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        final String query = request.getQueryParameters().get("country");
        final String country = request.getBody().orElse(query);
        System.out.println("----> " + country);


        OpportunitiesAllByCountryDto opportunitiesAllByCountryDto = null;
        if (country == null) {

        } else {
            OpportunitiesByCountryService opportunities = new OpportunitiesByCountryService();
            opportunitiesAllByCountryDto = opportunities.getDataOpportunities(country);
        }

        if (opportunitiesAllByCountryDto == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("query string is null").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body(opportunitiesAllByCountryDto).build();
        }
    }


//    @FunctionName("/details-opportunities")
//    public HttpResponseMessage detailsOpportunities(
//            @HttpTrigger(
//                    name = "req",
//                    methods = {HttpMethod.GET},
//                    authLevel = AuthorizationLevel.ANONYMOUS)
//            HttpRequestMessage<Optional<Integer>> request,
//            final ExecutionContext context) {
//        final String query = request.getQueryParameters().get("country");
//        final Integer id = request.getBody().orElse(Integer.valueOf(query));
//        System.out.println("----> " + id);
//
//
//        OpportunitiesAllByCountryDto opportunitiesAllByCountryDto = null;
//        if (id == null) {
//
//        } else {
//            OpportunitiesByCountryService opportunities = new OpportunitiesByCountryService();
//            opportunitiesAllByCountryDto = opportunities.getDataOpportunities(country);
//        }
//
//        if (opportunitiesAllByCountryDto == null) {
//            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("query string is null").build();
//        } else {
//            return request.createResponseBuilder(HttpStatus.OK).body(opportunitiesAllByCountryDto).build();
//        }
//    }

}