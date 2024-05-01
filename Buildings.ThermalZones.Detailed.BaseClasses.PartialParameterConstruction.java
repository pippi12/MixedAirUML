@startuml




class	 PartialParameterConstruction << record >>  {
 + parameter String name = "" 
 + parameter Buildings.HeatTransfer.Data.OpaqueConstructions.Generic layers 
 + parameter Modelica.Units.SI.Angle til 
 + parameter Modelica.Units.SI.Angle azi 
 + final parameter Boolean is_floor=til > 2.74889125 and til < 3.53428875 
 + final parameter Boolean is_ceiling=til > -0.392699 and til < 0.392699 
 + parameter Boolean steadyStateInitial=false 
 + parameter Modelica.Units.SI.Temperature T_a_start=293.15 
 + parameter Modelica.Units.SI.Temperature T_b_start=293.15 
 + parameter Boolean stateAtSurface_a=true 
 + parameter Boolean stateAtSurface_b=true 
 + parameter Buildings.ThermalZones.Detailed.Types.CFDBoundaryConditions boundaryCondition= Buildings.ThermalZones.Detailed.Types.CFDBoundaryConditions.Temperature 
}

Record <|---up PartialParameterConstruction

Generic -down--* "layers"PartialParameterConstruction

Angle -down--* "til"PartialParameterConstruction

Angle -down--* "azi"PartialParameterConstruction

Temperature -down--* "T_a_start"PartialParameterConstruction

Temperature -down--* "T_b_start"PartialParameterConstruction

CFDBoundaryConditions -down--* "boundaryCondition"PartialParameterConstruction
@enduml