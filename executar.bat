@echo off
setlocal

REM altera o diretorio antes de exexutar seu macaco
set "DIRETORIO_PROJETO=%~dp0"
cd /d "%DIRETORIO_PROJETO%"


mvn clean install

IF %ERRORLEVEL% NEQ 0 (
    echo Erro durante a compilação Maven. Abortando.
    exit /b %ERRORLEVEL%
)

cd target

REM Executa o primeiro arquivo .jar que acha na pasta
for %%f in (*.jar) do (
    echo Iniciando o JAR: %%f
    java -jar "%%f"
    goto end
)

:end
endlocal
pause