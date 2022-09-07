package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.Installment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
public class InstallmentRepositoryImpl implements InstallmentRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertList(List<Installment> installmentList, Long termPurchaseId) {
        jdbcTemplate.batchUpdate(
                "insert into installments(term_purchase_id, total_installments, current_installment, validity_date) values(?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {

                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, termPurchaseId);
                        ps.setInt(2, installmentList.get(i).getTotalInstallments());
                        ps.setInt(3, installmentList.get(i).getCurrentInstallment());
                        ps.setDate(4, Date.valueOf(installmentList.get(i).getValidityDate().toString()));
                    }

                    public int getBatchSize() {
                        return installmentList.size();
                    }
                });
    }

    @Override
    public Long insert(Installment obj) {
        return null;
    }

    @Override
    public Installment findById(Long id) {
        return null;
    }

    @Override
    public List<Installment> list(String parameters) {
        String queryString = "select ID, TOTAL_INSTALLMENTS, CURRENT_INSTALLMENT, VALIDITY_DATE from installments where term_purchase_id = '" + parameters + "'";

        return jdbcTemplate.query(queryString,
                (rs, row) -> new Installment(Long.parseLong(rs.getString("ID")),
                        rs.getInt("TOTAL_INSTALLMENTS"),
                        rs.getInt("CURRENT_INSTALLMENT"),
                        rs.getDate("VALIDITY_DATE").toLocalDate()));
    }

    @Override
    public void update(Long id, Installment obj) {

    }

    @Override
    public void remove(Long id) {
        jdbcTemplate.update("DELETE FROM INSTALLMENTS WHERE ID = ?", id);
    }
}
