@startuml




Class InfraredRadiationGainDistribution << model >>  {
 + parameter Boolean haveShade 
 + Modelica.Blocks.Interfaces.RealInput uSha [ NConExtWin ]   {  each min=0, each max=1  }   if haveShade 
 + Modelica.Blocks.Interfaces.RealInput Q_flow 
 # Real fraConExt [ NConExt ]  = AEpsConExt*sumAEpsInv 
 # Real fraConExtWinOpa [ NConExtWin ]  = AEpsConExtWinOpa*sumAEpsInv 
 # Real fraConExtWinGla [ NConExtWin ]  =   {  AEpsConExtWinSha + AEpsConExtWinUns  }  *sumAEpsInv 
 # Real fraConExtWinFra [ NConExtWin ]  = AEpsConExtWinFra*sumAEpsInv 
 # Real fraConPar_a [ NConPar ]  = AEpsConPar_a*sumAEpsInv 
 # Real fraConPar_b [ NConPar ]  = AEpsConPar_b*sumAEpsInv 
 # Real fraConBou [ NConBou ]  = AEpsConBou*sumAEpsInv 
 # Real fraSurBou [ NSurBou ]  = AEpsSurBou*sumAEpsInv 
 # parameter Real AEpsConExt [ NConExt ]  = {AConExt [ i ] *epsConExt [ i ]  for i in 1:NConExt} 
 # parameter Real AEpsConExtWinOpa [ NConExtWin ]  = {AConExtWinOpa [ i ] *epsConExtWinOpa [ i ]  for i in 1:NConExtWin} 
 # Real AEpsConExtWinUns [ NConExtWin ]  = {shaSig [ i ] .yCom * AConExtWinGla [ i ] *epsConExtWinUns [ i ]  for i in 1:NConExtWin} 
 # Real AEpsConExtWinSha [ NConExtWin ]  = {shaSig [ i ] .y    * AConExtWinGla [ i ] *epsConExtWinSha [ i ]  for i in 1:NConExtWin} 
 # parameter Real AEpsConExtWinFra [ NConExtWin ]  = {AConExtWinFra [ i ] *epsConExtWinFra [ i ]  for i in 1:NConExtWin} 
 # parameter Real AEpsConPar_a [ NConPar ]  = {AConPar [ i ] *epsConPar_a [ i ]  for i in 1:NConPar} 
 # parameter Real AEpsConPar_b [ NConPar ]  = {AConPar [ i ] *epsConPar_b [ i ]  for i in 1:NConPar} 
 # parameter Real AEpsConBou [ NConBou ]  = {AConBou [ i ] *epsConBou [ i ]  for i in 1:NConBou} 
 # parameter Real AEpsSurBou [ NSurBou ]  = {ASurBou [ i ] *epsSurBou [ i ]  for i in 1:NSurBou} 
 # parameter Real sumAEpsNoWin  {  fixed=false  }   
 # Real sumAEpsInv 
 # sumAEpsNoWin( sum ( AEpsConExt ) +sum ( AEpsConExtWinOpa ) +sum ( AEpsConExtWinFra )  +sum  (  AEpsConPar_a ) +sum  (  AEpsConPar_b ) +sum  (  AEpsConBou ) +sum  (  AEpsSurBou ) )
 + sumAEpsInv  ( 1.0/ ( sumAEpsNoWin + sum ( AEpsConExtWinUns )  + sum ( AEpsConExtWinSha )  )   )
 + (if haveConExt then conExt.Q_flow    = -fraConExt*Q_flow ;;)
 + (else conExt[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveConExtWin then conExtWin.Q_flow = -fraConExtWinOpa*Q_flow ;;)
 + (else conExtWin[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveConPar then conPar_a.Q_flow  = -fraConPar_a*Q_flow ;;conPar_b.Q_flow  = -fraConPar_b*Q_flow ;;)
 + (else conPar_a[1].T = 293.15 ;;conPar_b[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveConBou then conBou.Q_flow    = -fraConBou*Q_flow ;;)
 + (else conBou[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveSurBou then conSurBou.Q_flow    = -fraSurBou*Q_flow ;;)
 + (else conSurBou[1].T = 293.15 ;;)
 + (end if ;)
 + JOutConExtWin       ( +fraConExtWinGla*Q_flow  )
 + (if haveConExtWin then conExtWinFra.Q_flow  = -fraConExtWinFra*Q_flow ;;)
 + (else conExtWinFra[1].T = 293.15 ;;)
 + (end if ;)
 + (assert  (  abs  (  1 - sum  (  fraConExt )  - sum  (  fraConExtWinOpa ) - sum  (  fraConExtWinGla )  - sum  (  fraConExtWinFra )  - sum  (  fraConPar_a )  - sum  (  fraConPar_b )  - sum  (  fraConBou )  - sum  (  fraSurBou )  )   < 1E-5, "Programming error: Radiation balance is wrong. Check equations."  )   ;  )
}

PartialSurfaceInterfaceRadiative <|---up InfraredRadiationGainDistribution

RealInput -down--* "uSha[NConExtWin]"InfraredRadiationGainDistribution

RealInput -down--* "Q_flow"InfraredRadiationGainDistribution

RadiosityOutflow[NConExtWin -down--* "JOutConExtWin"InfraredRadiationGainDistribution

ShadingSignal -down--* "shaSig[NConExtWin]"InfraredRadiationGainDistribution
@enduml