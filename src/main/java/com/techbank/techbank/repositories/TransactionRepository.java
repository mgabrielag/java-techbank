package com.techbank.techbank.repositories;
import com.techbank.techbank.domain.transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = """
            select * from Transactions
            where
                receiver_id = :userId
                or sender_id = :userId
            """, nativeQuery = true)
    Optional<List<Transaction>> findTransactionByUser(Long userId);
}
