@startuml




class	 Generic << record >>  {
 + parameter Modelica.Units.SI.TransmissionCoefficient tauSol_a=0.1 
 + parameter Modelica.Units.SI.TransmissionCoefficient tauSol_b=0.1 
 + parameter Modelica.Units.SI.ReflectionCoefficient rhoSol_a=0.8 
 + parameter Modelica.Units.SI.ReflectionCoefficient rhoSol_b=0.8 
 + parameter Modelica.Units.SI.Emissivity absIR_a=0.84 
 + parameter Modelica.Units.SI.Emissivity absIR_b=0.84 
 + parameter Modelica.Units.SI.TransmissionCoefficient tauIR_a=0 
 + parameter Modelica.Units.SI.TransmissionCoefficient tauIR_b=0 
}

package -down--* "Shades"Shades

MaterialPropertiesPackage <|---up Shades

Record <|---up Shades

TransmissionCoefficient -down--* "tauSol_a"Shades

TransmissionCoefficient -down--* "tauSol_b"Shades

ReflectionCoefficient -down--* "rhoSol_a"Shades

ReflectionCoefficient -down--* "rhoSol_b"Shades

Emissivity -down--* "absIR_a"Shades

Emissivity -down--* "absIR_b"Shades

TransmissionCoefficient -down--* "tauIR_a"Shades

TransmissionCoefficient -down--* "tauIR_b"Shades
@enduml