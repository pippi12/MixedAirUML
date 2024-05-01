@startuml




Class Sum << block >>  {
 + parameter Real k [ nin ] =ones  {  nin  }   
 + y( k*u)
}

MISO <|---up Sum
@enduml