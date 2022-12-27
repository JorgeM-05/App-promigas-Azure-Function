package com.promigas.service;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.domain.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
import com.promigas.domain.enums.ConstantsEnum;
import com.promigas.persistence.SecretAdapter;
import com.promigas.persistence.entity.FiguresFinancial.*;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.entity.operatingFinancial.DistributionEntity;
import com.promigas.persistence.entity.operatingFinancial.EnergySolutionEntity;
import com.promigas.persistence.entity.operatingFinancial.TransportEntity;
import com.promigas.persistence.repository.*;

import java.util.List;

public class DetailsOpportunityService {
    private OpportunitiesRepository repository = new opportunitiesByContryImp();
    private FinancialRepository repositoryFigures = new FinancialRepositoryImp();

    private OperatingRepository operatingRepository = new OperatingRepositoryImp();

    public OpportunityDetailsDTO getDataOpprt(int id_opportunity) {

        OpportunityDetailsDTO opportunitiesdetailDetailsDTO = new OpportunityDetailsDTO();

        SecretPort secretPort = new SecretAdapter();
        ConnectionInfo connectionInfo = secretPort.querySecretConnection(ConstantsEnum.SECRET_SQL_SERVER.getValue());
        System.out.println("buscando por id");
        OpportunitiesEntity opportunities = repository.findById(id_opportunity,connectionInfo);
        System.out.println("data encontrada :: \n "+opportunities);

        List<CapexEntity> capexEntities = repositoryFigures.findByCapex(opportunities.getUnique_id(),connectionInfo);
        List<EbitdaEntity> ebitdaEntities = repositoryFigures.findByEbitda(opportunities.getUnique_id(),connectionInfo);
        List<DividensEntity> dividensEntities = repositoryFigures.findByDividends(opportunities.getUnique_id(),connectionInfo);
        List<FclEntity> fclEntities = repositoryFigures.findByFCL(opportunities.getUnique_id(),connectionInfo);
        List<FclShareholderEntity> fclShareholderEntities = repositoryFigures.findByFCLSH(opportunities.getUnique_id(),connectionInfo);
        List<IncomeEntity> incomeEntities = repositoryFigures.findByIncome(opportunities.getUnique_id(),connectionInfo);
        List<TirEquityEntity> tirEquityEntities = repositoryFigures.findByTirEquity(opportunities.getUnique_id(),connectionInfo);
        List<TirProjectEntity> tirProjectEntities = repositoryFigures.findByTirProject(opportunities.getUnique_id(),connectionInfo);
        List<UtilityEntity> utilityEntities = repositoryFigures.findByUtility(opportunities.getUnique_id(),connectionInfo);

        List<DistributionEntity> distributionEntities = operatingRepository.findByDistribution(opportunities.getUnique_id(),connectionInfo);
        List<EnergySolutionEntity> energySolutionEntities = operatingRepository.findByEnergy(opportunities.getUnique_id(),connectionInfo);
        List<TransportEntity> transportEntities = operatingRepository.findByTransport(opportunities.getUnique_id(),connectionInfo);



//        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(mapToAll(capexEntity,dividensRepositories,ebitdaEntity,fclEntities,fclShareholder,incomeEntities,
//                tarifEntities,tirEquityEntities,tirProjectEntities,utilityEntities));

        return opportunitiesdetailDetailsDTO;
    }

}
