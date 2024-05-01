@startuml




Class InfraredRadiationExchange << model >>  {
 + constant Boolean homotopyInitialization = true 
 + parameter Boolean linearizeRadiation 
 + parameter Boolean sampleModel=false 
 # constant Real T30  {  unit="K3"  }   = 293.15^3 
 # constant Real T40  {  unit="K4"  }   = 293.15^4 
 # final parameter Integer NOpa=NConExt + 2*NConExtWin + 2*NConPar + NConBou + NSurBou 
 # final parameter Integer nOpa=nConExt + 2*nConExtWin + 2*nConPar + nConBou + nSurBou 
 # final parameter Integer NWin=NConExtWin 
 # final parameter Integer nWin=nConExtWin 
 # final parameter Integer NTot=NOpa + NWin 
 # final parameter Integer nTot=nOpa + nWin 
 # final parameter Real epsOpa [ nOpa ]    {    each min=0, each max=1, each fixed=false  }   
 # final parameter Real rhoOpa [ nOpa ]    {    each min=0, each max=1, each fixed=false  }   
 # final parameter Modelica.Units.SI.Area AOpa [ nOpa ]   {  each fixed=false  }   
 # final parameter Modelica.Units.SI.Area A [ nTot ]   {  each fixed=false  }   
 # final parameter Real kOpa [ nOpa ]   {  each unit="W/K4", each fixed=false  }   
 # final parameter Real kOpaInv [ nOpa ]   {  each unit="K4/W", each fixed=false  }   
 # final parameter Real F [ nTot, nTot ]    {    each min=0, each max=1, each fixed=false  }   
 # parameter Modelica.Units.SI.Time t0  {  fixed=false  }   
 # Real T4Opa [ nOpa ]    {    each unit="K4", each start=T40, each nominal=293.15^4  }   
 # parameter Modelica.Units.SI.Temperature T0=293.15 
 # final parameter Real T03   {    min=0, unit="K3"  }   = T0^3 
 # (assert  (  homotopyInitialization, "In " + getInstanceName  (   )  + ": The constant homotopyInitialization has been modified from its default value. This constant will be removed in future releases.", level = AssertionLevel.warning )  )
 # (for i in 1:nConExt loop epsOpa[i] = epsConExt[i] ;;AOpa[i] = AConExt[i] ;;kOpa[i] = Modelica.Constants.sigma*epsConExt[i]*AOpa[i] ;;end for ;;)
 # (for i in 1:nConPar loop epsOpa[i + nConExt] = epsConPar_a[i] ;;AOpa[i + nConExt] = AConPar[i] ;;kOpa[i + nConExt] = Modelica.Constants.sigma*epsConPar_a[i]*AOpa[i + nConExt] ;;epsOpa[i + nConExt + nConPar] = epsConPar_b[i] ;;AOpa[i + nConExt + nConPar] = AConPar[i] ;;kOpa[i + nConExt + nConPar] = Modelica.Constants.sigma*epsConPar_b[i]*AOpa[ i + nConExt + nConPar] ;;end for ;;)
 # (for i in 1:nConBou loop epsOpa[i + nConExt + 2*nConPar] = epsConBou[i] ;;AOpa[i + nConExt + 2*nConPar] = AConBou[i] ;;kOpa[i + nConExt + 2*nConPar] = Modelica.Constants.sigma*epsConBou[i]*AOpa[ i + nConExt + 2*nConPar] ;;end for ;;)
 # (for i in 1:nSurBou loop epsOpa[i + nConExt + 2*nConPar + nConBou] = epsSurBou[i] ;;AOpa[i + nConExt + 2*nConPar + nConBou] = ASurBou[i] ;;kOpa[i + nConExt + 2*nConPar + nConBou] = Modelica.Constants.sigma* epsSurBou[i]*AOpa[i + nConExt + 2*nConPar + nConBou] ;;end for ;;)
 # (for i in 1:nConExtWin loop epsOpa[i + nConExt + 2*nConPar + nConBou + nSurBou] = epsConExtWinOpa[i] ;;AOpa[i + nConExt + 2*nConPar + nConBou + nSurBou] = AConExtWinOpa[i] ;;kOpa[i + nConExt + 2*nConPar + nConBou + nSurBou] = Modelica.Constants.sigma *epsConExtWinOpa[i]*AOpa[i + nConExt + 2*nConPar + nConBou + nSurBou] ;;epsOpa[i + nConExt + 2*nConPar + nConBou + nSurBou + nConExtWin] = epsConExtWinFra[i] ;;AOpa[i + nConExt + 2*nConPar + nConBou + nSurBou + nConExtWin] = AConExtWinFra[i] ;;kOpa[i + nConExt + 2*nConPar + nConBou + nSurBou + nConExtWin] = Modelica.Constants.sigma *epsConExtWinFra[i]*AOpa[i + nConExt + 2*nConPar + nConBou + nSurBou + nConExtWin] ;;end for ;;)
 # (for i in 1:nOpa loop A[i] = AOpa[i] ;;end for ;;)
 # (for i in 1:nWin loop A[i + nOpa] = AConExtWinGla[i] ;;end for ;;)
 # rhoOpa( 1 .- epsOpa  )
 # (for i in 1:nTot loop for j in 1:nTot loop F[i, j] = A[j]/sum (  ( A[k] )  for k in 1:nTot )  ;;end for ;;)
 # (for i in 1:nOpa loop kOpaInv[i] = 1/kOpa[i] ;;end for ;;)
 # (for i in 1:nTot loop assert  (    (  abs  (  1 - sum  (  F[i, j] for j in 1:nTot )  )  )  < 1E-10,;end for ;;)
 # t0( time  )
 + Q_flow( -pre ( J )  - G  )
 + else G( -transpose ( F ) *J  )
 + Q_flow( -J - G  )
 + (for j in 1:nOpa loop T4Opa[j] =  ( -J[j] - rhoOpa[j]*G[j] ) *kOpaInv[j] ;;end for ;;)
 + else if homotopyInitialization then TOpa( homotopy ( actual=Buildings.Utilities.Math.Functions.powerLinearized (  x=T4Opa, x0=243.15^4, n=0.25 ) , simplified= ( T4Opa .+ 3*T40 ) / ( 4*T30 )  )   )
 + else TOpa( Buildings.Utilities.Math.Functions.powerLinearized (  x=T4Opa, x0=243.15^4, n=0.25 )   )
 + (for j in 1:nWin loop J[j + nOpa] = -JInConExtWin_internal[j] ;;G[j + nOpa] = +JOutConExtWin[j] ;;end for ;;)
 + (for i in 1:nConExt loop Q_flow[i] = conExt[i].Q_flow ;;end for ;;)
 + (for i in 1:nConPar loop Q_flow[i + nConExt] = conPar_a[i].Q_flow ;;Q_flow[i + nConExt + nConPar] = conPar_b[i].Q_flow ;;end for ;;)
 + conPar_b[1].T( T0  )
 + (for i in 1:nConBou loop Q_flow[i + nConExt + 2*nConPar] = conBou[i].Q_flow ;;end for ;;)
 + (for i in 1:nSurBou loop Q_flow[i + nConExt + 2*nConPar + nConBou] = conSurBou[i].Q_flow ;;end for ;;)
 + (for i in 1:nConExtWin loop Q_flow[i + nConExt + 2*nConPar + nConBou + nSurBou] = conExtWin[i].Q_flow ;;Q_flow[i + nConExt + 2*nConPar + nConBou + nSurBou + nConExtWin] = conExtWinFra[i].Q_flow ;;end for ;;)
 + conExtWinFra[1].T( T0  )
 + JOutConExtWin[1]( 0  )
}

PartialSurfaceInterfaceRadiative <|---up InfraredRadiationExchange

Time -down--* "t0"InfraredRadiationExchange

RadiosityInflow -down--* "JInConExtWin_internal["InfraredRadiationExchange

HeatFlowRate -down--* "J[nTot]"InfraredRadiationExchange

HeatFlowRate -down--* "G[nTot]"InfraredRadiationExchange

Temperature -down--* "TOpa[nOpa]"InfraredRadiationExchange

HeatFlowRate -down--* "Q_flow[nTot]"InfraredRadiationExchange

Temperature -down--* "T0"InfraredRadiationExchange
@enduml