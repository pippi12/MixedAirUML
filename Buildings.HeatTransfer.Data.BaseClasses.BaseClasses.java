@startuml




class	 Material << record >>  {
 + parameter Modelica.Units.SI.Length x 
 + parameter Modelica.Units.SI.ThermalConductivity k 
 + parameter Modelica.Units.SI.SpecificHeatCapacity c 
 + parameter Modelica.Units.SI.Density d  {  displayUnit="kg/m3"  }   
 + parameter Real R  {  unit="m2.K/W"  }   
 + parameter Integer nStaRef  {  min=0  }   = 3 
 + parameter Integer nSta  {  min=1  }  =max  {  1, integer  {  ceil  {  nStaReal  }    }    }   
 + parameter Boolean steadyState=   {  c < Modelica.Constants.eps or d < Modelica.Constants.eps  }   
 + parameter Real piRef=331.4 
 + parameter Real piMat=if steadyState then piRef else x*sqrt  {  c*d/k  }   
 + parameter Real nStaReal  {  min=0  }   = nStaRef*piMat/piRef 
 + parameter Modelica.Units.SI.Temperature TSol 
 + parameter Modelica.Units.SI.Temperature TLiq 
 + parameter Modelica.Units.SI.SpecificInternalEnergy LHea 
 + constant Boolean ensureMonotonicity = false 
 + constant Boolean phasechange = false 
 + parameter Modelica.Units.SI.ThermalConductivity k 
 + parameter Modelica.Units.SI.SpecificHeatCapacity c 
 + parameter Modelica.Units.SI.Density d  {  displayUnit="kg/m3"  }   
 + parameter Boolean steadyState=   {  c < Modelica.Constants.eps or d < Modelica.Constants.eps  }   
}

package -down--* "BaseClasses"BaseClasses

BasesPackage <|---up BaseClasses

Record <|---up BaseClasses

Length -down--* "x"BaseClasses

ThermalConductivity -down--* "k"BaseClasses

SpecificHeatCapacity -down--* "c"BaseClasses

Density -down--* "d"BaseClasses

Temperature -down--* "TSol"BaseClasses

Temperature -down--* "TLiq"BaseClasses

SpecificInternalEnergy -down--* "LHea"BaseClasses
@enduml