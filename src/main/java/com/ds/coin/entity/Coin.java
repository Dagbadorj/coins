package com.ds.coin.entity;


import com.ds.coin.constant.Common;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Entity
@Table(name = "coin")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Data
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "isDeleted", nullable = false)
    private char deleted=Common.Flag.No;

    @Column(name = "createdAt", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "modifiedAt", nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
