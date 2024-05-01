@startuml




Class SolarRadiationExchange << model >>  {
 + parameter Boolean is_floorConExt [ NConExt ]  
 + parameter Boolean is_floorConExtWin [ NConExtWin ]  
 + parameter Boolean is_floorConPar_a [ NConPar ]  
 + parameter Boolean is_floorConPar_b [ NConPar ]  
 + parameter Boolean is_floorConBou [ NConBou ]  
 + parameter Boolean is_floorSurBou [ NSurBou ]  
 + parameter Modelica.Units.SI.Emissivity tauGla [ NConExtWin ]  
 + Modelica.Blocks.Interfaces.RealInput JInDifConExtWin [ NConExtWin ]   {  each unit="W"  }   
 + Modelica.Blocks.Interfaces.RealInput JInDirConExtWin [ NConExtWin ]   {  each unit="W"  }   
 + Modelica.Blocks.Interfaces.RealOutput HOutConExtWin [ NConExtWin ]   {  each unit="W/m2"  }   
 # final parameter Real kDir1  {  unit="1", fixed=false  }   
 # final parameter Real kDir2  {  fixed=false  }   
 # final parameter Integer NOpa = NConExt+2*NConExtWin+2*NConPar+NConBou+NSurBou 
 # final parameter Integer NWin = NConExtWin 
 # final parameter Integer NTot = NOpa + NWin 
 # final parameter Boolean is_flo [ NTot ]   {  each fixed=false  }   
 # final parameter Real eps [ NTot ]   {  each min=0, each max=1, each fixed=false  }   
 # final parameter Real tau [ NTot ]   {  each min=0, each max=1, each fixed=false  }   
 # final parameter Modelica.Units.SI.Area AFlo  {  fixed=false  }   
 # final parameter Modelica.Units.SI.Area A [ NTot ]   {  each fixed=false  }   
 # final parameter Real kDif [ NTot ]    {    each unit="1", each fixed=false  }   
 # final parameter Real kDir [ NTot ]    {    each unit="1", each fixed=false  }   
 # final parameter Real epsTauA [ NTot ]    {    each unit="m2", each fixed=false  }   
 # final parameter Real sumEpsTauA  {  unit="m2", fixed=false  }   
 # (for i in 1:NConExt loop eps[i] = epsConExt[i;A[i]      = AConExt[i] ;;is_flo[i]  = is_floorConExt[i] ;;end for ;;)
 # (for i in 1:NConPar loop eps[i+NConExt]           = epsConPar_a[i] ;;A[i+NConExt]             = AConPar[i] ;;is_flo[i+NConExt]         = is_floorConPar_a[i] ;;eps[i+NConExt+NConPar]   = epsConPar_b[i] ;;A[i+NConExt+NConPar]     = AConPar[i] ;;is_flo[i+NConExt+NConPar] = is_floorConPar_b[i] ;;end for ;;)
 # (for i in 1:NConBou loop eps[i+NConExt+2*NConPar]   = epsConBou[i] ;;A[i+NConExt+2*NConPar]     = AConBou[i] ;;is_flo[i+NConExt+2*NConPar] = is_floorConBou[i] ;;end for ;;)
 # (for i in 1:NSurBou loop eps[i+NConExt+2*NConPar+NConBou]   = epsSurBou[i] ;;A[i+NConExt+2*NConPar+NConBou]     = ASurBou[i] ;;is_flo[i+NConExt+2*NConPar+NConBou] = is_floorSurBou[i] ;;end for ;;)
 # (for i in 1:NConExtWin loop eps[i+NConExt+2*NConPar+NConBou+NSurBou]   = epsConExtWinOpa[i] ;;A[i+NConExt+2*NConPar+NConBou+NSurBou]     = AConExtWinOpa[i] ;;is_flo[i+NConExt+2*NConPar+NConBou+NSurBou] = is_floorConExtWin[i] ;;eps[i+NConExt+2*NConPar+NConBou+NSurBou+NConExtWin]   = epsConExtWinFra[i] ;;A[i+NConExt+2*NConPar+NConBou+NSurBou+NConExtWin]     = AConExtWinFra[i] ;;is_flo[i+NConExt+2*NConPar+NConBou+NSurBou+NConExtWin] = is_floorConExtWin[i] ;;end for ;;)
 # (for i in 1:NConExtWin loop eps[i+NConExt+2*NConPar+NConBou+NSurBou+2*NConExtWin] = epsConExtWinUns[i] ;;is_flo[i+NConExt+2*NConPar+NConBou+NSurBou+2*NConExtWin] = is_floorConExtWin[i] ;;A[i+NConExt+2*NConPar+NConBou+NSurBou+2*NConExtWin] = AConExtWinGla[i] ;;end for ;;)
 # (for i in 1:NOpa loop tau[i] = 0 ;;end for ;;)
 # (for i in 1:NWin loop tau[NOpa+i] = tauGla[i] ;;end for ;;)
 # AFlo( sum (   ( if is_flo[i] then A[i] else 0 )  for i in 1:NTot )   )
 # epsTauA(  ( eps .+ tau ) .*A  )
 # sumEpsTauA( sum ( epsTauA[i] for i in 1:NTot )   )
 # (for i in 1:NTot loop kDif[i] =  ( eps[i] + tau[i] ) *A[i]/sumEpsTauA ;;end for ;;)
 # kDir1( sum (  ( if is_flo[i] then  ( A[i]* ( 1 - eps[i] - tau[i] )  )  else 0 )  for i in 1: NTot ) /max  (  1E-20, AFlo )   )
 # kDir2( sum (  ( if is_flo[i] then 0 else epsTauA[i] )  for i in 1:NTot )   )
 # (if   (  kDir2 > 1E-10 )  then for i in 1:NTot loop if is_flo[i] then kDir[i] = epsTauA[i]/AFlo ;;)
 # (else kDir[i] =kDir1/kDir2*epsTauA[i] ;;)
 # (end if ;)
 # else for i in 1:NTot loop if is_flo[i] then kDir[i]( A[i]/AFlo  )
 # else kDir[i]( 0  )
 # (assert  (   AFlo > 1E-10, "Error in parameters of the room model: The geometry is incorrect:\n" + "    The room model must have a construction that is a floor,\n" + "    and this construction must not have a window.\n" + "    The parameters for the room model are such that there is no such construction.\n" + "    Revise the model parameters."  )   ;  )
 # (assert ( abs ( 1 - sum ( kDif )  )  < 1E-5, "Program error: Sum of diffuse solar distribution factors in room is not equal to one. kDif=" + String  (  sum  (  kDif )  )  )  ;  )
 # (assert ( abs ( 1 - sum ( kDir )  )  < 1E-5, "Program error: Sum of direct solar distribution factors in room is not equal to one. kDir=" + String  (  sum  (  kDir )  )  )  ;  )
 + Q_flow(-kDif .* sum ( JInDifConExtWin )  - kDir .* sum ( JInDirConExtWin ) )
 + (if haveConExt then for i in 1:NConExt loop Q_flow[i] = conExt[i].Q_flow ;;end for ;;)
 + (else conExt[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveConPar then for i in 1:NConPar loop Q_flow[i+NConExt]         = conPar_a[i].Q_flow ;;Q_flow[i+NConExt+NConPar] = conPar_b[i].Q_flow ;;end for ;;)
 + (else conPar_a[1].T = 293.15 ;;conPar_b[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveConBou then for i in 1:NConBou loop Q_flow[i+NConExt+2*NConPar] = conBou[i].Q_flow ;;end for ;;)
 + (else conBou[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveSurBou then for i in 1:NSurBou loop Q_flow[i+NConExt+2*NConPar+NConBou] = conSurBou[i].Q_flow ;;end for ;;)
 + (else conSurBou[1].T = 293.15 ;;)
 + (end if ;)
 + (if haveConExtWin then for i in 1:NConExtWin loop Q_flow[i+NConExt+2*NConPar+NConBou+NSurBou]            = conExtWin[i].Q_flow ;;Q_flow[i+NConExt+2*NConPar+NConBou+NSurBou+NConExtWin] = conExtWinFra[i].Q_flow ;;end for ;;)
 + (else conExtWin[1].T    = 293.15 ;;conExtWinFra[1].T = 293.15 ;;)
 + (end if ;)
 + (for j in 1:NWin loop Q_flow[j+NOpa] = JOutConExtWin[j] ;;HOutConExtWin[j] = if  ( AConExtWinGla[j] > 1E-10 )  then JOutConExtWin[j] / AConExtWinGla[j] else 0 ;;end for ;;)
}

PartialSurfaceInterfaceRadiative <|---up SolarRadiationExchange

Emissivity -down--* "tauGla[NConExtWin]"SolarRadiationExchange

RealInput -down--* "JInDifConExtWin[NConExtWin]"SolarRadiationExchange

RealInput -down--* "JInDirConExtWin[NConExtWin]"SolarRadiationExchange

RealOutput -down--* "HOutConExtWin[NConExtWin]"SolarRadiationExchange

HeatFlowRate -down--* "JOutConExtWin[NConExtWin]"SolarRadiationExchange

HeatFlowRate -down--* "Q_flow[NTot]"SolarRadiationExchange
@enduml