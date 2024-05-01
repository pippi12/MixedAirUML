@startuml




class	 ParameterConstructionWithWindow << record >>  {
 + parameter Modelica.Units.SI.Area A 
 + parameter Modelica.Units.SI.Length hWin 
 + parameter Modelica.Units.SI.Length wWin 
 + final parameter Modelica.Units.SI.Area AWin=hWin*wWin 
 + final parameter Modelica.Units.SI.Area AOpa=A - AWin 
 + parameter Real fFra   {    final min=0, final max=1  }   = 0.1 
 + parameter Buildings.ThermalZones.Detailed.BaseClasses.Overhang ove   {    wR=0, wL=0, dep=0, gap=0  }   
 + parameter Buildings.ThermalZones.Detailed.BaseClasses.SideFins sidFin  {  h=0, dep=0, gap=0  }   
 + final parameter Modelica.Units.SI.Area AFra=fFra*AWin 
 + final parameter Modelica.Units.SI.Area AGla=AWin - AFra 
 + parameter HeatTransfer.Data.GlazingSystems.Generic glaSys 
 + final parameter Boolean haveOverhangOrSideFins =   {  ove.dep > 1E-8  }   or   {  sidFin.dep > 1E-8  }   
}

PartialParameterConstruction <|---up ParameterConstructionWithWindow

Area -down--* "A"ParameterConstructionWithWindow

Length -down--* "hWin"ParameterConstructionWithWindow

Length -down--* "wWin"ParameterConstructionWithWindow

Overhang -down--* "ove"ParameterConstructionWithWindow

SideFins -down--* "sidFin"ParameterConstructionWithWindow

Generic -down--* "glaSys"ParameterConstructionWithWindow
@enduml