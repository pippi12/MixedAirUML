@startuml




class	 Generic << record >>  {
 + parameter Modelica.Units.SI.Length x=0.003 
 + parameter Modelica.Units.SI.ThermalConductivity k=1 
 + parameter Modelica.Units.SI.TransmissionCoefficient tauSol [ : ] ={0.6} 
 + parameter Modelica.Units.SI.ReflectionCoefficient rhoSol_a [ : ] ={0.075} 
 + parameter Modelica.Units.SI.ReflectionCoefficient rhoSol_b [ : ] ={0.075} 
 + parameter Modelica.Units.SI.TransmissionCoefficient tauIR=0 
 + parameter Modelica.Units.SI.Emissivity absIR_a=0.84 
 + parameter Modelica.Units.SI.Emissivity absIR_b=0.84 
}

package -down--* "Glasses"Glasses

MaterialPropertiesPackage <|---up Glasses

Record <|---up Glasses

Length -down--* "x"Glasses

ThermalConductivity -down--* "k"Glasses

TransmissionCoefficient -down--* "tauSol[:]"Glasses

ReflectionCoefficient -down--* "rhoSol_a[:]"Glasses

ReflectionCoefficient -down--* "rhoSol_b[:]"Glasses

TransmissionCoefficient -down--* "tauIR"Glasses

Emissivity -down--* "absIR_a"Glasses

Emissivity -down--* "absIR_b"Glasses
@enduml