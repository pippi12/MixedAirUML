@startuml




Class RadiationTemperature << model >>  {
 + parameter Boolean haveShade 
 + Modelica.Blocks.Interfaces.RealInput uSha [ NConExtWin ]   {  each min=0, each max=1  }   if haveShade 
 + Modelica.Blocks.Interfaces.RealOutput TRad  {  min=0, unit="K", displayUnit=
 # final parameter Integer NOpa = NConExt+2*NConExtWin+2*NConPar+NConBou+NSurBou 
 # final parameter Integer NWin = NConExtWin 
 # final parameter Integer NTot = NOpa + NWin 
 # final parameter Modelica.Units.SI.Area AGla [ NWin ] =datConExtWin.AGla 
 # final parameter Real epsGla [ NWin ]   {  each min=0, each max=1  }  = {datConExtWin [ i ] .glaSys.glass [ size   {   datConExtWin [ i ] .glaSys.glass, 1  }   ] .absIR_b for i in 1:NWin} 
 # final parameter Real epsSha [ NWin ]   {  each min=0, each max=1  }  = {datConExtWin [ i ] .glaSys.shade.absIR_a for i in 1:NWin} 
 # final parameter Real tauSha [ NWin ]   {  each min=0, each max=1  }  = {   {   if datConExtWin [ i ] .glaSys.haveInteriorShade then datConExtWin [ i ] .glaSys.shade.tauIR_a else 1   }    for i in 1:NWin} 
 # final parameter Modelica.Units.SI.Area epsAOpa [ NOpa ]   {  each fixed=false  }   
 # final parameter Modelica.Units.SI.Area epsAGla [ NWin ]   {  each fixed=false  }   
 # final parameter Modelica.Units.SI.Area epsASha [ NWin ]   {  each fixed=false  }   
 # final parameter Modelica.Units.SI.Area epsTauASha [ NWin ]   {  each fixed=false  }   
 # Modelica.Blocks.Interfaces.RealInput uSha_internal [ NConExtWin ]   {  each min=0, each max=1  }   
 # (for i in 1:NConExt loop epsAOpa[i] = epsConExt[i] * AConExt[i;end for ;;)
 # (for i in 1:NConPar loop epsAOpa[i+NConExt]         = epsConPar_a[i] * AConPar[i] ;;epsAOpa[i+NConExt+NConPar] = epsConPar_b[i] * AConPar[i] ;;end for ;;)
 # (for i in 1:NConBou loop epsAOpa[i+NConExt+2*NConPar] = epsConBou[i] * AConBou[i] ;;end for ;;)
 # (for i in 1:NSurBou loop epsAOpa[i+NConExt+2*NConPar+NConBou] = epsSurBou[i] * ASurBou[i] ;;end for ;;)
 # (for i in 1:NConExtWin loop epsAOpa[i+NConExt+2*NConPar+NConBou+NSurBou] = epsConExtWinOpa[i] * AConExtWinOpa[i] ;;epsAOpa[i+NConExt+2*NConPar+NConBou+NSurBou+NConExtWin] = epsConExtWinFra[i] * AConExtWinFra[i] ;;end for ;;)
 # (for i in 1:NConExtWin loop epsAGla[i] = AGla[i] * epsGla[i] ;;epsASha[i]    = AGla[i] * epsSha[i] ;;epsTauASha[i] = AGla[i] * epsGla[i] * tauSha[i] ;;end for ;;)
 + sha_internal.T( fill ( 293.15, NConExtWin )   )
 + uSha_internal( fill ( 0, NConExtWin )   )
 + (for i in 1:NConExt loop TOpa[i] = conExt[i].T ;;end for ;;)
 + (for i in 1:NConPar loop TOpa[i+NConExt]         = conPar_a[i].T ;;TOpa[i+NConExt+NConPar] = conPar_b[i].T ;;end for ;;)
 + (for i in 1:NConBou loop TOpa[i+NConExt+2*NConPar] = conBou[i].T ;;end for ;;)
 + (for i in 1:NSurBou loop TOpa[i+NConExt+2*NConPar+NConBou] = conSurBou[i].T ;;end for ;;)
 + (for i in 1:NConExtWin loop TOpa[i+NConExt+2*NConPar+NConBou+NSurBou]            = conExtWin[i].T ;;TOpa[i+NConExt+2*NConPar+NConBou+NConExtWin+NSurBou] = conExtWinFra[i].T ;;end for ;;)
 + (for i in 1:NConExtWin loop TGlaUns[i] = glaUns_internal[i].T ;;TGlaSha[i] = glaSha_internal[i].T ;;TSha[i]    = sha_internal[i].T ;;end for ;;)
 + else TRad(  ( sum ( epsAOpa[i] * TOpa[i] for i in 1:NOpa )  + sum ( epsAGla .* TGlaUns )  )  /  ( sum ( epsAOpa )  + sum ( epsAGla )  )   )
 + else conExt[1].T( 293.15  )
 + 0( conPar_b[i].Q_flow  )
 + else conPar_a[1].T( 293.15  )
 + conPar_b[1].T( 293.15  )
 + else conBou[1].T( 293.15  )
 + else conSurBou[1].T( 293.15  )
 + 0( conExtWinFra[i].Q_flow  )
 + else conExtWin[1].T   ( 293.15  )
 + conExtWinFra[1].T( 293.15  )
}

PartialSurfaceInterfaceRadiative <|---up RadiationTemperature

HeatPort_a -down--* "glaUns[NConExtWin]"RadiationTemperature

HeatPort_a -down--* "glaSha[NConExtWin]"RadiationTemperature

HeatPort_a -down--* "sha[NConExtWin]"RadiationTemperature

RealInput -down--* "uSha[NConExtWin]"RadiationTemperature

RealOutput -down--* "TRad"RadiationTemperature

Temperature -down--* "TOpa[NOpa]"RadiationTemperature

Temperature -down--* "TGlaUns[NWin]"RadiationTemperature

Temperature -down--* "TGlaSha[NWin]"RadiationTemperature

Temperature -down--* "TSha[NWin]"RadiationTemperature

HeatPort_a -down--* "glaUns_internal[NConExtWin]"RadiationTemperature

HeatPort_a -down--* "glaSha_internal[NConExtWin]"RadiationTemperature

HeatPort_a -down--* "sha_internal[NConExtWin]"RadiationTemperature

RealInput -down--* "uSha_internal[NConExtWin]"RadiationTemperature
@enduml