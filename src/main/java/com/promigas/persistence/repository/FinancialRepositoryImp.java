package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
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
    private static final String QUERY_TARIF = "select * from dbo.cf_tarif c where c.id_opportunity=?";



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
            return capexEntities;
        }catch(Exception ex){
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
            ResultSet rs = Query.executeQuery();
            while(rs.next()) {
                EbitdaEntity eb = new EbitdaEntity();
                eb.setUnique_id(rs.getInt("unique_id"));
                eb.setYear(rs.getString("year"));
                eb.setEbitdaUsd(rs.getString("ebitda_usd"));
                eb.setValueEbitdaUsd(rs.getString("value_ebitda_usd"));
                eb.setEbitdaCop(rs.getString("ebitda_cop"));
                eb.setValueEbitdaCop(rs.getString("value_ebitda_cop"));
                ebitdaEntities.add(eb);
            }
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                DividensEntity dv = new DividensEntity();
                dv.setUnique_id(rs.getInt("unique_id"));
                dv.setYear(rs.getString("year"));
                dv.setDividensUsd(rs.getString("dividens_usd"));
                dv.setValuedividensUsd(rs.getString("value_dividends_usd"));
                dv.setDividensCop(rs.getString("dividens_cop"));
                dv.setValueDividensCop(rs.getString("value_dividends_cop"));
                dividensEntities.add(dv);
            }
            return dividensEntities;
        } catch (Exception ex) {
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                FclEntity fc = new FclEntity();
                fc.setUnique_id(rs.getInt("unique_id"));
                fc.setYear(rs.getString("year"));
                fc.setFclUsd(rs.getString("fcl_usd"));
                fc.setValueFclUsd(rs.getString("value_fcl_usd"));
                fc.setFclCop(rs.getString("fcl_cop"));
                fc.setValueFclCop(rs.getString("value_fcl_cop"));
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                FclShareholderEntity fca = new FclShareholderEntity();
                fca.setUnique_id(rs.getInt("unique_id"));
                fca.setYear(rs.getString("year"));
                fca.setShareholderUsd(rs.getString("shareholder_usd"));
                fca.setValueShareUsd(rs.getString("value_share_usd"));
                fca.setShareholderCop(rs.getString("shareholder_cop"));
                fca.setValueShareCop(rs.getString("value_share_cop"));
                fclShareholderEntities.add(fca);
            }
            return fclShareholderEntities;
        } catch (Exception ex) {
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                IncomeEntity inc = new IncomeEntity();
                inc.setUnique_id(rs.getInt("unique_id"));
                inc.setYear(rs.getString("year"));
                inc.setIncomeUsd(rs.getString("income_usd"));
                inc.setValueIncomeUsd(rs.getString("value_income_usd"));
                inc.setIncomeCop(rs.getString("income_cop"));
                inc.setValueIncomeCop(rs.getString("value_income_cop"));
                incomeEntities.add(inc);
            }
            return incomeEntities;
        } catch (Exception ex) {
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                TirEquityEntity tireq = new TirEquityEntity();
                tireq.setUnique_id(rs.getInt("unique_id"));
                tireq.setYear(rs.getDate("year"));
                tireq.setTirEqFig(rs.getString("tir_equity_figure"));
                tireq.setTirEqUnit(rs.getString("tir_equity_unit"));
                tireq.setTirEqCapital(rs.getString("tir_equity_capital_structure"));
                tireq.setTirEqCost(rs.getString("tir_equity_debt_cost"));
                tireq.setTirEqAmortizacion(rs.getString("tir_equity_amortization"));
                tirEquityEntities.add(tireq);
            }
            return tirEquityEntities;
        } catch (Exception ex) {
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                TirProjectEntity tirproj = new TirProjectEntity();
                tirproj.setUnique_id(rs.getInt("unique_id"));
                tirproj.setYear(rs.getString("year"));
                tirproj.setTirprojfigure(rs.getString("tir_project_figure"));
                tirproj.setTirprojectunit(rs.getString("tir_project_unit"));
                tirProjectEntities.add(tirproj);
            }
            return tirProjectEntities;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }


    @Override
    public List<UtilityEntity> findByUtility(int id_opportunity, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<UtilityEntity> utilityEntities = new ArrayList<UtilityEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_UTILITY);
            Query.setInt(1, id_opportunity);
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                UtilityEntity utility = new UtilityEntity();
                utility.setUnique_id(rs.getInt("unique_id"));
                utility.setYear(rs.getString("year"));
                utility.setUtilityUsd(rs.getString("utility_usd"));
                utility.setValueUtilityUsd(rs.getString("value_utility_usd"));
                utility.setUtilityCop("utility_cop");
                utility.setValueUtilityCop("value_utility_cop");
                utilityEntities.add(utility);
            }
            return utilityEntities;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<TarifEntity> findByTarif(int id_opportunity, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<TarifEntity> tarifEntities = new ArrayList<TarifEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_TARIF);
            Query.setInt(1, id_opportunity);
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                TarifEntity tarif = new TarifEntity();
                tarif.setUnique_id(rs.getInt("unique_id"));
                tarif.setYear(rs.getString("year"));
                tarif.setValueTarifUsd(rs.getString("value_tarif_usd"));
                tarif.setValueTarifCop(rs.getString("value_tarif_cop"));

                tarifEntities.add(tarif);
            }
            return tarifEntities;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }
}
