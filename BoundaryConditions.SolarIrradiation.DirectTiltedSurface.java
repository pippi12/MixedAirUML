@startuml




Class DirectTiltedSurface << block >>  {
 + parameter Modelica.Units.SI.Angle azi 
 + Modelica.Blocks.Interfaces.RealOutput inc   {    final quantity="Angle", final unit=
 + connect  (  incAng.y, HDirTil.incAng )  annotation   (  Line  (   point({{-29,-20},{-12,-20},{-12,-12},{-4,-12}}, color={0,0,127} )  ) )
 + connect  (  weaBus.HDirNor, HDirTil.HDirNor )  annotation   (  Line  (   point({{-100,5.55112e-16},{-80,5.55112e-16},{-80,12},{-4,12}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
 + connect  (  incAng.y, inc )  annotation   (  Line  (   point({{-29,-20},{-20,-20},{-20,-40},{110,-40}}, color={0,0,127} )  )   )
 + connect  (  HDirTil.HDirTil, H )  annotation   (  Line  (   point({{42,1.22125e-15},{72,1.22125e-15},{72,5.55112e-16},{110, 5.55112e-16}}, color={0,0,127} )  )   )
 + connect  (  weaBus, incAng.weaBus )  annotation   (  Line  (   point({{-100,5.55112e-16},{-80,5.55112e-16},{-80,-20},{-50,-20}}, color={255,204,51}, thickness=0.5 ) , Text (  textString=)
}

PartialSolarIrradiation <|---up DirectTiltedSurface

Angle -down--* "azi"DirectTiltedSurface

DirectTiltedSurface -down--* "HDirTil"DirectTiltedSurface
@enduml