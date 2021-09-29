package it.euris.academy.teslabattery_cv.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_cv.data.dto.ProductiveCycleDto;
import it.euris.academy.teslabattery_cv.data.model.ProductiveCycle;
import it.euris.academy.teslabattery_cv.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_cv.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_cv.repository.ProductiveCycleRepository;
import it.euris.academy.teslabattery_cv.service.ProductiveCycleService;

@Service
public class ProductiveCycleServiceImpl implements ProductiveCycleService{
  @Autowired
  private ProductiveCycleRepository productiveCycleRepository;
  
  @Override
   public List<ProductiveCycleDto> getAll(){
    return productiveCycleRepository.findAll().stream().map(curProductiveCycle -> curProductiveCycle.toDto()).collect(Collectors.toList());
  }

  @Autowired
  private EntityManager entityManager;
  
  @Override
  public ProductiveCycleDto get(Long id) {
    Optional<ProductiveCycle> productiveCycle = productiveCycleRepository.findById(id);
    if(productiveCycle.isPresent()) {
        return productiveCycle.get().toDto();
    }
    return null;
  }

  @Override
  public ProductiveCycleDto add(ProductiveCycleDto productiveCycleDto) {
    if(productiveCycleDto.getId() != null) {
      throw new IdMustBeNullException();
  }
  return productiveCycleRepository.save(productiveCycleDto.toModel()).toDto();
}
  

  @Override
  public ProductiveCycleDto update(ProductiveCycleDto productiveCycleDto) {
    if(productiveCycleDto.getId() == null) {
      throw new IdMustNotBeNullException();
  }
  return productiveCycleRepository.save(productiveCycleDto.toModel()).toDto();
}

  @Override
  public Boolean delete(Long id) {
    productiveCycleRepository.deleteById(id);
    return productiveCycleRepository.findById(id).isEmpty();
 }
  
  @Override
  public Iterable<ProductiveCycle> findAll(boolean isDeleted){
     Session session = entityManager.unwrap(Session.class);
     Filter filter = session.enableFilter("deletedProductiveCycleFilter");
     filter.setParameter("isDeleted", isDeleted);
     Iterable<ProductiveCycle> productiveCycles =  productiveCycleRepository.findAll();
     session.disableFilter("deletedProductiveCycleFilter");
     return productiveCycles;
 }
}
