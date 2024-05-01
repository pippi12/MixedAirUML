@startuml




 Class PartialConstruction << partial >>  {
 + parameter Modelica.Units.SI.Area A 
 + parameter Modelica.Units.SI.Area AOpa 
 + parameter Buildings.HeatTransfer.Data.OpaqueConstructions.Generic layers 
 + parameter Modelica.Units.SI.Angle til 
 + final parameter Boolean is_floor=til > 2.74889125 and til < 3.53428875 
 + final parameter Boolean is_ceiling=til > -0.392699 and til < 0.392699 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a opa_a 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_b opa_b 
 + final parameter Integer nLay  {  min=1, fixed=true  }   = size  {  layers.material, 1  }   
 + final parameter Integer nSta [ nLay ]   {  each min=1  }  = {layers.material [ i ] .nSta for i in 1:nLay} 
 + parameter Boolean steadyStateInitial=false 
 + parameter Modelica.Units.SI.Temperature T_a_start=293.15 
 + parameter Modelica.Units.SI.Temperature T_b_start=293.15 
 + parameter Boolean stateAtSurface_a=true 
 + parameter Boolean stateAtSurface_b=true 
 + connect  (  opa.port_a, opa_a )  annotation   (  Line  (   point({{-52,200},{-300,200}}, color={191,0,0}, smooth=Smooth.None )  ) )
 + connect  (  opa.port_b, opa_b )  annotation   (  Line  (   point({{52,200},{302,200}}, color={191,0,0}, smooth=Smooth.None )  )   )
}

Area -down--* "A"PartialConstruction

Area -down--* "AOpa"PartialConstruction

Generic -down--* "layers"PartialConstruction

Angle -down--* "til"PartialConstruction

HeatPort_a -down--* "opa_a"PartialConstruction

HeatPort_b -down--* "opa_b"PartialConstruction

Temperature -down--* "T_a_start"PartialConstruction

Temperature -down--* "T_b_start"PartialConstruction
@enduml