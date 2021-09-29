package it.euris.academy.teslabattery_cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.teslabattery_cv.data.model.ProductiveCycle;

public interface ProductiveCycleRepository extends JpaRepository<ProductiveCycle, Long> {

}
