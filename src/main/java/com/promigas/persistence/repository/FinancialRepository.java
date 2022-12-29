package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.*;

import java.util.List;

public interface FinancialRepository {
    public List<CapexEntity> findByCapex(int id_opportunity, ConnectionInfo connectionInfo);
    public List<EbitdaEntity> findByEbitda(int id_opportunity, ConnectionInfo connectionInfo);
    public List<DividensEntity> findByDividends(int id_opportunity, ConnectionInfo connectionInfo);
    public List<FclEntity> findByFCL(int id_opportunity, ConnectionInfo connectionInfo);
    public List<FclShareholderEntity> findByFCLSH(int id_opportunity, ConnectionInfo connectionInfo);
    public List<IncomeEntity> findByIncome(int id_opportunity, ConnectionInfo connectionInfo);
    public List<TirEquityEntity> findByTirEquity(int id_opportunity, ConnectionInfo connectionInfo);
    public List<TirProjectEntity> findByTirProject(int id_opportunity, ConnectionInfo connectionInfo);
    public List<UtilityEntity> findByUtility(int id_opportunity, ConnectionInfo connectionInfo);



}
