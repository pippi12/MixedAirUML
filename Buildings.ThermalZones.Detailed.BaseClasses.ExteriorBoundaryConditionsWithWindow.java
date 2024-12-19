@startuml




Class ExteriorBoundaryConditionsWithWindow << model >>  {
 + extends Buildings.ThermalZones.Detailed.BaseClasses.ExteriorBoundaryConditions   {    final AOpa=conPar [ : ] .AOpa, redeclare Buildings.ThermalZones.Detailed.BaseClasses.ParameterConstructionWithWindow conPar   }   
 + final parameter Modelica.Units.SI.Area AWin [ nCon ] =conPar [ : ] .hWin .* conPar [ : ] .wWin 
 + final parameter Boolean haveExteriorShade [ nCon ]  = conPar [ : ] .glaSys.haveExteriorShade 
 + final parameter Boolean haveInteriorShade [ nCon ]  = conPar [ : ] .glaSys.haveInteriorShade 
 + final parameter Boolean haveShade= Modelica.Math.BooleanVectors.anyTrue   {   haveExteriorShade  }   or Modelica.Math.BooleanVectors.anyTrue   {   haveInteriorShade  }   
 + final parameter Boolean haveOverhangOrSideFins= Modelica.Math.BooleanVectors.anyTrue   {   conPar.haveOverhangOrSideFins  }   
 + Modelica.Blocks.Interfaces.RealInput uSha [ nCon ]    {    each min=0, each max=1  }   if haveShade 
 + Modelica.Blocks.Interfaces.RealInput QAbsSolSha_flow [ nCon ]    {    each final unit="W", each quantity=
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a glaUns [ nCon ]  
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a glaSha [ nCon ]  if haveShade 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a fra [ nCon ]    {    each T   {    nominal=300, start=283.15  }    }   
 + Modelica.Blocks.Math.Add HTotConExtWinFra [ nCon ]    {    final k1=conPar [ : ] .fFra .* conPar [ : ] .glaSys.absSolFra .* conPar [ : ] .AWin, final k2=conPar [ : ] .fFra .* conPar [ : ] .glaSys.absSolFra .* conPar [ : ] .AWin  }   
 + Modelica.Blocks.Interfaces.RealOutput HDir [ nCon ]    {    each final quantity="RadiantEnergyFluenceRate", each final unit=
 + Modelica.Blocks.Interfaces.RealOutput HDif [ nCon ]    {    each final quantity="RadiantEnergyFluenceRate", each final unit=
 + Modelica.Blocks.Interfaces.RealOutput inc [ nCon ]    {    each final quantity="Angle", each final unit=
 # Modelica.Blocks.Routing.Replicator repConExtWin  {  final nout=nCon  }   
 # Modelica.Blocks.Routing.Replicator repConExtWinVWin  {  final nout=nCon  }   
 # Modelica.Blocks.Routing.Replicator repConExtWinTSkyBla  {  final nout=nCon  }   
 + connect  (  uSha, conExtWin.uSha )  annotation   (  Line  (   point({{-320,100},{-140,100},{-140,-40},{40,-40},{40,-66},{22.4,-66}}, color={0,0,127}, smooth=Smooth.None )  ) )
 + connect  (  JInUns,conExtWin. JInUns )  annotation   (  Line  (   point({{-310,20},{-200,20},{-200,-72},{-43,-72}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.JOutUns,JOutUns )   annotation   (  Line  (   point({{-43,-66},{-196.45,-66},{-196.45,-20},{-310,-20}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.glaUns,glaUns )   annotation   (  Line  (   point({{-40,-84},{-192,-84},{-192,-80},{-300,-80}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.glaSha,glaSha )   annotation   (  Line  (   point({{-40,-96},{-190,-96},{-190,-120},{-300,-120}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.JOutSha,JOutSha )   annotation   (  Line  (   point({{-43,-108},{-176,-108},{-176,-200},{-310,-200}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.JInSha,JInSha )   annotation   (  Line  (   point({{-43,-114},{-184.45,-114},{-184.45,-160},{-310,-160}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.frame,fra )   annotation   (  Line  (   point({{-31,-120},{-31,-220},{-260,-220},{-260,-260},{-300,-260}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  TAirConExtWin.port,conExtWin. air )  annotation   (  Line  (   point({{120,-70},{90,-70},{90,-90},{20,-90}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  TAirConExtWin.T,repConExtWin. y )  annotation   (  Line  (   point({{164,-70},{199,-70}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  repConExtWin.u, weaBus.TDryBul )  annotation   (  Line  (   point({{222,-70},{244,-70},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  repConExtWinVWin.y,conExtWin. vWin )  annotation   (  Line  (   point({{119,-12},{50,-12},{50,-78},{22.4,-78}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  repConExtWinVWin.u, weaBus.winSpe )  annotation   (  Line  (   point({{142,-12},{192,-12},{192,-14},{244,-14},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  HTotConExtWinFra.y, solHeaGaiConWin.Q_flow )  annotation   (  Line  (   point({{19,70},{0,70}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  solHeaGaiConWin.port, fra )  annotation   (  Line  (   point({{-20,70},{-60,70},{-60,-220},{-260,-220},{-260,-260},{-300,-260}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  HDifTil.H, HDif )  annotation   (  Line  (   point({{199,90},{72,90},{72,60},{310,60}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  HDirTil.inc, inc )  annotation   (  Line  (   point({{199,126},{180,126},{180,112},{260,112},{260,180},{310,180}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  HTotConExtWinFra.u2, HDifTil.H )  annotation   (  Line  (   point({{42,64},{72,64},{72,90},{199,90}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  skyRadExcWin.TOut, weaBus.TDryBul )  annotation   (  Line  (   point({{-136,-268},{244,-268},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  skyRadExcWin.TBlaSky, weaBus.TBlaSky )  annotation   (  Line  (   point({{-136,-252},{244,-252},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + connect  (  skyRadExcWin.port, fra )  annotation   (  Line  (   point({{-180,-260},{-242,-260},{-242,-260},{-300,-260}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  repConExtWin.y, conExtWin.TOut )  annotation   (  Line  (   point({{199,-70},{180,-70},{180,-114.6},{23,-114.6}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  repConExtWinTSkyBla.y, conExtWin.TBlaSky )  annotation   (  Line  (   point({{199,-102},{23,-102}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  repConExtWinTSkyBla.u, weaBus.TBlaSky )  annotation   (  Line  (   point({{222,-102},{244,-102},{244,42}}, color={0,0,127}, smooth=Smooth.None ) , Text (  textString=)
 + (for i in 1:nCon loop connect  (  sha[i].weaBus, weaBus )  annotation   (  Line  (   points={{140,110},{244,110},{244,42}}, color={255,204,51}, thickness=0.5, smooth=Smooth.None ) , Text (  textString;end for ;;)
 + connect  (  HDirTil.inc, sha.incAng )  annotation   (  Line  (   point({{199,126},{168,126},{168,104},{142,104}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  sha.HDirTil, HDir )  annotation   (  Line  (   point({{119,116},{100,116},{100,70},{280,70},{280,120},{310,120}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + else connect  (  HDirTil.H, HTotConExtWinFra.u1 )  annotation   (  Line  (   point({{199,130},{100,130},{100,76},{42,76}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  HDirTil.H, HDir )  annotation   (  Line  (   point({{199,130},{100,130},{100,70},{280,70},{280,120},{310,120}}, color={0,0,127}, smooth=Smooth.None )  )   )
}

ExteriorBoundaryConditions <|---up ExteriorBoundaryConditionsWithWindow

ExteriorHeatTransfer -down--* "conExtWin[nCon]"ExteriorBoundaryConditionsWithWindow

RadiosityOutflow -down--* "JOutUns[nCon]"ExteriorBoundaryConditionsWithWindow

RadiosityInflow -down--* "JInUns[nCon]"ExteriorBoundaryConditionsWithWindow

RadiosityOutflow -down--* "JOutSha[nCon]"ExteriorBoundaryConditionsWithWindow

RadiosityInflow -down--* "JInSha[nCon]"ExteriorBoundaryConditionsWithWindow
@enduml