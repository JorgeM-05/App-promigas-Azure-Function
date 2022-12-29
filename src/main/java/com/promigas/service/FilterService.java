package com.promigas.service;

import com.promigas.domain.dto.request.FilterDtoRequest;
import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.domain.dto.response.ListOpportunitiesDto;
import com.promigas.domain.dto.response.ListOpportunitiesFilter;
import com.promigas.domain.enums.ConstantsEnum;
import com.promigas.persistence.SecretAdapter;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.repository.*;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FilterService {
    private FilterRepository repository = new FilterRepositoryImp();


    public ListOpportunitiesFilter getDataOpportunities(FilterDtoRequest filterDtoRequest)throws NotFoundException {
        ListOpportunitiesFilter opp = new ListOpportunitiesFilter();

        SecretPort secretPort = new SecretAdapter();
        ConnectionInfo connectionInfo = secretPort.querySecretConnection(ConstantsEnum.SECRET_SQL_SERVER.getValue());

        List<OpportunitiesEntity> opportunitiesEntity = repository.findByIdCountry(filterDtoRequest,connectionInfo);

        opp.setListOportunitiesByCountries(mapToOpportunities(opportunitiesEntity));

        return opp;
    }
    public List<ListOpportunitiesDto> mapToOpportunities(List<OpportunitiesEntity> oppotunities){
        List<ListOpportunitiesDto> listOp = new ArrayList<ListOpportunitiesDto>();

        if(oppotunities.size()>0){
            for(OpportunitiesEntity listOpp : oppotunities){
                ListOpportunitiesDto listOppDto = new ListOpportunitiesDto();

                listOppDto.setId_opportunities(listOpp.getUnique_id());
                listOppDto.setOpportunities(listOpp.getProjecTitle());

                listOp.add(listOppDto);
            }
        }
        return listOp;
    }

}
