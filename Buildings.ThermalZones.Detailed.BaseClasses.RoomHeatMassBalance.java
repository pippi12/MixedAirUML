@startuml




 Class RoomHeatMassBalance << partial >>  {
 + replaceable package Medium = Modelica.Media.Interfaces.PartialMedium 
 + constant Boolean homotopyInitialization = true 
 + parameter Integer nPorts=0 
 + Modelica.Fluid.Vessels.BaseClasses.VesselFluidPorts_b ports [ nPorts ]    {    redeclare each package Medium = Medium  }   
 + final parameter Modelica.Units.SI.Volume V=AFlo*hRoo 
 + parameter Modelica.Units.SI.Area AFlo 
 + parameter Modelica.Units.SI.Length hRoo 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a heaPorAir 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a heaPorRad 
 + parameter Boolean linearizeRadiation=true 
 + parameter Boolean steadyStateWindow = false 
 + parameter Buildings.HeatTransfer.Types.InteriorConvection intConMod=Buildings.HeatTransfer.Types.InteriorConvection.Temperature 
 + parameter Modelica.Units.SI.CoefficientOfHeatTransfer hIntFixed=3.0 
 + parameter Buildings.HeatTransfer.Types.ExteriorConvection extConMod=Buildings.HeatTransfer.Types.ExteriorConvection.TemperatureWind 
 + parameter Modelica.Units.SI.CoefficientOfHeatTransfer hExtFixed=10.0 
 + parameter Modelica.Units.SI.MassFlowRate m_flow_nominal  {  min=0  }   = V*1.2/3600 
 + parameter Boolean sampleModel = false 
 + Modelica.Blocks.Interfaces.RealInput uWin [ nConExtWin ]    {    each min=0, each max=1, each unit="1"  }   if haveControllableWindow 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a surf_conBou [ nConBou ]  if haveConBou 
 + Modelica.Thermal.HeatTransfer.Interfaces.HeatPort_a surf_surBou [ nSurBou ]  if haveSurBou 
 + Modelica.Blocks.Interfaces.RealInput qGai_flow [ 3 ]   {  each unit="W/m2"  }   
 + replaceable BaseClasses.PartialAirHeatMassBalance air constrainedby BaseClasses.PartialAirHeatMassBalance   {    redeclare final package Medium = Medium, nPorts=nPorts, final nConExt=nConExt, final nConExtWin=nConExtWin, final nConPar=nConPar, final nConBou=nConBou, final nSurBou=nSurBou, final datConExt=datConExt, final datConExtWin=datConExtWin, final datConPar=datConPar, final datConBou=datConBou, final surBou=surBou, final haveShade=haveShade, final V=V  }   
 # final parameter Modelica.Units.SI.TransmissionCoefficient tauIRSha_air [  NConExtWin ] =datConExtWin.glaSys.shade.tauIR_a 
 # final parameter Modelica.Units.SI.TransmissionCoefficient tauIRSha_glass [  NConExtWin ] =datConExtWin.glaSys.shade.tauIR_b 
 # final parameter Boolean haveControllableWindow= Modelica.Math.BooleanVectors.anyTrue   {    {datConExtWin [ i ] .glaSys.haveControllableWindow for i in 1:NConExtWin}   }    
 # final parameter Boolean haveExteriorShade [ NConExtWin ] = {datConExtWin [ i ] .glaSys.haveExteriorShade for i in 1:NConExtWin} 
 # final parameter Boolean haveInteriorShade [ NConExtWin ] = {datConExtWin [ i ] .glaSys.haveInteriorShade for i in 1:NConExtWin} 
 # final parameter Boolean haveShade= Modelica.Math.BooleanVectors.anyTrue   {   haveExteriorShade [ : ]   }   or Modelica.Math.BooleanVectors.anyTrue   {   haveInteriorShade [ : ]   }   
 # final parameter Boolean is_floorConExt [ NConExt ] = datConExt.is_floor 
 # final parameter Boolean is_floorConExtWin [ NConExtWin ] = datConExtWin.is_floor 
 # final parameter Boolean is_floorConPar_a [ NConPar ] = datConPar.is_floor 
 # final parameter Boolean is_floorConPar_b [ NConPar ] = datConPar.is_ceiling 
 # final parameter Boolean is_floorConBou [ NConBou ] = datConBou.is_floor 
 # parameter Boolean is_floorSurBou [ NSurBou ] = surBou.is_floor 
 # Modelica.Blocks.Math.Add add annotation   {  Placement  {  transformation  {  extent={{-140,110},{-120,130}}  }    }    }  
 # Modelica.Blocks.Math.Add sumJToWin [ NConExtWin ]    {    each final k1=1, each final k2=1  }   if haveConExtWin 
 # Modelica.Blocks.Math.Sum sumJFroWin [ NConExtWin ]   {  each nin=if haveShade then 2 else 1   }    if haveConExtWin 
 # (assert  (  homotopyInitialization, "In " + getInstanceName  (   )  + ": The constant homotopyInitialization has been modified from its default value. This constant will be removed in future releases.", level = AssertionLevel.warning )  )
 + connect  (  conBou.opa_a, surf_conBou )  annotation   (  Line  (   point({{282,-122.667},{282,-122},{288,-122},{288,-216},{-240,-216},{-240, -180},{-260,-180}}, color={191,0,0}, smooth=Smooth.None )  ) )
 + connect  (  bouConExtWin.opa_a, conExtWin.opa_a )  annotation   (  Line  (   point({{352,69},{280,69}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.JInUns_a, bouConExtWin.JOutUns )  annotation   (  Line  (   point({{280.5,60},{304,60},{304,58},{351.5,58}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  bouConExtWin.JInUns, conExtWin.JOutUns_a )  annotation   (  Line  (   point({{351.5,60},{316,60},{316,58},{280.5,58}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.glaUns_a, bouConExtWin.glaUns )  annotation   (  Line  (   point({{280,55},{352,55}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  bouConExtWin.glaSha, conExtWin.glaSha_a )  annotation   (  Line  (   point({{352,53},{280,53}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.JInSha_a, bouConExtWin.JOutSha )  annotation   (  Line  (   point({{280.5,51},{286,51},{286,52},{292,52},{292,49},{351.5,49}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  bouConExtWin.JInSha, conExtWin.JOutSha_a )  annotation   (  Line  (   point({{351.5,51},{290,51},{290,49},{280.5,49}}, color={0,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.fra_a, bouConExtWin.fra )  annotation   (  Line  (   point({{280,46},{352,46}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExt.opa_a, bouConExt.opa_a )  annotation   (  Line  (   point({{288,138.333},{334,138.333},{334,139},{352,139}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  weaBus, bouConExtWin.weaBus )  annotation   (  Line  (   point({{180,160},{400,160},{400,60.05},{378.15,60.05}}, color={255,204,51}, thickness=0.5, smooth=Smooth.None )  )   )
 + connect  (  weaBus, bouConExt.weaBus )  annotation   (  Line  (   point({{180,160},{400,160},{400,130},{378.15,130},{378.15,130.05}}, color={255,204,51}, thickness=0.5, smooth=Smooth.None )  )   )
 + connect  (  bouConExtWin.QAbsSolSha_flow, conExtWinRad.QAbsExtSha_flow )  annotation   (  Line  (   point({{351,62},{312,62},{312,46},{290,46},{290,-5},{299,-5}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  bouConExtWin.inc, conExtWinRad.incAng )  annotation   (  Line  (   point({{382.5,68},{390,68},{390,-15},{321.5,-15}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  bouConExtWin.HDir, conExtWinRad.HDir )  annotation   (  Line  (   point({{382.5,65},{388,65},{388,-10},{321.5,-10}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  bouConExtWin.HDif, conExtWinRad.HDif )  annotation   (  Line  (   point({{382.5,62},{392,62},{392,-6},{321.5,-6}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.QAbsSha_flow, conExtWinRad.QAbsGlaSha_flow )  annotation   (   Line  (   point({{261,43},{261,38},{260,38},{260,-12},{280,-12},{280,-13},{299,-13}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  conExtWinRad.QAbsGlaUns_flow, conExtWin.QAbsUns_flow )  annotation   (   Line  (   point({{299,-9},{284,-9},{284,-10},{268,-10},{268,36},{269,36},{269,43}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  conExt.opa_b, irRadExc.conExt )  annotation   (  Line  (   point({{241.847,138.333},{160,138.333},{160,60},{-60,60},{-60,20},{-80, 20},{-80,19.1667}}, color={190,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.fra_b, irRadExc.conExtWinFra )  annotation   (  Line  (   point({{249.9,46},{160,46},{160,60},{-60,60},{-60,10},{-79.9167,10}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conPar.opa_a, irRadExc.conPar_a )  annotation   (  Line  (   point({{282,-90.3333},{288,-90.3333},{288,-106},{160,-106},{160,60},{-60, 60},{-60,8},{-80,8},{-80,7.5},{-79.9167,7.5}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conPar.opa_b, irRadExc.conPar_b )  annotation   (  Line  (   point({{243.873,-90.3333},{160,-90.3333},{160,60},{-60,60},{-60,5.83333}, {-79.9167,5.83333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conBou.opa_b, irRadExc.conBou )  annotation   (  Line  (   point({{241.867,-122.667},{160,-122.667},{160,60},{-60,60},{-60,3.33333}, {-79.9167,3.33333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  surf_surBou, irRadExc.conSurBou )  annotation   (  Line  (   point({{-260,-140},{-232,-140},{-232,-210},{160,-210},{160,60},{-60,60}, {-60,0.833333},{-79.9583,0.833333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadGai.conExt, conExt.opa_b )  annotation   (  Line  (   point({{-80,-20.8333},{-80,-20},{-60,-20},{-60,60},{160,60},{160,138.333}, {241.847,138.333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadGai.conExtWinFra, conExtWin.fra_b )  annotation   (  Line  (   point({{-79.9167,-30},{-60,-30},{-60,60},{160,60},{160,46},{249.9,46}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadGai.conPar_a, conPar.opa_a )  annotation   (  Line  (   point({{-79.9167,-32.5},{-60,-32.5},{-60,60},{160,60},{160,-106},{288, -106},{288,-90.3333},{282,-90.3333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadGai.conPar_b, conPar.opa_b )  annotation   (  Line  (   point({{-79.9167,-34.1667},{-60,-34.1667},{-60,60},{160,60},{160, -90.3333},{243.873,-90.3333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadGai.conBou, conBou.opa_b )  annotation   (  Line  (   point({{-79.9167,-36.6667},{-60,-36.6667},{-60,60},{160,60},{160, -122.667},{241.867,-122.667}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadGai.conSurBou, surf_surBou )  annotation   (  Line  (   point({{-79.9583,-39.1667},{-60,-39.1667},{-60,60},{160,60},{160,-210},{ -232,-210},{-232,-140},{-260,-140}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.opa_b, irRadExc.conExtWin )  annotation   (  Line  (   point({{249.9,69},{160,69},{160,60},{-60,60},{-60,16},{-80,16},{-80,17.5}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.opa_b, irRadGai.conExtWin )  annotation   (  Line  (   point({{249.9,69},{160,69},{160,60},{-60,60},{-60,-22},{-70,-22},{-70,-22.5}, {-80,-22.5}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExt.opa_b, solRadExc.conExt )  annotation   (  Line  (   point({{241.847,138.333},{160,138.333},{160,60},{-80,60},{-80,59.1667}}, color={190,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.fra_b, solRadExc.conExtWinFra )  annotation   (  Line  (   point({{249.9,46},{160,46},{160,60},{-60,60},{-60,50},{-79.9167,50}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conPar.opa_a, solRadExc.conPar_a )  annotation   (  Line  (   point({{282,-90.3333},{288,-90.3333},{288,-106},{160,-106},{160,60},{-60, 60},{-60,48},{-79.9167,48},{-79.9167,47.5}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conPar.opa_b, solRadExc.conPar_b )  annotation   (  Line  (   point({{243.873,-90.3333},{160,-90.3333},{160,60},{-60,60},{-60,46},{-70, 46},{-70,45.8333},{-79.9167,45.8333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conBou.opa_b, solRadExc.conBou )  annotation   (  Line  (   point({{241.867,-122.667},{160,-122.667},{160,60},{-60,60},{-60,43.3333}, {-79.9167,43.3333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  surf_surBou, solRadExc.conSurBou )  annotation   (  Line  (   point({{-260,-140},{-232,-140},{-232,-210},{160,-210},{160,60},{-60,60}, {-60,40},{-70,40},{-70,40.8333},{-79.9583,40.8333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.opa_b, solRadExc.conExtWin )  annotation   (  Line  (   point({{249.9,69},{160,69},{160,60},{-60,60},{-60,57.5},{-80,57.5}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  solRadExc.JInDifConExtWin, conExtWinRad.QTraDif_flow )  annotation   (   Line  (   point({{-79.5833,53.3333},{20,53.3333},{20,-20},{299,-20}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  solRadExc.HOutConExtWin,conExtWinRad.HRoo )   annotation   (  Line  (   point({{-79.5833,55},{10,55},{10,-34},{328,-34},{328,-21.6},{321.5,-21.6}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  conExt.opa_b, radTem.conExt )  annotation   (  Line  (   point({{241.847,138.333},{160,138.333},{160,60},{-60,60},{-60,-60.8333}, {-80,-60.8333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.opa_b, radTem.conExtWin )  annotation   (  Line  (   point({{249.9,69},{160,69},{160,60},{-60,60},{-60,-62.5},{-80,-62.5}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.fra_b, radTem.conExtWinFra )  annotation   (  Line  (   point({{249.9,46},{160,46},{160,60},{-60,60},{-60,-70},{-79.9167,-70}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conPar.opa_a, radTem.conPar_a )  annotation   (  Line  (   point({{282,-90.3333},{288,-90.3333},{288,-106},{160,-106},{160,60},{-60, 60},{-60,-72.5},{-79.9167,-72.5}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conPar.opa_b, radTem.conPar_b )  annotation   (  Line  (   point({{243.873,-90.3333},{160,-90.3333},{160,60},{-60,60},{-60,-74.1667}, {-79.9167,-74.1667}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  conBou.opa_b, radTem.conBou )  annotation   (  Line  (   point({{241.867,-122.667},{160,-122.667},{160,60},{-60,60},{-60,-76.6667}, {-79.9167,-76.6667}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  surf_surBou, radTem.conSurBou )  annotation   (  Line  (   point({{-260,-140},{-232,-140},{-232,-210},{160,-210},{160,60},{-60,60}, {-60,-79.1667},{-79.9583,-79.1667}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  radTem.glaUns, conExtWin.glaUns_b )  annotation   (  Line  (   point({{-80,-65},{-60,-65},{-60,60},{160,60},{160,55},{250,55}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  radTem.glaSha, conExtWin.glaSha_b )  annotation   (  Line  (   point({{-80,-66.6667},{-60,-66.6667},{-60,60},{160,60},{160,53},{250,53}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  radTem.TRad, radiationAdapter.TRad )  annotation   (  Line  (   point({{-100.417,-77.6667},{-144,-77.6667},{-144,-78},{-186,-78},{-186, 130},{-182,130}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  radiationAdapter.rad, heaPorRad )  annotation   (  Line  (   point({{-170.2,120},{-170,120},{-170,114},{-226,114},{-226,4.44089e-16}, {-260,4.44089e-16}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  radiationAdapter.QRad_flow, add.u1 )  annotation   (  Line  (   point({{-159,130},{-150,130},{-150,126},{-142,126}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  add.y, irRadGai.Q_flow )  annotation   (  Line  (   point({{-119,120},{-116,120},{-116,-30},{-100.833,-30}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  irRadExc.JOutConExtWin, sumJToWin.u1 )  annotation   (  Line  (   point({{-79.5833,15},{-50,15},{-50,-14},{-42,-14}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadGai.JOutConExtWin, sumJToWin.u2 )  annotation   (  Line  (   point({{-79.5833,-25},{-46,-25},{-46,-26},{-42,-26}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  shaSig.y, radShaOut.u )  annotation   (  Line  (   point({{-199,160},{-110,160},{-110,124},{-102,124}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  shaSig.y, shaRad.u )  annotation   (  Line  (   point({{-199,160},{-64,160},{-64,108},{-61,108}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  sumJToWin.y, radShaOut.JIn )  annotation   (  Line  (   point({{-19,-20},{0,-20},{0,148},{-106,148},{-106,136},{-101,136}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  radShaOut.JOut_1, shaRad.JIn_air )  annotation   (  Line  (   point({{-79,136},{-70,136},{-70,96},{-61,96}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  radShaOut.JOut_2, conExtWin.JInUns_b )  annotation   (  Line  (   point({{-79,124},{-20,124},{-20,58},{249.5,58}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  shaRad.JOut_glass, conExtWin.JInSha_b )  annotation   (  Line  (   point({{-39,96},{20,96},{20,72},{220,72},{220,49},{249.5,49}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  conExtWin.JOutSha_b, shaRad.JIn_glass )  annotation   (  Line  (   point({{249.5,51},{222,51},{222,70},{16,70},{16,92},{-39,92}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  irRadExc.JInConExtWin, sumJFroWin.y )  annotation   (  Line  (   point({{-79.5833,13.3333},{-46,13.3333},{-46,14},{-41,14}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  shaRad.QSolAbs_flow, conExtWinRad.QAbsIntSha_flow )  annotation   (  Line  (   point({{-50,89},{-50,86},{148,86},{148,-17},{299,-17}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  sumJFroWin.u[1], conExtWin.JOutUns_b )  annotation   (  Line  (   point({{-18,14},{164,14},{164,60},{249.5,60}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  sumJFroWin.u[2], shaRad.JOut_air )  annotation   (  Line  (   point({{-18,14},{-10,14},{-10,40},{-40,40},{-40,64},{-66,64},{-66,92},{ -61,92}}, color={0,127,0}, smooth=Smooth.None )  )   )
 + connect  (  radTem.sha, TSha.port )  annotation   (  Line  (   point({{-80,-68.4167},{-64,-68.4167},{-64,-68},{-40,-68}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + (for i in 1:nPorts loop connect  (  ports[i],air. ports[i] )  annotation   (  Line  (   points={{-260,-60},{-218,-60},{-218,-206},{52,-206},{52,-141.9}}, color={0,127,255}, smooth=Smooth.None )  )  ;;end for ;;)
 + connect  (  air.conExt, conExt.opa_b )  annotation   (  Line  (   point({{64,-119},{160,-119},{160,138.333},{241.847,138.333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.conExtWin, conExtWin.opa_b )  annotation   (  Line  (   point({{64,-121},{160,-121},{160,69},{249.9,69}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.glaUns, conExtWin.glaUns_b )  annotation   (  Line  (   point({{64,-124},{160,-124},{160,55},{250,55}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.glaSha, conExtWin.glaSha_b )  annotation   (  Line  (   point({{64,-126},{160,-126},{160,53},{250,53}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.conExtWinFra, conExtWin.fra_b )  annotation   (  Line  (   point({{64.1,-130},{160,-130},{160,46},{249.9,46}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.conPar_a, conPar.opa_a )  annotation   (  Line  (   point({{64.1,-133},{160,-133},{160,-106},{288,-106},{288,-90.3333},{282, -90.3333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.conPar_b, conPar.opa_b )  annotation   (  Line  (   point({{64.1,-135},{160,-135},{160,-90},{243.873,-90},{243.873,-90.3333}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.conBou, conBou.opa_b )  annotation   (  Line  (   point({{64.1,-138},{160,-138},{160,-122.667},{241.867,-122.667}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.conSurBou, surf_surBou )  annotation   (  Line  (   point({{64.05,-141},{160,-141},{160,-210},{-232,-210},{-232,-140},{-260,-140}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  shaRad.QRadAbs_flow,air. QRadAbs_flow )  annotation   (  Line  (   point({{-55,89},{-55,72},{4,72},{4,-125},{39.5,-125}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  air.TSha, shaRad.TSha )  annotation   (  Line  (   point({{39.5,-127},{2,-127},{2,70},{-45,70},{-45,89}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  air.heaPorAir, heaPorAir )  annotation   (  Line  (   point({{40,-130},{-10,-130},{-10,-88},{-200,-88},{-200,40},{-260,40}}, color={191,0,0}, smooth=Smooth.None )  )   )
 + connect  (  air.TSha, TSha.T )  annotation   (  Line  (   point({{39.5,-127},{2,-127},{2,-68},{-18,-68}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect ( uWin, conExtWinRad.uSta )  annotation  ( Line ( point({{-280,140},{-240, 140},{-240,180},{420,180},{420,-40},{305.2,-40},{305.2,-25.6}}, color= {0,0,127}  )    )    )
 + connect  (  qGai_flow,heaGai. qGai_flow )  annotation   (  Line  (   point({{-280,80},{-222,80}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  air.QCon_flow,heaGai. QCon_flow )  annotation   (  Line  (   point({{39,-135},{-14,-135},{-14,-92},{-190,-92},{-190,80},{-198,80}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  air.QLat_flow,heaGai. QLat_flow )  annotation   (  Line  (   point({{39,-138},{-18,-138},{-18,-96},{-194,-96},{-194,74},{-198,74}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  heaGai.QRad_flow, add.u2 )  annotation   (  Line  (   point({{-198,86},{-152,86},{-152,114},{-142,114}}, color={0,0,127}, smooth=Smooth.None )  )   )
 + connect  (  conExtWinRad.QTraDir_flow, solRadExc.JInDirConExtWin )  annotation   (   Line ( point({{299,-23},{18,-23},{18,51.6667},{-79.5833,51.6667}}, color={ 0,0,127}  )    )    )
}

ConstructionRecords <|---up RoomHeatMassBalance

Modelica.Media.Interfaces.PartialMedium <|..-up "Medium"RoomHeatMassBalance

VesselFluidPorts_b -down--* "ports[nPorts]"RoomHeatMassBalance

Area -down--* "AFlo"RoomHeatMassBalance

Length -down--* "hRoo"RoomHeatMassBalance

HeatPort_a -down--* "heaPorAir"RoomHeatMassBalance

HeatPort_a -down--* "heaPorRad"RoomHeatMassBalance

Construction -down--* "conExt[NConExt]"RoomHeatMassBalance

ConstructionWithWindow -down--* "conExtWin[NConExtWin]"RoomHeatMassBalance

Construction -down--* "conPar[NConPar]"RoomHeatMassBalance

Construction -down--* "conBou[NConBou]"RoomHeatMassBalance

InteriorConvection -down--* "intConMod"RoomHeatMassBalance

CoefficientOfHeatTransfer -down--* "hIntFixed"RoomHeatMassBalance

ExteriorConvection -down--* "extConMod"RoomHeatMassBalance

CoefficientOfHeatTransfer -down--* "hExtFixed"RoomHeatMassBalance

MassFlowRate -down--* "m_flow_nominal"RoomHeatMassBalance

RealInput -down--* "uWin[nConExtWin]"RoomHeatMassBalance

HeatPort_a -down--* "surf_conBou[nConBou]"RoomHeatMassBalance

HeatPort_a -down--* "surf_surBou[nSurBou]"RoomHeatMassBalance

RealInput -down--* "qGai_flow[3]"RoomHeatMassBalance

ExteriorBoundaryConditions -down--* "bouConExt"RoomHeatMassBalance

ExteriorBoundaryConditionsWithWindow -down--* "bouConExtWin"RoomHeatMassBalance

PartialAirHeatMassBalance <|..-up "air"RoomHeatMassBalance

SolarRadiationExchange -down--* "solRadExc"RoomHeatMassBalance

SolarRadiationExchange -down--* "solRadExc"RoomHeatMassBalance

InfraredRadiationGainDistribution -down--* "irRadGai"RoomHeatMassBalance

InfraredRadiationGainDistribution -down--* "irRadGai"RoomHeatMassBalance

InfraredRadiationExchange -down--* "irRadExc"RoomHeatMassBalance

InfraredRadiationExchange -down--* "irRadExc"RoomHeatMassBalance

RadiationTemperature -down--* "radTem"RoomHeatMassBalance

RadiationTemperature -down--* "radTem"RoomHeatMassBalance

HeatGain -down--* "heaGai"RoomHeatMassBalance

HeatGain -down--* "heaGai"RoomHeatMassBalance

RadiationAdapter -down--* "radiationAdapter"RoomHeatMassBalance

RadiationAdapter -down--* "radiationAdapter"RoomHeatMassBalance

Add -down--* "add"RoomHeatMassBalance

Add -down--* "sumJToWin[NConExtWin]"RoomHeatMassBalance

Sum -down--* "sumJFroWin[NConExtWin]"RoomHeatMassBalance

PrescribedTemperature -down--* "TSha[NConExtWin]"RoomHeatMassBalance
@enduml