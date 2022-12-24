package com.promigas.service;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.domain.dto.OpportunitiesAll;
import com.promigas.domain.dto.OpportunitiesDto;
import com.promigas.domain.enums.ConstantsEnum;
import com.promigas.persistence.SecretAdapter;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.repository.OpportunitiesRepositoryImpl;
import com.promigas.persistence.repository.SecretPort;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpportunitiesService {

    public OpportunitiesDto getDataAllOpportunities()  {
        OpportunitiesDto opportunitiesDto = new OpportunitiesDto();
        List<OpportunitiesEntity> opportunitiesEntity = new ArrayList<OpportunitiesEntity>();

//        UserPort port = new UserAdapter(); //????
        SecretPort secretPort = new SecretAdapter();
        ConnectionInfo connectionInfo = secretPort.querySecretConnection(ConstantsEnum.SECRET_SQL_SERVER.getValue());
        System.out.println("Connection:  "+connectionInfo);

        OpportunitiesRepositoryImpl opportunitiesRepository = new OpportunitiesRepositoryImpl();
//        opportunitiesRepository.findOpportunities(connectionInfo);
        opportunitiesEntity= opportunitiesRepository.findOpportunities(connectionInfo);

        System.out.println("send:  numero opor");
        opportunitiesDto.setNumberOpportunities(opportunitiesEntity.size());
        System.out.println("send:  numero gree");

        opportunitiesDto.setNumberGreenfield(countGreen(opportunitiesEntity));
        System.out.println("send:  numero mya");

        opportunitiesDto.setNumberMYA(countMYA(opportunitiesEntity));
        System.out.println("send:  numero mapto oppor");

//        opportunitiesDto.setOpportunitiesByCountries(mapToOpportunitiesDTO(opportunitiesEntity));
        System.out.println("send:  fin opor");

        return opportunitiesDto;
    }

    // arreglar este map error
    public List<OpportunitiesAll> mapToOpportunitiesDTO(
            List<OpportunitiesEntity> opportunitiesEntityList)
    {
        List<OpportunitiesAll> opportunitiesAlls= new ArrayList<OpportunitiesAll>();
        List<Integer> id = new ArrayList<>();
        int NumOpportunities = 0;
        for(OpportunitiesEntity oppor : opportunitiesEntityList) {
            if(oppor != null){
                OpportunitiesAll opportunitiesAll = new OpportunitiesAll();
                if(id.indexOf(oppor.getIdCountry().getUnique_id()) < 0){
                    NumOpportunities = countOportunities(opportunitiesEntityList,oppor.getIdCountry().getUnique_id());

                    opportunitiesAll.setNumberOpportunity(NumOpportunities);
                    opportunitiesAll.setCountry(oppor.getIdCountry().getNameContry());
                    opportunitiesAll.setCoordinates(oppor.getCoordinates());

                    opportunitiesAlls.add(opportunitiesAll);
                    id.add(oppor.getIdCountry().getUnique_id());
                }
            }
        }
        return opportunitiesAlls;
    }
    public int countOportunities(List<OpportunitiesEntity> oppor,int id){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if (op.getIdCountry().getUnique_id() == id) {
                count++;
            }
        }
        return count;
    }
    public int countGreen(List<OpportunitiesEntity> oppor){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if(op.getGreenfield()!= null) {
                count++;
            }
        }
        return count;
    }

    public int countMYA(List<OpportunitiesEntity> oppor){
        int count=0;
        for(OpportunitiesEntity op: oppor) {
            if(op.getMYA()!= null) {
                count++;
            }
        }
        return count;
    }
}
