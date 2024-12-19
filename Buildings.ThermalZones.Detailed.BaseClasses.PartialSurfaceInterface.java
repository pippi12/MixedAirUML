@startuml




 Class PartialSurfaceInterface << partial >>  {
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a conExt [ NConExt ]  
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a conExtWin [ NConExtWin ]  
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a conExtWinFra [ NConExtWin ]  
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a conPar_a [ NConPar ]  
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a conPar_b [ NConPar ]  
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a conBou [ NConBou ]  
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a conSurBou [ NSurBou ]  
 # final parameter String instanceName = getInstanceName  {    }   
 # final parameter Modelica.Units.SI.Area AConExt [ NConExt ] =datConExt.A 
 # final parameter Modelica.Units.SI.Area AConExtWinOpa [ NConExtWin ] =datConExtWin.AOpa 
 # final parameter Modelica.Units.SI.Area AConExtWinGla [ NConExtWin ] =  {  1 .- datConExtWin.fFra   }    .* datConExtWin.AWin 
 # final parameter Modelica.Units.SI.Area AConExtWinFra [ NConExtWin ] =datConExtWin.fFra .* datConExtWin.AWin 
 # final parameter Modelica.Units.SI.Area AConPar [ NConPar ] =datConPar.A 
 # final parameter Modelica.Units.SI.Area AConBou [ NConBou ] =datConBou.A 
 # final parameter Modelica.Units.SI.Area ASurBou [ NSurBou ] =surBou.A 
}

ConstructionRecords <|---up PartialSurfaceInterface

HeatPort_a -down--* "conExt[NConExt]"PartialSurfaceInterface

HeatPort_a -down--* "conExtWin[NConExtWin]"PartialSurfaceInterface

HeatPort_a -down--* "conExtWinFra[NConExtWin]"PartialSurfaceInterface

HeatPort_a -down--* "conPar_a[NConPar]"PartialSurfaceInterface

HeatPort_a -down--* "conPar_b[NConPar]"PartialSurfaceInterface

HeatPort_a -down--* "conBou[NConBou]"PartialSurfaceInterface

HeatPort_a -down--* "conSurBou[NSurBou]"PartialSurfaceInterface
@enduml