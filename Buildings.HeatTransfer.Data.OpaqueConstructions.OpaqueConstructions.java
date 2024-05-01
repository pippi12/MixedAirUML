@startuml




class	 Generic << record >>  {
 + parameter Integer nLay  {  min=1  }   
 + parameter Buildings.HeatTransfer.Data.BaseClasses.Material material [ nLay ]  
 + final parameter Real R  {  unit="m2.K/W"  }  =sum  {  material [ i ] .R for i in 1:nLay  }   
 + final parameter Integer nSta [ nLay ]   {  each min=1  }   = {material [ i ] .nSta for i in 1:nLay} 
 + parameter Modelica.Units.SI.Emissivity absIR_a=0.9 
 + parameter Modelica.Units.SI.Emissivity absIR_b=0.9 
 + parameter Modelica.Units.SI.Emissivity absSol_a=0.5 
 + parameter Modelica.Units.SI.Emissivity absSol_b=0.5 
 + parameter Buildings.HeatTransfer.Types.SurfaceRoughness roughness_a= Buildings.HeatTransfer.Types.SurfaceRoughness.Medium 
}

package -down--* "OpaqueConstructions"OpaqueConstructions

MaterialPropertiesPackage <|---up OpaqueConstructions

Material -down--* "material[nLay]"OpaqueConstructions

Emissivity -down--* "absIR_a"OpaqueConstructions

Emissivity -down--* "absIR_b"OpaqueConstructions

Emissivity -down--* "absSol_a"OpaqueConstructions

Emissivity -down--* "absSol_b"OpaqueConstructions

SurfaceRoughness -down--* "roughness_a"OpaqueConstructions
@enduml