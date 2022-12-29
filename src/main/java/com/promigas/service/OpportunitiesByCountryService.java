package com.promigas.service;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.domain.dto.response.ListOportunitiesByCountry;
import com.promigas.domain.dto.response.OpportunitiesAllByCountryDto;
import com.promigas.domain.enums.ConstantsEnum;
import com.promigas.persistence.SecretAdapter;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.repository.OpportunitiesRepository;
import com.promigas.persistence.repository.SecretPort;
import com.promigas.persistence.repository.opportunitiesByContryImp;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class OpportunitiesByCountryService {

    private OpportunitiesRepository repository = new opportunitiesByContryImp();

    public OpportunitiesAllByCountryDto getDataOpportunities(String country)throws NotFoundException {
        OpportunitiesAllByCountryDto opp = new OpportunitiesAllByCountryDto();

        SecretPort secretPort = new SecretAdapter();
        ConnectionInfo connectionInfo = secretPort.querySecretConnection(ConstantsEnum.SECRET_SQL_SERVER.getValue());
        List<OpportunitiesEntity> opportunitiesEntity = repository.findByIdCountry(country,connectionInfo);

        opp.setId_country(mapToIdcountry(opportunitiesEntity));
        opp.setCountry(mapTocountry(opportunitiesEntity));
        opp.setListOportunitiesByCountries(mapToOpportunitiesAllDto(opportunitiesEntity));
        return opp;
    }

    public List<ListOportunitiesByCountry> mapToOpportunitiesAllDto(List<OpportunitiesEntity> oppotunities){
        List<ListOportunitiesByCountry> listOp = new ArrayList<ListOportunitiesByCountry>();

        if(oppotunities.size()>0){
            for(OpportunitiesEntity listOpp : oppotunities){
                ListOportunitiesByCountry listOppDto = new ListOportunitiesByCountry();

                listOppDto.setId_opportunities(listOpp.getUnique_id());
                listOppDto.setOpportunities(listOpp.getProjecTitle());

                listOp.add(listOppDto);
            }
        }
        return listOp;
    }

    public String mapTocountry(List<OpportunitiesEntity> oppotunities){
        String country = "";
        if(oppotunities.size()>0) {
            for (OpportunitiesEntity listOpp : oppotunities) {
                if(listOpp!=null){
                    country = listOpp.getIdCountry().getNameContry();
                    continue;
                }
            }
        }
        return country;
    }
    public int mapToIdcountry(List<OpportunitiesEntity> oppotunities){
        int id = 0;
        if(oppotunities.size()>0) {
            for (OpportunitiesEntity listOpp : oppotunities) {
                if(listOpp!=null){
                    id = listOpp.getIdCountry().getUnique_id();
                    continue;
                }
            }
        }
        return id;
    }
}
