package it.euris.academy.teslabattery_cv.data.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "formula")
public class Formula {
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @OneToMany
  @JoinColumn(name="components")
  private List<Component> components;
  
  @OneToMany(mappedBy="formula")
  private List<AssemblyLine> assemblyLine;
  
  @Column(name="quantity")
  private String quantity;
  
  @Column(name = "unit")
  private String unit;
  
  
}
