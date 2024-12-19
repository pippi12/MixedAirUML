@startuml




Class DiffusePerez << block >>  {
 + parameter Real rho  {  min=0, max=1, final unit="1"  }  =0.2 
 + parameter Modelica.Units.SI.Angle azi 
 + parameter Boolean outSkyCon=false 
 + parameter Boolean outGroCon=false 
 + Modelica.Blocks.Interfaces.RealOutput HSkyDifTil if outSkyCon 
 + Modelica.Blocks.Interfaces.RealOutput HGroDifTil if outGroCon 
 # Modelica.Blocks.Math.Add add 
 + connect  (  relAirMas.relAirMas, skyBri.relAirMas )  annotation   (  Line  (   point({{-71.6,-40},{-66,-40},{-66,-47.6},{-60.8,-47.6}}, color={0,0,127} )  ) )
 + connect  (  skyBri.skyBri, briCoe.skyBri )  annotation   (  Line  (   point({{-51.6,-50},{-46,-50},{-46,-30},{-40.8,-30}}, color={0,0,127} )  )   )
 + connect  (  skyCle.skyCle, briCoe.skyCle )  annotation   (  Line  (   point({{-53.6,20},{-46,20},{-46,-27.6},{-40.8,-27.6}}, color={0,0,127} )  )   )
 + connect  (  incAng.y, HDifTil.incAng )  annotation   (  Line  (   point({{-75.5,-91},{-16,-91},{-16,-16},{-4.2,-16},{-4.2,-14.7}}, color={0,0,127} )  )   )
 + connect  (  weaBus.solZen, skyCle.zen )  annotation   (  Line  (   point({{-100,5.55112e-16},{-86,5.55112e-16},{-86,17.6},{-62.8,17.6}}, color={0,0,127} )  )   )
 + connect  (  weaBus.solZen, relAirMas.zen )  annotation   (  Line  (   point({{-100,5.55112e-16},{-86,5.55112e-16},{-86,-42.4},{-80.8,-42.4}}, color={0,0,127} )  )   )
 + connect  (  weaBus.solZen, briCoe.zen )  annotation   (  Line  (   point({{-100,5.55112e-16},{-86,5.55112e-16},{-86,-20},{-66,-20},{-66,-32}, {-40.8,-32},{-40.8,-32.4}}, color={0,0,127} )  )   )
 + connect  (  weaBus.HDirNor, skyCle.HDirNor )  annotation   (  Line  (   point({{-100,5.55112e-16},{-92,5.55112e-16},{-92,22.4},{-62.8,22.4}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  weaBus.HDifHor, skyCle.HDifHor )  annotation   (  Line  (   point({{-100,5.55112e-16},{-92,5.55112e-16},{-92,20},{-62.8,20}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  weaBus.HDifHor, skyBri.HDifHor )  annotation   (  Line  (   point({{-100,5.55112e-16},{-92,5.55112e-16},{-92,-50},{-60.8,-50}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  weaBus.HGloHor, HDifTil.HGloHor )  annotation   (  Line  (   point({{-100,5.55112e-16},{-70,0},{-38,0},{-38,16.8},{-4.2,16.8}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  weaBus.HDifHor, HDifTil.HDifHor )  annotation   (  Line  (   point({{-100,5.55112e-16},{-38,5.55112e-16},{-38,10},{-4.2,10},{-4.2, 10.5}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  briCoe.F2, HDifTil.briCof2 )  annotation   (  Line  (   point({{-31.6,-31.6},{-24,-31.6},{-24,-2.1},{-4.2,-2.1}}, color={0,0,127} )  )   )
 + connect  (  briCoe.F1, HDifTil.briCof1 )  annotation   (  Line  (   point({{-31.6,-28.4},{-28,-28.4},{-28,4.2},{-4.2,4.2}}, color={0,0,127} )  )   )
 + connect  (  weaBus, incAng.weaBus )  annotation   (  Line  (   point({{-100,5.55112e-16},{-92,5.55112e-16},{-92,-91},{-86,-91}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  weaBus.solZen, HDifTil.zen )  annotation   (  Line  (   point({{-100,5.55112e-16},{-86,5.55112e-16},{-86,-58},{-20,-58},{-20, -8.4},{-4.2,-8.4}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  HDifTil.HSkyDifTil, add.u1 )  annotation   (  Line  (   point({{44.1,8.4},{52,8.4},{52,6},{58,6}}, color={0,0,127} )  )   )
 + connect  (  HDifTil.HGroDifTil, add.u2 )  annotation   (  Line  (   point({{44.1,-8.4},{52,-8.4},{52,-6},{58,-6}}, color={0,0,127} )  )   )
 + connect  (  add.y, H )  annotation   (  Line  (   point({{81,6.10623e-16},{90.5,6.10623e-16},{90.5,5.55112e-16},{110, 5.55112e-16}}, color={0,0,127} )  )   )
 + connect  (  HDifTil.HSkyDifTil, HSkyDifTil )  annotation   (  Line  (   point({{44.1,8.4},{52,8.4},{52,60},{110,60}}, color={0,0,127} )  )   )
 + connect  (  HDifTil.HGroDifTil, HGroDifTil )  annotation   (  Line  (   point({{44.1,-8.4},{52,-8.4},{52,-60},{110,-60}}, color={0,0,127} )  )   )
 + connect  (  weaBus.solTim, skyBri.solTim )  annotation   (  Line  (   point({{-100,0},{-96,0},{-96,-52.4},{-60.8,-52.4}}, color={255,204,51}, thickness=0.5 ) , Text (  string=)
 + connect  (  weaBus.alt, relAirMas.alt )  annotation   (  Line  (   point({{-100,0},{-84,0},{-84,-37.6},{-80.8,-37.6}}, color={255,204,51}, thickness=0.5 ) , Text (  string=)
}

PartialSolarIrradiation <|---up DiffusePerez

Angle -down--* "azi"DiffusePerez

DiffusePerez -down--* "HDifTil"DiffusePerez

DiffusePerez -down--* "HDifTil"DiffusePerez

SkyClearness -down--* "skyCle"DiffusePerez

SkyClearness -down--* "skyCle"DiffusePerez

BrighteningCoefficient -down--* "briCoe"DiffusePerez

BrighteningCoefficient -down--* "briCoe"DiffusePerez

RelativeAirMass -down--* "relAirMas"DiffusePerez

RelativeAirMass -down--* "relAirMas"DiffusePerez

SkyBrightness -down--* "skyBri"DiffusePerez

SkyBrightness -down--* "skyBri"DiffusePerez
@enduml