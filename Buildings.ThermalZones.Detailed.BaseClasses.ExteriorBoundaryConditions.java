@startuml




Class ExteriorBoundaryConditions << model >>  {
 + parameter Integer nCon  {  min=1  }   
 + parameter Boolean linearizeRadiation 
 + replaceable parameter ParameterConstruction conPar [ nCon ]  constrainedby ParameterConstruction 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a opa_a [ nCon ]  
 + parameter Buildings.HeatTransfer.Types.ExteriorConvection conMod= Buildings.HeatTransfer.Types.ExteriorConvection.TemperatureWind 
 + parameter Modelica.Units.SI.CoefficientOfHeatTransfer hFixed=10.0 
 + Modelica.Blocks.Math.Add HTotConExt [ nCon ]    {    final k1=conPar [ : ] .layers.absSol_a .* AOpa, final k2=conPar [ : ] .layers.absSol_a .* AOpa  }   
 # parameter Modelica.Units.SI.Area AOpa [ nCon ] =conPar [ : ] .A 
 # Modelica.Blocks.Routing.Replicator repConExt  {  nout=nCon  }   
 # Modelica.Blocks.Routing.Replicator repConExt1   {    nout=nCon  }   
 # Modelica.Blocks.Routing.Replicator repConExt2   {    nout=nCon  }   
 + connect  (  conOpa.solid, opa_a )  annotation   (  Line  (   point({{-180,180},{-240,180},{-240,200},{-300,200}}, color={191,0,0}, smooth=Smooth.None )  ) )
 + connect  (  skyRadExc.port, opa_a )  annotation   (  Line  (   point({{-180,260},{-212,260},{-212,260},{-240,260},{-240,200},{-300,200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  TAirConExt.port, conOpa.fluid )  annotation   (  Line  (   point({{-32,180},{-140,180}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  repConExt.y, TAirConExt.T )  annotation   (  Line  (   point({{79,180},{12,180}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  repConExt.u, weaBus.TDryBul )  annotation   (  Line  (   point({{102,180},{244,180},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  skyRadExc.TOut, weaBus.TDryBul )  annotation   (  Line  (   point({{-136,252},{244,252},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  skyRadExc.TBlaSky, weaBus.TBlaSky )  annotation   (  Line  (   point({{-136,268},{244,268},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + (for i in 1:nCon loop connect  (  weaBus, HDirTil[i].weaBus )  annotation   (  Line  (   points={{244,42},{244,130},{220,130}}, color={255,204,51}, thickness=0.5, smooth=Smooth.None ) , Text (  textString;connect  (  HDifTil[i].weaBus, weaBus )  annotation   (  Line  (   points={{220,90},{244,90},{244,42}}, color={255,204,51}, thickness=0.5, smooth=Smooth.None ) , Text (  textString;end for ;;)
 + connect  (  HTotConExt.y, solHeaGaiConExt.Q_flow )  annotation   (  Line  (   point({{19,110},{5.55112e-16,110}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  solHeaGaiConExt.port, opa_a )  annotation   (  Line  (   point({{-20,110},{-240,110},{-240,200},{-300,200}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  HDirTil.H, HTotConExt.u1 )  annotation   (  Line  (   point({{199,130},{60,130},{60,116},{42,116}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  HDifTil.H, HTotConExt.u2 )  annotation   (  Line  (   point({{199,90},{60,90},{60,104},{42,104}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  repConExt2.u, weaBus.winDir )  annotation   (  Line  (   point({{182,230},{244,230},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  repConExt1.u, weaBus.winSpe )  annotation   (  Line  (   point({{132,210},{244,210},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  repConExt1.y, conOpa.v )  annotation   (  Line  (   point({{109,210},{-194,210},{-194,200},{-184,200}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  repConExt2.y, conOpa.dir )  annotation   (  Line  (   point({{159,230},{-200,230},{-200,190},{-184,190}}, color={0,0,127}, smooth=Smooth.None )  )   )
}

parameter <|..-up "ParameterConstruction"ExteriorBoundaryConditions

HeatPort_a -down--* "opa_a[nCon]"ExteriorBoundaryConditions

ExteriorConvection -down--* "conMod"ExteriorBoundaryConditions

CoefficientOfHeatTransfer -down--* "hFixed"ExteriorBoundaryConditions

SkyRadiationExchange -down--* "skyRadExc"ExteriorBoundaryConditions

Add -down--* "HTotConExt[nCon]"ExteriorBoundaryConditions

PrescribedHeatFlow -down--* "solHeaGaiConExt[nCon]"ExteriorBoundaryConditions

Area -down--* "AOpa[nCon]"ExteriorBoundaryConditions

PrescribedTemperature -down--* "TAirConExt["ExteriorBoundaryConditions

Replicator -down--* "repConExt"ExteriorBoundaryConditions

Replicator -down--* "repConExt1"ExteriorBoundaryConditions

Replicator -down--* "repConExt2"ExteriorBoundaryConditions
@enduml