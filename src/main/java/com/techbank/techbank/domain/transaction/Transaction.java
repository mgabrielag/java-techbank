package com.techbank.techbank.domain.transaction;

import com.techbank.techbank.domain.user.User;
import com.techbank.techbank.dtos.TransactionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transaction")
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @Column(name = "sender_id", nullable = false)
    private Long senderId;

    @ManyToOne
    @JoinColumn(name = "sender_id",insertable = false)
    private User sender;

    @Column(name = "receiver_id", nullable = false)
    private Long receiverId;

    @ManyToOne
    @JoinColumn(name = "receiver_id", insertable = false)
    private User receiver;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Transaction(TransactionDTO dto) {
        this.senderId = dto.senderId();
        this.receiverId = dto.receiverId();
        this.value = dto.value();
    }
}
