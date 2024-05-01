@startuml




class	 SideFins << record >>  {
 + parameter Modelica.Units.SI.Length h  {  min=0  }   
 + parameter Modelica.Units.SI.Length dep  {  min=0  }   
 + parameter Modelica.Units.SI.Length gap  {  min=0  }   
 + final parameter Boolean haveSideFins= dep > Modelica.Constants.eps 
}

Record <|---up SideFins

Length -down--* "h"SideFins

Length -down--* "dep"SideFins

Length -down--* "gap"SideFins
@enduml