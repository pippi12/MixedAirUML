@startuml




class	 ParameterConstruction << record >>  {
 + parameter Modelica.Units.SI.Area A 
}

PartialParameterConstruction <|---up ParameterConstruction

Area -down--* "A"ParameterConstruction
@enduml