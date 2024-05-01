@startuml




 Class PartialAirHeatMassBalance << partial >>  {
 + parameter Integer nPorts=0 
 + parameter Boolean haveShade 
 + parameter Modelica.Units.SI.Volume V 
 + Modelica.Blocks.Interfaces.RealInput uSha [ NConExtWin ]  if haveShade 
 + Modelica.Blocks.Interfaces.RealInput QRadAbs_flow [ NConExtWin ]    {    each final unit="W"  }   if haveShade 
 + Modelica.Blocks.Interfaces.RealInput QCon_flow 
 + Modelica.Blocks.Interfaces.RealInput QLat_flow 
 + Modelica.Blocks.Interfaces.RealOutput TSha [ NConExtWin ]    {    each final unit="K", each final quantity=
 # final parameter Modelica.Units.SI.Area AConExt [ NConExt ] =datConExt.A 
 # final parameter Modelica.Units.SI.Area AConExtWinOpa [ NConExtWin ] =datConExtWin.AOpa 
 # final parameter Modelica.Units.SI.Area AConExtWinGla [ NConExtWin ] =  {  1 .- datConExtWin.fFra   }    .* datConExtWin.AWin 
 # final parameter Modelica.Units.SI.Area AConExtWinFra [ NConExtWin ] =datConExtWin.fFra .* datConExtWin.AWin 
 # final parameter Modelica.Units.SI.Area AConPar [ NConPar ] =datConPar.A 
 # final parameter Modelica.Units.SI.Area AConBou [ NConBou ] =datConBou.A 
 # final parameter Modelica.Units.SI.Area ASurBou [ NSurBou ] =surBou.A 
}

ConstructionRecords <|---up PartialAirHeatMassBalance

Modelica.Media.Interfaces.PartialMedium <|..-up "Medium"PartialAirHeatMassBalance

Volume -down--* "V"PartialAirHeatMassBalance

RealInput -down--* "uSha[NConExtWin]"PartialAirHeatMassBalance

RealInput -down--* "QRadAbs_flow[NConExtWin]"PartialAirHeatMassBalance

RealInput -down--* "QCon_flow"PartialAirHeatMassBalance

RealInput -down--* "QLat_flow"PartialAirHeatMassBalance

RealOutput -down--* "TSha[NConExtWin]"PartialAirHeatMassBalance

VesselFluidPorts_b -down--* "ports[nPorts]"PartialAirHeatMassBalance

HeatPort_a -down--* "heaPorAir"PartialAirHeatMassBalance

HeatPort_a -down--* "conExt[NConExt]"PartialAirHeatMassBalance

HeatPort_a -down--* "conExtWin[NConExtWin]"PartialAirHeatMassBalance

HeatPort_a -down--* "glaUns[NConExtWin]"PartialAirHeatMassBalance

HeatPort_a -down--* "glaSha[NConExtWin]"PartialAirHeatMassBalance

HeatPort_a -down--* "conExtWinFra[NConExtWin]"PartialAirHeatMassBalance

HeatPort_a -down--* "conPar_a[NConPar]"PartialAirHeatMassBalance

HeatPort_a -down--* "conPar_b[NConPar]"PartialAirHeatMassBalance

HeatPort_a -down--* "conBou[NConBou]"PartialAirHeatMassBalance

HeatPort_a -down--* "conSurBou[NSurBou]"PartialAirHeatMassBalance
@enduml