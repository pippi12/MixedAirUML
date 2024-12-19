@startuml




 Class PartialSurfaceInterfaceRadiative << partial >>  {
 # parameter Modelica.Units.SI.Emissivity epsConExt [ NConExt ] =datConExt.layers.absIR_b 
 # parameter Modelica.Units.SI.Emissivity epsConExtWinOpa [ NConExtWin ] = datConExtWin.layers.absIR_b 
 # parameter Modelica.Units.SI.Emissivity epsConExtWinUns [ NConExtWin ] ={  {   datConExtWin [ i ] .glaSys.glass [ size   {   datConExtWin [ i ] .glaSys.glass, 1  }   ] .absIR_b  }   for i in 1:NConExtWin} 
 # parameter Modelica.Units.SI.Emissivity epsConExtWinSha [ NConExtWin ] = datConExtWin.glaSys.shade.absIR_a 
 # parameter Modelica.Units.SI.Emissivity epsConExtWinFra [ NConExtWin ] = datConExtWin.glaSys.absIRFra 
 # parameter Modelica.Units.SI.Emissivity epsConPar_a [ NConPar ] =datConPar.layers.absIR_a 
 # parameter Modelica.Units.SI.Emissivity epsConPar_b [ NConPar ] =datConPar.layers.absIR_b 
 # parameter Modelica.Units.SI.Emissivity epsConBou [ NConBou ] =datConBou.layers.absIR_b 
 # parameter Modelica.Units.SI.Emissivity epsSurBou [ NSurBou ] =surBou.absIR 
}

PartialSurfaceInterface <|---up PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConExt[NConExt]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConExtWinOpa[NConExtWin]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConExtWinUns[NConExtWin]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConExtWinSha[NConExtWin]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConExtWinFra[NConExtWin]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConPar_a[NConPar]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConPar_b[NConPar]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsConBou[NConBou]"PartialSurfaceInterfaceRadiative

Emissivity -down--* "epsSurBou[NSurBou]"PartialSurfaceInterfaceRadiative
@enduml