@startuml




class	 ConstructionRecords << record >>  {
 + parameter ParameterConstruction datConExt [ NConExt ]    {    each A=0, each layers = dummyCon, each til=0, each azi=0  }   
 + parameter Buildings.ThermalZones.Detailed.BaseClasses.ParameterConstructionWithWindow datConExtWin [ NConExtWin ]    {    each A=0, each layers = dummyCon, each til=0, each azi=0, each hWin=0, each wWin=0, each glaSys=dummyGlaSys  }   
 + parameter Buildings.ThermalZones.Detailed.BaseClasses.ParameterConstruction datConPar [ NConPar ]    {    each A=0, each layers = dummyCon, each til=0, each azi=0  }   
 + parameter Buildings.ThermalZones.Detailed.BaseClasses.ParameterConstruction datConBou [ NConBou ]    {    each A=0, each layers = dummyCon, each til=0, each azi=0  }   
 + parameter Buildings.ThermalZones.Detailed.BaseClasses.OpaqueSurface surBou [ NSurBou ]    {    each A=0, each til=0  }   
 + parameter HeatTransfer.Data.OpaqueConstructions.Brick120 dummyCon 
 + parameter Buildings.HeatTransfer.Data.GlazingSystems.SingleClear3 dummyGlaSys 
}

ConstructionNumbers <|---up ConstructionRecords

ParameterConstructionWithWindow -down--* "datConExtWin[NConExtWin]"ConstructionRecords

ParameterConstruction -down--* "datConPar[NConPar]"ConstructionRecords

ParameterConstruction -down--* "datConBou[NConBou]"ConstructionRecords

OpaqueSurface -down--* "surBou[NSurBou]"ConstructionRecords

Brick120 -down--* "dummyCon"ConstructionRecords

SingleClear3 -down--* "dummyGlaSys"ConstructionRecords
@enduml