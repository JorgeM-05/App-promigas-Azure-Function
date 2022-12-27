package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.CapexEntity;

import java.util.List;

public interface FinancialRepository {
    public List<CapexEntity> findByCapex(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByEbitda(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByDividends(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByFCL(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByFCLSH(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByIncome(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByTirEquity(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByTirProject(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByUtility(int id_opportunity, ConnectionInfo connectionInfo);



}
