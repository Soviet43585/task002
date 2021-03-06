package com.egor.demo.repository;

import com.egor.demo.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Page<Car> findAll(Pageable pageable);

    Page<Car> findByOrderByTypeAsc(Pageable pageable);

    Page<Car> findByOrderByPriceAsc(Pageable pageable);

    Page<Car> findAllByUserId(Long userId, Pageable pageable);

    List<Car> findAllByUserId(Long userId);

    Page<Car> findAllByType(String type, Pageable pageable);
}
