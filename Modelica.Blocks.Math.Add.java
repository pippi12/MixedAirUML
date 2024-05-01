@startuml




Class Add << block >>  {
 + parameter Real k1=+1 
 + parameter Real k2=+1 
 + y( k1*u1 + k2*u2)
}

SI2SO <|---up Add
@enduml