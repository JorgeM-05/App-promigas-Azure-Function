package com.promigas;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.promigas.domain.dto.request.FilterDtoRequest;
import com.promigas.domain.dto.response.ListOpportunitiesFilter;
import com.promigas.domain.dto.response.OpportunitiesAllByCountryDto;
import com.promigas.domain.dto.response.OpportunitiesDto;
import com.promigas.domain.dto.response.OpportunitiesFilterDTO;
import com.promigas.domain.dto.response.detailOpportunitiesDTO.OpportunityDetailsDTO;
import com.promigas.domain.exception.PromigasException;
import com.promigas.service.DetailsOpportunityService;
import com.promigas.service.FilterService;
import com.promigas.service.OpportunitiesByCountryService;
import com.promigas.service.OpportunitiesService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/get-list-opportunities". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/get-list-opportunities
     * 2. curl "{your host}/api/get-list-opportunities"
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
        if (opportunitiesDto == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("query string is null").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body(opportunitiesDto).build();
        }
    }



    /**
     * This function listens at endpoint "/api/list-all-opp". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/list-all-opp
     * 2. curl "{your host}/api/list-all-opp?country={id}"
     */
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


    /**
     * This function listens at endpoint "/api/list-all-opp". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/list-all-opp
     * 2. curl "{your host}/api/list-all-opp?country={id}"
     */
    @FunctionName("/details-opportunities")
    public HttpResponseMessage detailsOpportunities(
            @HttpTrigger(
                    name = "detailsOpportunities",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        final String query = request.getQueryParameters().get("id-opportunity");
        final String id = request.getBody().orElse(query);


        OpportunityDetailsDTO opportunityDetailsDTO = null;
        if (id == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Error: verify query params ... id :: "+id).build();
        } else {
            DetailsOpportunityService detailsOpportunityService = new DetailsOpportunityService();
            opportunityDetailsDTO = detailsOpportunityService.getDataOpprt(Integer.parseInt(id));
            if(opportunityDetailsDTO == null){
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("query id is null").build();

            }else {
                return request.createResponseBuilder(HttpStatus.OK).body(opportunityDetailsDTO).build();
            }
        }
    }

    @FunctionName("/filter")
    public HttpResponseMessage filter(
            @HttpTrigger(
                    name = "filter",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<FilterDtoRequest>> request,
            final ExecutionContext context) {
        FilterDtoRequest body = null;
        ListOpportunitiesFilter filterDTO = new ListOpportunitiesFilter();

        body = request.getBody().orElseGet(FilterDtoRequest::new);
        FilterService filterService = new FilterService();
        filterDTO = filterService.getDataOpportunities(body);

        OpportunityDetailsDTO opportunityDetailsDTO = null;
        if(request == null){
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Error: verify body request ... object :: "+request).build();
        }
        else if (filterDTO == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("query string is null").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body(filterDTO).build();
        }
    }

}
