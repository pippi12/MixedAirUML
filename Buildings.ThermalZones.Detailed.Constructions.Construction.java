@startuml




Class Construction << model >>  {
 + extends Buildings.ThermalZones.Detailed.Constructions.BaseClasses.PartialConstruction   {    final AOpa=A  }  
}

PartialConstruction <|---up Construction
@enduml