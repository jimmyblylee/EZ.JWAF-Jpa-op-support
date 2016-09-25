@echo off
title Deploying EZ.JWAF JPA Operation Support
call msg info "[INFO] Deploying EZ.JWAF JPA Operation Support" & echo.

set BASEDIR=%~sdp0

pushd %BASEDIR%\..\src\jpa-op-sp
  call mvn clean deploy -DperformTest=true -DperformSource=true -DperformDeploy=true
popd

call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 

pause