@startuml




class	 Generic << record >>  {
 + parameter Modelica.Units.SI.Length x 
 + parameter Modelica.Units.SI.ThermalConductivity a_k 
 + parameter Real b_k  {  unit="W/  {  m.K2  }  "  }   
 + parameter Modelica.Units.SI.DynamicViscosity a_mu 
 + parameter Real b_mu  {  unit="N.s/  {  m2.K  }  "  }   
 + parameter Modelica.Units.SI.SpecificHeatCapacity a_c 
 + parameter Real b_c  {  unit="J/  {  kg.K2  }  "  }   
 + parameter Modelica.Units.SI.MolarMass MM 
 + parameter Modelica.Units.SI.Pressure P0=101325 
 + input Buildings.HeatTransfer.Data.Gases.Generic gas 
 + input Modelica.Units.SI.Temperature T 
 + input Buildings.HeatTransfer.Data.Gases.Generic gas 
 + input Modelica.Units.SI.Temperature T 
 + input Buildings.HeatTransfer.Data.Gases.Generic gas 
 + input Modelica.Units.SI.Temperature T 
 + input Buildings.HeatTransfer.Data.Gases.Generic gas 
 + input Modelica.Units.SI.Temperature T 
}

package -down--* "Gases"Gases

MaterialPropertiesPackage <|---up Gases

Record <|---up Gases

Length -down--* "x"Gases

ThermalConductivity -down--* "a_k"Gases

DynamicViscosity -down--* "a_mu"Gases

SpecificHeatCapacity -down--* "a_c"Gases

MolarMass -down--* "MM"Gases

Pressure -down--* "P0"Gases
@enduml