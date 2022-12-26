package com.promigas.domain.dto.detailOpportunitiesDTO;

import com.promigas.domain.dto.detailOpportunitiesDTO.financial.*;
import lombok.Data;

@Data
public class DetailOpportunitiesByCountry {
    public String nameOportunity;
    public String country;
    public String lastUpdateDate;
    public String description;
    public String sector;
    public CapexDTO capexDTO;
    public EbitdaDTO ebitdaDTO;
    public DividensDTO dividensDTO;
    public FclDTO fclDTO;
    public FclShareHolderDTO fclShareHolderDTO;
    public IncomeDTO incomeDTO;
}
