@startuml




Class Exterior << model >>  {
 + parameter Buildings.HeatTransfer.Types.ExteriorConvection conMod= Buildings.HeatTransfer.Types.ExteriorConvection.TemperatureWind 
 + parameter Modelica.Units.SI.CoefficientOfHeatTransfer hFixed=3 
 + parameter Buildings.HeatTransfer.Types.SurfaceRoughness roughness= Buildings.HeatTransfer.Types.SurfaceRoughness.Medium 
 + parameter Modelica.Units.SI.Angle azi 
 + parameter Modelica.Units.SI.Angle til  {  displayUnit="deg"  }   
 + Modelica.Blocks.Interfaces.RealInput v  {  unit="m/s"  }   
 + Modelica.Blocks.Interfaces.RealInput dir  {  unit="rad", displayUnit=
 # constant Modelica.Units.SI.Velocity v_small=0.5 
 # final parameter Real cosTil=Modelica.Math.cos  {  til  }   
 # final parameter Real sinTil=Modelica.Math.sin  {  til  }   
 # final parameter Boolean is_ceiling = abs  {  sinTil  }   < 10E-10 and cosTil > 0 
 # final parameter Boolean is_floor = abs  {  sinTil  }   < 10E-10 and cosTil < 0 
 # parameter Real R  {  fixed=false  }   
 # Real W  {  min=0.5, max=1  }   
 # (if  ( roughness == Buildings.HeatTransfer.Types.SurfaceRoughness.VeryRough )  then R=2.1;)
 # (elseif  ( roughness == Buildings.HeatTransfer.Types.SurfaceRoughness.Rough )  then R=1.67 ;;)
 # (elseif  ( roughness == Buildings.HeatTransfer.Types.SurfaceRoughness.Medium )  then R=1.52 ;;)
 # (elseif  ( roughness == Buildings.HeatTransfer.Types.SurfaceRoughness.MediumSmooth )  then R=1.13 ;;)
 # (elseif  ( roughness == Buildings.HeatTransfer.Types.SurfaceRoughness.Smooth )  then R=1.11 ;;)
 # (elseif  ( roughness == Buildings.HeatTransfer.Types.SurfaceRoughness.VerySmooth )  then R=1.00 ;)
 # (else R=0 ;  ;)
 # (end if ;)
 + (if  ( conMod == Buildings.HeatTransfer.Types.ExteriorConvection.Fixed )  then qN_flow = hFixed * d;W = 1 ;;hF = 0 ;;qF_flow = 0 ;;)
 + (else if is_ceiling then qN_flow = Buildings.HeatTransfer.Convection.Functions.HeatFlux.ceiling ( dT=dT )  ;;elseif is_floor then qN_flow = Buildings.HeatTransfer.Convection.Functions.HeatFlux.floor ( dT=dT )  ;;)
 + (end if ;)
 + W( Buildings.Utilities.Math.Functions.regStep (  x = v-v_small/2, y1 = Buildings.HeatTransfer.Convection.Functions.windDirectionModifier (  azi=azi, dir=dir ) , y2 = 0.75, x_small=v_small/4 )   )
 + hF( 2.537 * W * R * 2 / A^ ( 0.25 )  * Buildings.Utilities.Math.Functions.regNonZeroPower  (   x=v, n=0.5, delta=v_small )   )
 + qF_flow( hF*dT  )
 + q_flow( qN_flow + qF_flow  )
}

PartialConvection <|---up Exterior

ExteriorConvection -down--* "conMod"Exterior

CoefficientOfHeatTransfer -down--* "hFixed"Exterior

SurfaceRoughness -down--* "roughness"Exterior

Angle -down--* "azi"Exterior

Angle -down--* "til"Exterior
@enduml