package com.promigas.service;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.domain.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
import com.promigas.domain.enums.ConstantsEnum;
import com.promigas.persistence.SecretAdapter;
import com.promigas.persistence.entity.FiguresFinancial.CapexEntity;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.repository.*;

import java.util.List;

public class DetailsOpportunityService {
    private OpportunitiesRepository repository = new opportunitiesByContryImp();
    private FinancialRepository repositoryFigures = new FinancialRepositoryImp();

    public OpportunityDetailsDTO getDataOpprt(int id_opportunity) {

        OpportunityDetailsDTO opportunitiesdetailDetailsDTO = new OpportunityDetailsDTO();

        SecretPort secretPort = new SecretAdapter();
        ConnectionInfo connectionInfo = secretPort.querySecretConnection(ConstantsEnum.SECRET_SQL_SERVER.getValue());
        System.out.println("buscando por id");
        OpportunitiesEntity opportunities = repository.findById(id_opportunity,connectionInfo);
        System.out.println("data encontrada :: \n "+opportunities);

        List<CapexEntity> capexEntity = repositoryFigures.findByCapex(opportunities.getUnique_id(),connectionInfo);


//        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(mapToAll(capexEntity,dividensRepositories,ebitdaEntity,fclEntities,fclShareholder,incomeEntities,
//                tarifEntities,tirEquityEntities,tirProjectEntities,utilityEntities));

        return opportunitiesdetailDetailsDTO;
    }

}
