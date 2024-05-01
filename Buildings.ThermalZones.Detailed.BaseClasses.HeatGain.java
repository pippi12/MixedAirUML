@startuml




Class HeatGain << model >>  {
 + parameter Modelica.Units.SI.Area AFlo 
 + Modelica.Blocks.Interfaces.RealInput qGai_flow [ 3 ]  
 + Modelica.Blocks.Interfaces.RealOutput QRad_flow  {  unit="W"  }   
 + Modelica.Blocks.Interfaces.RealOutput QCon_flow  {  unit="W"  }   
 + Modelica.Blocks.Interfaces.RealOutput QLat_flow  {  unit="W"  }   
 + {QRad_flow, QCon_flow, QLat_flow}( AFlo .* qGai_flow)
}

BaseIcon <|---up HeatGain

Area -down--* "AFlo"HeatGain

RealInput -down--* "qGai_flow[3]"HeatGain

RealOutput -down--* "QRad_flow"HeatGain

RealOutput -down--* "QCon_flow"HeatGain

RealOutput -down--* "QLat_flow"HeatGain
@enduml