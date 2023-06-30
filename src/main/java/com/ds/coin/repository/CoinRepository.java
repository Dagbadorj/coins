package com.ds.coin.repository;

import com.ds.coin.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long>{

    Optional<Coin> findByIdAndDeleted(Long id, char deleted);
    List<Coin> findAllByDeleted(char deleted);

}
