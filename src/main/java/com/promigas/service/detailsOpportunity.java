//package com.promigas.service;
//
//import com.promigas.domain.dto.ConnectionInfo;
//import com.promigas.domain.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
//import com.promigas.domain.enums.ConstantsEnum;
//import com.promigas.persistence.SecretAdapter;
//import com.promigas.persistence.entity.OpportunitiesEntity;
//import com.promigas.persistence.repository.OpportunitiesRepository;
//import com.promigas.persistence.repository.SecretPort;
//import com.promigas.persistence.repository.opportunitiesByContryImp;
//
//import java.util.List;
//
//public class detailsOpportunity {
//    private OpportunitiesRepository repository = new opportunitiesByContryImp();
//
//    public OpportunityDetailsDTO getDataOpprt(int id_opportunity) {
//
//        OpportunityDetailsDTO opportunitiesdetailDetailsDTO = new OpportunityDetailsDTO();
//
//        SecretPort secretPort = new SecretAdapter();
//        ConnectionInfo connectionInfo = secretPort.querySecretConnection(ConstantsEnum.SECRET_SQL_SERVER.getValue());
//
//
//        OpportunitiesEntity opportunities = repository.findById(id_opportunity,connectionInfo);
//
//
//
////        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(mapToAll(capexEntity,dividensRepositories,ebitdaEntity,fclEntities,fclShareholder,incomeEntities,
////                tarifEntities,tirEquityEntities,tirProjectEntities,utilityEntities));
//
//        return opportunitiesdetailDetailsDTO;
//    }
//}
