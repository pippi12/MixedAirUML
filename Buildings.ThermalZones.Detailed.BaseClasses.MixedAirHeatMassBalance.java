@startuml




Class MixedAirHeatMassBalance << model >>  {
 + constant Boolean homotopyInitialization = true 
 + parameter Modelica.Units.SI.MassFlowRate m_flow_nominal  {  min=0  }   
 + parameter Buildings.HeatTransfer.Types.InteriorConvection conMod 
 + parameter Modelica.Units.SI.CoefficientOfHeatTransfer hFixed 
 + parameter Boolean use_C_flow 
 + Modelica.Blocks.Interfaces.RealInput C_flow [ Medium.nC ]  if use_C_flow 
 # constant Modelica.Units.SI.SpecificEnergy h_fg= Buildings.Media.Air.enthalpyOfCondensingGas   {   273.15 + 37  }   
 # Modelica.Blocks.Math.Gain mWat_flow   {    final k  {  unit="kg/J"  }  =1/h_fg, u  {  final unit=
 # (assert  (  homotopyInitialization, "In " + getInstanceName  (   )  + ": The constant homotopyInitialization has been modified from its default value. This constant will be removed in future releases.", level = AssertionLevel.warning )  )
 + connect  (  convConPar_a.fluid,theConConPar_a.port_a )  annotation   (  Line  (   point({{100,-60},{62,-60}}, color={191,0,0}, smooth=Smooth.None )  ) )
 + connect  (  convConPar_b.fluid,theConConPar_b.port_a )  annotation   (  Line  (   point({{100,-100},{60,-100}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConBou.fluid,theConConBou.port_a )  annotation   (  Line  (   point({{100,-160},{60,-160}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convSurBou.fluid,theConSurBou.port_a )  annotation   (  Line  (   point({{102,-220},{62,-220}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  theConConPar_a.port_b,vol.heatPort )  annotation   (  Line  (   point({{42,-60},{20,-60},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  theConConPar_b.port_b,vol.heatPort )  annotation   (  Line  (   point({{40,-100},{20,-100},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  theConConBou.port_b,vol.heatPort )  annotation   (  Line  (   point({{40,-160},{20,-160},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  theConSurBou.port_b,vol.heatPort )  annotation   (  Line  (   point({{42,-220},{20,-220},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWinFra,convConWin.frame )  annotation   (  Line  (   point({{242,4.44089e-16},{160,4.44089e-16},{160,100},{115,100},{115,110}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConExt.solid, conExt )  annotation   (  Line  (   point({{120,220},{240,220}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConExt.fluid,theConConExt.port_a )  annotation   (  Line  (   point({{100,220},{58,220}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  theConConExt.port_b,vol.heatPort )  annotation   (  Line  (   point({{38,220},{20,220},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  theConConExtWin.port_b,vol.heatPort )  annotation   (  Line  (   point({{38,180},{20,180},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConExtWin.fluid,theConConExtWin.port_a )  annotation   (  Line  (   point({{100,180},{58,180}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConExtWin.solid, conExtWin )  annotation   (  Line  (   point({{120,180},{240,180}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  theConConWin.port_b,vol.heatPort )  annotation   (  Line  (   point({{40,120},{20,120},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConWin.air,theConConWin.port_a )  annotation   (  Line  (   point({{98,120},{60,120}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConWin.glaSha, glaSha )  annotation   (  Line  (   point({{118,118},{166,118},{166,80},{240,80}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConWin.glaUns, glaUns )  annotation   (  Line  (   point({{118,122},{180,122},{180,120},{240,120}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConPar_a.solid, conPar_a )  annotation   (  Line  (   point({{120,-60},{242,-60}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConPar_b.solid, conPar_b )  annotation   (  Line  (   point({{120,-100},{242,-100}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convConBou.solid, conBou )  annotation   (  Line  (   point({{120,-160},{242,-160}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  convSurBou.solid, conSurBou )  annotation   (  Line  (   point({{122,-220},{241,-220}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + (for i in 1:nPorts loop connect  (  vol.ports[i], ports[i] )  annotation   (  Line  (   points={{0,-210},{0,-238}}, color={0,127,255}, smooth=Smooth.None )  )  ;;end for ;;)
 + connect  (  heaPorAir, vol.heatPort )  annotation   (  Line  (   point({{-240,0},{20,0},{20,-200},{10,-200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  uSha, convConWin.uSha )  annotation   (  Line  (   point({{-260,200},{0,200},{0,150},{82,150},{82,128},{97.2,128}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  convConWin.QRadAbs_flow, QRadAbs_flow )  annotation   (  Line  (   point({{102,109},{102,90},{-260,90}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  convConWin.TSha, TSha )  annotation   (  Line  (   point({{108,109},{108,60},{-250,60}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect ( conQCon_flow.port, vol.heatPort )  annotation  ( Line ( point({{-200,-100}, {-118,-100},{20,-100},{20,-200},{10,-200}},           color={191,0,0} )  )   )
 + connect ( QCon_flow, conQCon_flow.Q_flow )  annotation  ( Line ( point({{-260,-100},{ -240,-100},{-220,-100}}, color={0,0,127} )  )   )
 + connect  (  QLat_flow, mWat_flow.u )  annotation  ( Line ( point({{-260,-160},{-222,-160}}, color={0,0,127} )  )   )
 + connect ( mWat_flow.y, vol.mWat_flow )  annotation  ( Line ( point({{-199,-160},{-168, -160},{-168,-212},{-30,-212},{-30,-180},{16,-180},{16,-192},{12,-192}}, color={0,0,127} )  )   )
 + connect ( conQLat_flow.Q_flow, QLat_flow )  annotation  ( Line ( point({{-220,-80},{-230, -80},{-230,-160},{-260,-160}}, color={0,0,127} )  )   )
 + connect ( conQLat_flow.port, vol.heatPort )  annotation  ( Line ( point({{-200,-80},{ -96,-80},{20,-80},{20,-200},{10,-200}}, color={191,0,0} )  )   )
 + connect ( vol.C_flow, C_flow )  annotation  ( Line ( point({{12,-206},{16,-206},{16,-220}, {-260,-220}}, color={0,0,127} )  )   )
}

PartialAirHeatMassBalance <|---up MixedAirHeatMassBalance

LumpedVolumeDeclarations <|---up MixedAirHeatMassBalance

MassFlowRate -down--* "m_flow_nominal"MixedAirHeatMassBalance

InteriorConvection -down--* "conMod"MixedAirHeatMassBalance

CoefficientOfHeatTransfer -down--* "hFixed"MixedAirHeatMassBalance

RealInput -down--* "C_flow[Medium.nC]"MixedAirHeatMassBalance

Gain -down--* "mWat_flow"MixedAirHeatMassBalance

ThermalCollector -down--* "theConConExt"MixedAirHeatMassBalance

ThermalCollector -down--* "theConConExtWin"MixedAirHeatMassBalance

ThermalCollector -down--* "theConConWin"MixedAirHeatMassBalance

ThermalCollector -down--* "theConConPar_a"MixedAirHeatMassBalance

ThermalCollector -down--* "theConConPar_b"MixedAirHeatMassBalance

ThermalCollector -down--* "theConConBou"MixedAirHeatMassBalance

ThermalCollector -down--* "theConSurBou"MixedAirHeatMassBalance
@enduml