package com.promigas.service;


import com.promigas.domain.dto.request.CountryDto;
import com.promigas.domain.dto.request.SectorDto;
import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.domain.dto.response.CountryAll;
import com.promigas.domain.dto.response.SectorAll;
import com.promigas.domain.enums.ConstantsEnum;
import com.promigas.persistence.SecretAdapter;
import com.promigas.persistence.entity.CountryEntity;
import com.promigas.persistence.entity.SectorEntity;
import com.promigas.persistence.repository.CountryRepositoryImp;
import com.promigas.persistence.repository.SecretPort;
import com.promigas.persistence.repository.SectorRepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class SectorService {


    public SectorDto getDataAllSector()  {
        SectorDto sectorsDto = new SectorDto();
        List<SectorEntity> sectorEntities = new ArrayList<SectorEntity>();

        SecretPort secretPort = new SecretAdapter();
        ConnectionInfo connectionInfo = secretPort.querySecretConnection(ConstantsEnum.SECRET_SQL_SERVER.getValue());

        SectorRepositoryImp sectorsRepository = new SectorRepositoryImp();
        sectorEntities= sectorsRepository.findSector(connectionInfo);

//        countryDto.setNumberCountry(countriesEntity.size());
//        opportunitiesDto.setNumberGreenfield(countGreen(opportunitiesEntity));
//        opportunitiesDto.setNumberMYA(countMYA(opportunitiesEntity));
//          SectorDto.setOpportunitiesByCountries(mapToSectorDto(sectorEntities));

        return sectorsDto;
    }

    public List<SectorAll> mapToSectorDto(
            List<SectorEntity> sectorsEntityList)
    {
        List<SectorAll> sectorAlls= new ArrayList<SectorAll>();
        List<Integer> id = new ArrayList<>();
//        int NumOpportunities = 0;
//        for(OpportunitiesEntity oppor : opportunitiesEntityList) {
//            if(oppor != null){
//                OpportunitiesAll opportunitiesAll = new OpportunitiesAll();
//                if(id.indexOf(oppor.getIdCountry().getUnique_id()) < 0){
//                    NumOpportunities = countOportunities(opportunitiesEntityList,oppor.getIdCountry().getUnique_id());
//
//                    opportunitiesAll.setNumberOpportunity(NumOpportunities);
//                    opportunitiesAll.setCountry(oppor.getIdCountry().getNameContry());
//                    opportunitiesAll.setCoordinates(oppor.getCoordinates());
//                    opportunitiesAll.setUniqid(oppor.getUnique_id());
//                    opportunitiesAlls.add(opportunitiesAll);
//                }
//            }

        return null;
}
}


