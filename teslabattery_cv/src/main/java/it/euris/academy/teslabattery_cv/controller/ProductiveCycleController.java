package it.euris.academy.teslabattery_cv.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.teslabattery_cv.data.dto.ProductiveCycleDto;
import it.euris.academy.teslabattery_cv.service.ProductiveCycleService;

@RestController
@RequestMapping("/productive-cycles")
public class ProductiveCycleController {

  @Autowired
  ProductiveCycleService productiveCycleService;

  @GetMapping("/v1")
  public List<ProductiveCycleDto> getAll(){
    return productiveCycleService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ProductiveCycleDto getById(@PathVariable("id") Long id) {
    return productiveCycleService.get(id);
   }

  @DeleteMapping("/v1/{id}") 
  public Boolean delete(@PathVariable("id") Long id) {
      return productiveCycleService.delete(id);
  }

  @PutMapping("/v1")
  public ProductiveCycleDto update(@RequestBody ProductiveCycleDto productiveCycleDto) {
    return productiveCycleService.update(productiveCycleDto);
  }
  
  @PostMapping("/v1")
  public ProductiveCycleDto insert(@RequestBody ProductiveCycleDto productiveCycleDto) {

      return productiveCycleService.add(productiveCycleDto);
  }

}
