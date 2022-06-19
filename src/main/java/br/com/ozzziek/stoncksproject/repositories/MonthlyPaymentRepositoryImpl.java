package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.MonthlyPayment;
import br.com.ozzziek.stoncksproject.entities.enums.CategoryStatusEnum;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class MonthlyPaymentRepositoryImpl implements MonthlyPaymentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long insert(MonthlyPayment monthlyPayment) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO TERM_PURCHASE(FINANCIAL_RELEASE_ID, TOTAL_VALUE, VALIDITY_DAY, BILL_GENERATE_DAY, DETAILS, IS_ACTIVE) VALUES(?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setLong(1, monthlyPayment.getCode());
            ps.setBigDecimal(2, monthlyPayment.getTotalValue());
            ps.setInt(3, monthlyPayment.getValidityDay());
            ps.setInt(4, monthlyPayment.getBillGenerateDay());
            ps.setString(5, monthlyPayment.getDetails());
            ps.setBoolean(6, monthlyPayment.getActive());

            return ps;

        }, keyHolder);

        return Long.parseLong(Objects.requireNonNull(keyHolder.getKey()).toString());
    }

    @Override
    public MonthlyPayment findById(Long id) {
        return null;
    }

    @Override
    public List<MonthlyPayment> list(String parameters) {
        String queryString = "select financial_release_id, DATE, DESCRIPTION, VALUE, category_id, c.percentual_share, c.name, c.status, financial_release_type, tp.id, total_value, validity_day, bill_generate_day, details, is_active from financial_release fr inner join term_purchase tp on fr.id = tp.financial_release_id inner join category c on fr.category_id = c.id";

//        if (parameters != null) {
//            queryString += " WHERE STATUS = '" + parameters + "'";
//        }

        return jdbcTemplate.query(queryString,
                (rs, row) -> new MonthlyPayment(Long.parseLong(rs.getString("FINANCIAL_RELEASE_ID")),
                        rs.getDate("DATE").toLocalDate(),
                        rs.getString("DESCRIPTION"),
                        rs.getDouble("VALUE"),
                        new Category(rs.getLong("CATEGORY_ID"), rs.getString("c.name"), rs.getDouble("c.percentual_share"), CategoryStatusEnum.valueOf(rs.getString("c.status"))),
                        FinancialReleaseTypeEnum.valueOf(rs.getString("FINANCIAL_RELEASE_TYPE")),
                        Long.parseLong(rs.getString("ID")),
                        rs.getBigDecimal("TOTAL_VALUE"),
                        rs.getInt("VALIDITY_DAY"),
                        rs.getInt("BILL_GENERATE_DAY"),
                        rs.getString("DETAILS"),
                        rs.getBoolean("IS_ACTIVE")));
    }

    @Override
    public void update(Long id, MonthlyPayment monthlyPayment) {

        Object[] params = {monthlyPayment.getTotalValue(),
                monthlyPayment.getValidityDay(),
                monthlyPayment.getBillGenerateDay(),
                monthlyPayment.getDetails(),
                monthlyPayment.getActive(),
                id};

        int[] types = {Types.DOUBLE, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.BOOLEAN, Types.BIGINT};

        jdbcTemplate.update("UPDATE term_purchase SET total_value = ?, validity_day = ?, bill_generate_day = ?, details = ?, is_active = ? WHERE ID = ?",
                params,
                types);
    }

    @Override
    public void remove(Long id) {

        jdbcTemplate.update("DELETE FROM TERM_PURCHASE WHERE ID = ?", id);

    }
}
