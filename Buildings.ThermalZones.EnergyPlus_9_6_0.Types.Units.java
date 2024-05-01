@startuml




enum	 Units << type >>  {
(  Normalized "Normalized
, such as a control signal between 0 and 1 or status 0
, 1, 2, ...   (  1 ) ", AngleRad "Angle   (  rad ) ", AngleDeg "Angle   (  deg ) ", Energy "Energy   (  J ) ", Illuminance "Illuminance", HumidityAbsolute "Absolute humidity   (  mass fraction per total mass of moist air ) ", HumidityRelative "Relative humidity   (  1 ) ", LuminousFlux "Luminous flux   (  cd.sr ) ", MassFlowRate "Mass flow rate   (  kg/s ) ", Power "Power   (  W ) ", Pressure "Pressure   (  Pa ) ", Status "Status   (  e.g., rain )    (  1 ) ", Temperature "Temperature   (  K ) ", Time "Time   (  s ) ", VolumeFlowRate "VolumeFlowRate   (  m3/s ) " )  "Enumeration for units used for schedules and EMS actuators" 
}
@enduml