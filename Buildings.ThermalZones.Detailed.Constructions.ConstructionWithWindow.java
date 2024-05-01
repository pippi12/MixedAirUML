@startuml




Class ConstructionWithWindow << model >>  {
 + extends Buildings.ThermalZones.Detailed.Constructions.BaseClasses.PartialConstruction   {    final AOpa=A-AWin  }  
 + constant Boolean homotopyInitialization = true 
 + parameter Modelica.Units.SI.Area AWin 
 + parameter Real fFra   {    min=0, max=1  }   = 0.1 
 + final parameter Modelica.Units.SI.Area AFra=fFra*AWin 
 + final parameter Modelica.Units.SI.Area AGla=AWin - AFra 
 + parameter Boolean linearizeRadiation = true 
 + parameter Boolean steadyStateWindow = false 
 + replaceable parameter HeatTransfer.Data.GlazingSystems.Generic glaSys 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a glaUns_a 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a glaSha_a if haveShade 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a fra_a 
 + Modelica.Blocks.Interfaces.RealInput uSha  {  min=0, max=1  }   if haveShade 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_b glaUns_b 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_b glaSha_b if haveShade 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_b fra_b 
 + Modelica.Blocks.Interfaces.RealInput QAbsUns_flow [ size   {   glaSys.glass, 1  }   ]    {    each unit="W", each quantity=
 + Modelica.Blocks.Interfaces.RealInput QAbsSha_flow [ size   {   glaSys.glass, 1  }   ]    {    each unit="W", each quantity=
 # final parameter Boolean haveShade = glaSys.haveExteriorShade or glaSys.haveInteriorShade 
 # (assert  (  homotopyInitialization, "In " + getInstanceName  (   )  + ": The constant homotopyInitialization has been modified from its default value. This constant will be removed in future releases.", level = AssertionLevel.warning )  )
 + connect  (  win.uSha, uSha )  annotation   (  Line  (   point({{-125.3,19.4},{-178.75,19.4},{-178.75,60},{-320,60}}, color={0,0,127}, smooth=Smooth.None )  ) )
 + connect  (  JInUns_a, win.JInUns_a )  annotation   (  Line  (   point({{-310,20},{-200,20},{-200,-3.2},{-119.65,-3.2}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  JOutUns_a, win.JOutUns_a )  annotation   (  Line  (   point({{-310,-20},{-220,-20},{-220,-25.8},{-119.65,-25.8}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  win.glaUns_a, glaUns_a )  annotation   (  Line  (   point({{-114,-59.7},{-200,-59.7},{-200,-80},{-300,-80}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.glaSha_a, glaSha_a )  annotation   (  Line  (   point({{-114,-82.3},{-180,-82.3},{-180,-120},{-300,-120}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.JInSha_a, JInSha_a )  annotation   (  Line  (   point({{-119.65,-104.9},{-162,-104.9},{-162,-160},{-310,-160}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.JOutSha_a, JOutSha_a )  annotation   (  Line  (   point({{-119.65,-127.5},{-139.375,-127.5},{-139.375,-200},{-310,-200}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  win.fra_a, fra_a )  annotation   (  Line  (   point({{-114,-161.4},{-128,-161.4},{-128,-260},{-300,-260}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.JOutUns_b, JOutUns_b )  annotation   (  Line  (   point({{117.65,-3.2},{225.375,-3.2},{225.375,20},{310,20}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  win.JInUns_b, JInUns_b )  annotation   (  Line  (   point({{117.65,-25.8},{233.375,-25.8},{233.375,-20},{310,-20}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.glaUns_b, glaUns_b )  annotation   (  Line  (   point({{112,-59.7},{239,-59.7},{239,-80},{300,-80}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.glaSha_b, glaSha_b )  annotation   (  Line  (   point({{112,-82.3},{220,-82.3},{220,-120},{300,-120}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.JOutSha_b, JOutSha_b )  annotation   (  Line  (   point({{117.65,-104.9},{201.375,-104.9},{201.375,-160},{310,-160}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  win.JInSha_b, JInSha_b )  annotation   (  Line  (   point({{117.65,-127.5},{178.375,-127.5},{178.375,-200},{310,-200}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.fra_b, fra_b )  annotation   (  Line  (   point({{113.13,-161.4},{159.675,-161.4},{159.675,-260},{302,-260}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  opa.port_a, opa_a )                  annotation   (  Line  (   point({{-52,200},{-300,200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  opa.port_b, opa_b )                  annotation   (  Line  (   point({{52,200},{302,200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  win.QAbsUns_flow, QAbsUns_flow )  annotation   (  Line  (   point({{-46.2,-195.3},{-46.2,-280},{-40,-280},{-40,-320}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  win.QAbsSha_flow, QAbsSha_flow )  annotation   (  Line  (   point({{44.2,-195.3},{44.2,-280},{100,-280},{100,-320}}, color={0,0,127}, smooth=Smooth.None )  )   )
}

PartialConstruction <|---up ConstructionWithWindow

Area -down--* "AWin"ConstructionWithWindow

parameter <|..-up "HeatTransfer.Data.GlazingSystems.Generic"ConstructionWithWindow

HeatPort_a -down--* "glaUns_a"ConstructionWithWindow

HeatPort_a -down--* "glaSha_a"ConstructionWithWindow

HeatPort_a -down--* "fra_a"ConstructionWithWindow

RealInput -down--* "uSha"ConstructionWithWindow

HeatPort_b -down--* "glaUns_b"ConstructionWithWindow

HeatPort_b -down--* "glaSha_b"ConstructionWithWindow

HeatPort_b -down--* "fra_b"ConstructionWithWindow

RealInput -down--* "QAbsUns_flow[size"ConstructionWithWindow

RealInput -down--* "QAbsSha_flow[size"ConstructionWithWindow
@enduml