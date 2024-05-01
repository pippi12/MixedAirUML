@startuml




Class RadiationAdapter << model >>  {
 + Modelica.Blocks.Interfaces.RealOutput QRad_flow 
 + QRad_flow( rad.Q_flow)
 + rad.T( TRad  )
}

BaseIcon <|---up RadiationAdapter

HeatPort_a -down--* "rad"RadiationAdapter

RealOutput -down--* "QRad_flow"RadiationAdapter
@enduml