@startuml




class	 Generic << record >>  {
 + parameter Boolean haveExteriorShade = false 
 + parameter Boolean haveInteriorShade = false 
 + parameter Glasses.Generic glass [ : ]  
 + parameter Gases.Generic gas [ : ]  = {Buildings.HeatTransfer.Data.Gases.Air  {  x=-1  }  } 
 + parameter Shades.Generic shade 
 + parameter Modelica.Units.SI.CoefficientOfHeatTransfer UFra 
 + parameter Modelica.Units.SI.Emissivity absIRFra=0.8 
 + parameter Modelica.Units.SI.Emissivity absSolFra=0.5 
 + final parameter Boolean haveShade = haveInteriorShade or haveExteriorShade 
 + final parameter Boolean haveControllableWindow= Modelica.Math.BooleanVectors.anyTrue   {    {size   {   glass [ iGla ] .tauSol, 1  }   > 1 for iGla in 1:size   {   glass,1  }  }  }   
}

package -down--* "GlazingSystems"GlazingSystems

MaterialPropertiesPackage <|---up GlazingSystems

Record <|---up GlazingSystems

CoefficientOfHeatTransfer -down--* "UFra"GlazingSystems

Emissivity -down--* "absIRFra"GlazingSystems

Emissivity -down--* "absSolFra"GlazingSystems
@enduml