@startuml




class	 Overhang << record >>  {
 + parameter Modelica.Units.SI.Length wL  {  min=0  }   
 + parameter Modelica.Units.SI.Length wR  {  min=0  }   
 + parameter Modelica.Units.SI.Length dep  {  min=0  }   
 + parameter Modelica.Units.SI.Length gap  {  min=0  }   
 + final parameter Boolean haveOverhang= dep > Modelica.Constants.eps 
}

Record <|---up Overhang

Length -down--* "wL"Overhang

Length -down--* "wR"Overhang

Length -down--* "dep"Overhang

Length -down--* "gap"Overhang
@enduml