@echo off
echo ========================================
echo  From Local to Vultr DCs Ping Test v1.1
echo ========================================
pause
echo=
echo 01 Tokyo
ping hnd-jp-ping.vultr.com -n 10
echo=
echo =============================
echo 02 Singapore
ping sgp-ping.vultr.com -n 10
echo=
echo =============================
echo 03 Amsterdam
ping ams-nl-ping.vultr.com -n 10
echo=
echo =============================
echo 06 London
ping lon-gb-ping.vultr.com -n 10
echo=
echo =============================
echo 14 Silicon Valley
ping sjo-ca-us-ping.vultr.com -n 10
echo=
pause