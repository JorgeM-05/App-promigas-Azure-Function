package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.CapexEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FinancialRepositoryImp extends AbstractRepositoryDatabase implements FinancialRepository{
    private static final String QUERY_CAPEX = "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_EBITDA = "select * from dbo.cf_ebitda c where c.id_opportunity=?";
    private static final String QUERY_DIVIDENS = "select * from dbo.cf_dividends c where c.id_opportunity=?";
    private static final String QUERY_FCL = "select * from dbo.cf_fcl c where c.id_opportunity=?";
    private static final String QUERY_FCL_SH = "select * from dbo.cf_fcl_shareholder c where c.id_opportunity=?";
    private static final String QUERY_INCOME = "select * from dbo.cf_income c where c.id_opportunity=?";
    private static final String QUERY_TIR_EQUITY = "select * from dbo.cf_tir_equity c where c.id_opportunity=?";
    private static final String QUERY_TIR_PROJECT = "select * from dbo.cf_tir_project c where c.id_opportunity=?";
    private static final String QUERY_UTILITY = "select * from dbo.cf_utility_net c where c.id_opportunity=?";


    @Override
    public List<CapexEntity> findByCapex(int id_opportunity, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<CapexEntity> capexEntities = new ArrayList<CapexEntity>();

        try{
            PreparedStatement Query = connection.prepareStatement(QUERY_CAPEX);
            Query.setInt(1,id_opportunity);
            ResultSet rs = Query.executeQuery();
            while(rs.next()) {
                CapexEntity cx = new CapexEntity();
                cx.setUnique_id(rs.getInt("unique_id"));
                cx.setYear(rs.getString("year"));
                cx.setCapexUsd(rs.getString("cape_usd"));
                cx.setValueCapexUsd(rs.getString("value_capex_usd"));
                cx.setCapexCop(rs.getString("capex_cop"));
                cx.setValueCapexCop(rs.getString("value_capex_cop"));
                capexEntities.add(cx);
            }
            return capexEntities;
        }catch(Exception ex){
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        }finally {
            closeConnection();
        }
    }

    @Override
    public List<CapexEntity> findByEbitda(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByDividends(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByFCL(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByFCLSH(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByIncome(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByTirEquity(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByTirProject(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByUtility(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }
}
