@startuml




Class PrescribedTemperature << model >>  {
 + Modelica.Blocks.Interfaces.RealInput T  {  unit=
 + port.T( T)
}

RealInput -down--* "T"PrescribedTemperature
@enduml