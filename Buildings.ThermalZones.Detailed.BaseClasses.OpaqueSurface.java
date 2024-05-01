@startuml




class	 OpaqueSurface << record >>  {
 + parameter String name = "" 
 + parameter Buildings.ThermalZones.Detailed.Types.CFDBoundaryConditions boundaryCondition= Buildings.ThermalZones.Detailed.Types.CFDBoundaryConditions.Temperature 
}

Generic <|---up OpaqueSurface

CFDBoundaryConditions -down--* "boundaryCondition"OpaqueSurface
@enduml