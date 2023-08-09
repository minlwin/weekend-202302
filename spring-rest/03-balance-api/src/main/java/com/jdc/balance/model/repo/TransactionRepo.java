package com.jdc.balance.model.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.dto.ReportProjectionDto;
import com.jdc.balance.model.entity.Transaction;

public interface TransactionRepo extends JpaRepositoryImplementation<Transaction, Long>{

	Long countByOwnerId(int id);

	@Query("""
			select t.ledger ledger, count(t) transactionCount, sum(t.total) transactionAmount 
			from Transaction t where t.owner.id = ?1 and t.issueDate >= ?2 and t.issueDate < ?3 
			group by t.ledger order by t.ledger.name""")
	List<ReportProjectionDto> findTransactionReport(int memberId, LocalDate from, LocalDate to);

}
