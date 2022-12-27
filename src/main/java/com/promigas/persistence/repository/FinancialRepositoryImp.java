package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

    public class FinancialRepositoryImp extends AbstractRepositoryDatabase implements FinancialRepository{
    private static final String QUERY_CAPEX = "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_DIVIDENS = "select * from dbo.cf_dividends c where c.id_opportunity=?";
    private static final String QUERY_EBITDA = "select * from dbo.cf_ebitda c where c.id_opportunity=?";
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
                cx.setCapexUsd(rs.getString("capex_usd"));
                cx.setValueCapexUsd(rs.getString("value_capex_usd"));
                cx.setCapexCop(rs.getString("capex_cop"));
                cx.setValueCapexCop(rs.getString("value_capex_cop"));
                capexEntities.add(cx);
            }
            System.out.println("Capex::: "+capexEntities);
            return capexEntities;
        }catch(Exception ex){
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        }finally {
            closeConnection();
        }
    }

    @Override
    public List<EbitdaEntity> findByEbitda(int id_opportunity, ConnectionInfo connectionInfo) {
    getConnectionSQLServer(connectionInfo);
    List<EbitdaEntity> ebitdaEntities = new ArrayList<EbitdaEntity>();
        try{
            PreparedStatement Query = connection.prepareStatement(QUERY_EBITDA);
            Query.setInt(1,id_opportunity);
            ResultSet rs2 = Query.executeQuery();
            while(rs2.next()) {
                EbitdaEntity eb = new EbitdaEntity();
                eb.setUnique_id(rs2.getInt("unique_id"));
                eb.setYear(rs2.getString("year"));
                eb.setEbitdaUsd(rs2.getString("ebitda_usd"));
                eb.setValueEbitdaUsd(rs2.getString("value_ebitda_usd"));
                eb.setEbitdaCop(rs2.getString("ebitda_cop"));
                eb.setValueEbitdaCop(rs2.getString("value_ebitda_cop"));
                ebitdaEntities.add(eb);
            }
            System.out.println("Ebitda::: "+ebitdaEntities);

            return ebitdaEntities;
        }catch(Exception ex){
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        }finally {
            closeConnection();
        }
    }



    @Override
    public List<DividensEntity> findByDividends(int id_opportunity, ConnectionInfo connectionInfo) {
    getConnectionSQLServer(connectionInfo);
    List<DividensEntity> dividensEntities = new ArrayList<DividensEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_DIVIDENS);
            Query.setInt(1, id_opportunity);
            ResultSet rs3 = Query.executeQuery();
            while (rs3.next()) {
                DividensEntity dv = new DividensEntity();
                dv.setUnique_id(rs3.getInt("unique_id"));
                dv.setYear(rs3.getString("year"));
                dv.setDividensUsd(rs3.getString("dividens_usd"));
                dv.setValuedividensUsd(rs3.getString("value_dividends_usd"));
                dv.setDividensCop(rs3.getString("dividens_cop"));
                dv.setValueDividensCop(rs3.getString("value_dividends_cop"));
                dividensEntities.add(dv);
            }
            System.out.println("divide ::: "+dividensEntities);

            return dividensEntities;
        } catch (Exception ex) {
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }


    @Override
    public List<FclEntity> findByFCL(int id_opportunity, ConnectionInfo connectionInfo) {
    getConnectionSQLServer(connectionInfo);
    List<FclEntity> fclEntities = new ArrayList<FclEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_FCL);
            Query.setInt(1, id_opportunity);
            ResultSet rs4 = Query.executeQuery();
            while (rs4.next()) {
                FclEntity fc = new FclEntity();
                fc.setUnique_id(rs4.getInt("unique_id"));
                fc.setYear(rs4.getString("year"));
                fc.setFclUsd(rs4.getString("fcl_usd"));
                fc.setValueFclUsd(rs4.getString("value_fcl_usd"));
                fc.setFclCop(rs4.getString("fcl_cop"));
                fc.setValueFclCop(rs4.getString("value_fcl_cop"));
                fclEntities.add(fc);
            }
            System.out.println("fcl ::: "+fclEntities);

            return fclEntities;
        } catch (Exception ex) {
    //            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }

    }

    @Override
    public List<FclShareholderEntity> findByFCLSH(int id_opportunity, ConnectionInfo connectionInfo) {
    getConnectionSQLServer(connectionInfo);
    List<FclShareholderEntity> fclShareholderEntities = new ArrayList<FclShareholderEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_FCL_SH);
            Query.setInt(1, id_opportunity);
            ResultSet rs5 = Query.executeQuery();
            while (rs5.next()) {
                FclShareholderEntity fca = new FclShareholderEntity();
                fca.setUnique_id(rs5.getInt("unique_id"));
                fca.setYear(rs5.getString("year"));
                fca.setShareholderUsd(rs5.getString("shareholder_usd"));
                fca.setValueShareUsd(rs5.getString("value_share_usd"));
                fca.setShareholderCop(rs5.getString("shareholder_cop"));
                fca.setValueShareCop(rs5.getString("value_share_cop"));
                fclShareholderEntities.add(fca);
            }
            System.out.println("fcSH::: "+fclShareholderEntities);

            return fclShareholderEntities;
        } catch (Exception ex) {
    //            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<IncomeEntity> findByIncome(int id_opportunity, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<IncomeEntity> incomeEntities = new ArrayList<IncomeEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_INCOME);
            Query.setInt(1, id_opportunity);
            ResultSet rs6 = Query.executeQuery();
            while (rs6.next()) {
                IncomeEntity inc = new IncomeEntity();
                inc.setUnique_id(rs6.getInt("unique_id"));
                inc.setYear(rs6.getString("year"));
                inc.setIncomeUsd(rs6.getString("income_usd"));
                inc.setValueIncomeUsd(rs6.getString("value_income_usd"));
                inc.setIncomeCop(rs6.getString("income_cop"));
                inc.setValueIncomeCop(rs6.getString("value_income_cop"));
                incomeEntities.add(inc);
            }
            System.out.println("income ::: "+incomeEntities);

            return incomeEntities;
        } catch (Exception ex) {
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<TirEquityEntity> findByTirEquity(int id_opportunity, ConnectionInfo connectionInfo) {
    getConnectionSQLServer(connectionInfo);
    List<TirEquityEntity> tirEquityEntities = new ArrayList<TirEquityEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_TIR_EQUITY);
            Query.setInt(1, id_opportunity);
            ResultSet rs7 = Query.executeQuery();
            while (rs7.next()) {
                TirEquityEntity tireq = new TirEquityEntity();
                tireq.setUnique_id(rs7.getInt("unique_id"));
                tireq.setYear(rs7.getDate("year"));
                tireq.setTirEqFig(rs7.getString("tir_equity_figure"));
                tireq.setTirEqUnit(rs7.getString("tir_equity_unit"));
                tireq.setTirEqCapital(rs7.getString("tir_equity_capital_structure"));
                tireq.setTirEqCost(rs7.getString("tir_equity_debt_cost"));
                tireq.setTirEqAmortizacion(rs7.getString("tir_equity_amortization"));
                tirEquityEntities.add(tireq);
            }
            System.out.println("tir Equi::: "+tirEquityEntities);

            return tirEquityEntities;
        } catch (Exception ex) {
    //            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<TirProjectEntity> findByTirProject(int id_opportunity, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<TirProjectEntity> tirProjectEntities = new ArrayList<TirProjectEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_TIR_PROJECT);
            Query.setInt(1, id_opportunity);
            ResultSet rs8 = Query.executeQuery();
            while (rs8.next()) {
                TirProjectEntity tirproj = new TirProjectEntity();
                tirproj.setUnique_id(rs8.getInt("unique_id"));
                tirproj.setYear(rs8.getString("year"));
                tirproj.setTirprojfigure(rs8.getString("tir_project_figure"));
                tirproj.setTirprojectunit(rs8.getString("tir_project_unit"));
                tirProjectEntities.add(tirproj);
            }
            System.out.println("tir projec ::: "+tirProjectEntities);

            return tirProjectEntities;
        } catch (Exception ex) {
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }

    }


    @Override
    public List<UtilityEntity> findByUtility(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }
}
