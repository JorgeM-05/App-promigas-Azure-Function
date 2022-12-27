package com.promigas.service;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.domain.dto.detailOpportunitiesDTO.OpportunitiesByCountryDTO;
import com.promigas.domain.dto.detailOpportunitiesDTO.OpportunityDetailsDTO;
import com.promigas.domain.dto.detailOpportunitiesDTO.financial.*;
import com.promigas.domain.enums.ConstantsEnum;
import com.promigas.persistence.SecretAdapter;
import com.promigas.persistence.entity.FiguresFinancial.*;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.entity.operatingFinancial.DistributionEntity;
import com.promigas.persistence.entity.operatingFinancial.EnergySolutionEntity;
import com.promigas.persistence.entity.operatingFinancial.TransportEntity;
import com.promigas.persistence.repository.*;

import java.util.ArrayList;
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
        System.out.println("data encontrada ca :: \n "+capexEntities);

        List<EbitdaEntity> ebitdaEntities = repositoryFigures.findByEbitda(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada eb :: \n "+capexEntities);

        List<DividensEntity> dividensEntities = repositoryFigures.findByDividends(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada dui :: \n "+capexEntities);

        List<FclEntity> fclEntities = repositoryFigures.findByFCL(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada fc :: \n "+capexEntities);

        List<FclShareholderEntity> fclShareholderEntities = repositoryFigures.findByFCLSH(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada fch :: \n "+capexEntities);

        List<IncomeEntity> incomeEntities = repositoryFigures.findByIncome(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada inc :: \n "+capexEntities);

        List<TirEquityEntity> tirEquityEntities = repositoryFigures.findByTirEquity(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada tir :: \n "+capexEntities);

        List<TirProjectEntity> tirProjectEntities = repositoryFigures.findByTirProject(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada pro :: \n "+capexEntities);

        List<UtilityEntity> utilityEntities = repositoryFigures.findByUtility(opportunities.getUnique_id(),connectionInfo);
        System.out.println("data encontrada util :: \n "+capexEntities);


//        List<DistributionEntity> distributionEntities = operatingRepository.findByDistribution(opportunities.getUnique_id(),connectionInfo);
//        List<EnergySolutionEntity> energySolutionEntities = operatingRepository.findByEnergy(opportunities.getUnique_id(),connectionInfo);
//        List<TransportEntity> transportEntities = operatingRepository.findByTransport(opportunities.getUnique_id(),connectionInfo);



        opportunitiesdetailDetailsDTO.setOpportunitiesByCountry(
                mapToAll(capexEntities,ebitdaEntities,dividensEntities,fclEntities,fclShareholderEntities,incomeEntities,
                tirEquityEntities,tirProjectEntities,utilityEntities));

        return opportunitiesdetailDetailsDTO;
    }


    public OpportunitiesByCountryDTO mapToAll(List<CapexEntity> capexEntity,List<EbitdaEntity> ebitdaEntity,
                                              List<DividensEntity> dividensEntities, List<FclEntity> fclEntities,
                                              List<FclShareholderEntity> fclShareholderEntities,
                                              List<IncomeEntity> incomeEntities,
                                              List<TirEquityEntity> tirEquityEntities, List<TirProjectEntity> tirProjectEntities,
                                              List<UtilityEntity> utilityEntities){

        OpportunitiesByCountryDTO opportunities = new OpportunitiesByCountryDTO();
        List<String> usd = new ArrayList<>();
        List<String> cop = new ArrayList<>();

        boolean var =true;

        CapexDTO capexDTO = new CapexDTO();
        DividensDTO dividensDTO = new DividensDTO();
        EbitdaDTO ebitdaDTO = new EbitdaDTO();
        FclDTO fclDTO = new FclDTO();
        FclShareHolderDTO fclShareDTO = new FclShareHolderDTO();
        IncomeDTO incomeDTO = new IncomeDTO();
        TarifDTO tarifDTO = new TarifDTO();
        TirEquityDTO tirEquityDTO = new TirEquityDTO();


        for(CapexEntity capex: capexEntity){
//            if(var == true) {
//                capexDTO.setYear(capex.getYear());
//                capexDTO.setCapexUsd(capex.getCapexUsd());
//                capexDTO.setCapexCop(capex.getCapexCop());
//                var = false;
//            }
            usd.add(capex.getValueCapexUsd());
            cop.add(capex.getValueCapexCop());
            capexDTO.setValueCapexUsd(usd);
            capexDTO.setValueCapexCop(cop);
        }
        opportunities.setCapexDTO(capexDTO);

        for(EbitdaEntity ebitda: ebitdaEntity){
            usd.add(ebitda.getValueEbitdaUsd());
            cop.add(ebitda.getValueEbitdaCop());
            ebitdaDTO.setValueEbitdaUsd(usd);
            ebitdaDTO.setValueEbitdaCop(cop);
        }
        opportunities.setEbitdaDTO(ebitdaDTO);

        for(DividensEntity div: dividensEntities){
            usd.add(div.getValuedividensUsd());
            cop.add(div.getDividensCop());
            dividensDTO.setValuedividensUsd(usd);
            dividensDTO.setValueDividensCop(cop);
        }
        opportunities.setDividensDTO(dividensDTO);

        for(FclEntity fcl: fclEntities){
            usd.add(fcl.getFclUsd());
            cop.add(fcl.getFclCop());
            fclDTO.setValueFclUsd(usd);
            fclDTO.setValueFclCop(cop);
        }
        opportunities.setFclDTO(fclDTO);

        for(FclShareholderEntity fclShare: fclShareholderEntities){
            usd.add(fclShare.getShareholderUsd());
            cop.add(fclShare.getShareholderCop());
            fclShareDTO.setValueShareUsd(usd);
            fclShareDTO.setValueShareCop(cop);
        }
        opportunities.setFclShareHolderDTO(fclShareDTO);

        for(IncomeEntity incomeEntity: incomeEntities){
            usd.add(incomeEntity.getIncomeUsd());
            cop.add(incomeEntity.getIncomeCop());
            incomeDTO.setValueCapexUsd(usd);
            incomeDTO.setValueCapexCop(cop);
        }
        opportunities.setIncomeDTO(incomeDTO);

//        for(TarifEntity tarif: tarifEntities){
//            usd.add(tarif.getValueTarifUsd());
//            cop.add(tarif.getValueTarifCop());
//            incomeDTO.setValueCapexUsd(usd);
//            incomeDTO.setValueCapexCop(cop);
//        }
//        opportunities.setT(incomeDTO);

        return opportunities;
    }

}
