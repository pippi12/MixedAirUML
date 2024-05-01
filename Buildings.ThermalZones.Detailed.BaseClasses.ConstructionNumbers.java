@startuml




class	 ConstructionNumbers << record >>  {
 + parameter Integer nConExt  {  min=0  }   
 + parameter Integer nConExtWin  {  min=0  }   
 + parameter Integer nConPar  {  min=0  }   
 + parameter Integer nConBou  {  min=0  }   
 + parameter Integer nSurBou  {  min=0  }   
 + final parameter Integer NConExt  {  min=1  }   = max  {  1, nConExt  }   
 + final parameter Integer NConExtWin  {  min=1  }  =max  {  1, nConExtWin  }   
 + final parameter Integer NConPar  {  min=1  }  =max  {  1, nConPar  }   
 + final parameter Integer NConBou  {  min=1  }  =max  {  1, nConBou  }   
 + final parameter Integer NSurBou  {  min=1  }  =max  {  1, nSurBou  }   
 + final parameter Boolean haveConExt = nConExt > 0 
 + final parameter Boolean haveConExtWin = nConExtWin > 0 
 + final parameter Boolean haveConPar = nConPar > 0 
 + final parameter Boolean haveConBou = nConBou > 0 
 + final parameter Boolean haveSurBou = nSurBou > 0 
}

Record <|---up ConstructionNumbers
@enduml