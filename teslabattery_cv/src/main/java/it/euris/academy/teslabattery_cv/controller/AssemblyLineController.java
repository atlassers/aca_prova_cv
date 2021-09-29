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
import it.euris.academy.teslabattery_cv.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_cv.service.AssemblyLineService;

@RestController
@RequestMapping("/assembly-lines")
public class AssemblyLineController {
  @Autowired
  AssemblyLineService assemblyLineService;

  @GetMapping("/v1")
  public List<AssemblyLineDto> getAll(){
    return assemblyLineService.getAll();
  }

  @GetMapping("/v1/{id}")
  public AssemblyLineDto getById(@PathVariable("id") Long id) {
    return assemblyLineService.get(id);
   }

  @DeleteMapping("/v1/{id}") 
  public Boolean delete(@PathVariable("id") Long id) {
      return assemblyLineService.delete(id);
  }

  @PutMapping("/v1")
  public AssemblyLineDto update(@RequestBody AssemblyLineDto assemblyLineDto) {
    return assemblyLineService.update(assemblyLineDto);
  }
  
  @PostMapping("/v1")
  public AssemblyLineDto insert(@RequestBody AssemblyLineDto assemblyLineDto) {

      return assemblyLineService.add(assemblyLineDto);
  }

}
