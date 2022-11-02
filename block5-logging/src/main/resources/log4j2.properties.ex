
# lOS ARCHIVOS TIPO ERROR SE SACAN POR ARCHIVO
log4j.rootCategory=info, console, file


# lOS ARCHIVOS TIPO WARNING SE SACAN POR CONSOLA

log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Target=System.out
log4j.appender.console.filter.a=org.apache.log4j.varia.LevelRangeFilter
log4j.appender.console.filter.a.LevelMin=TRACE
log4j.appender.console.filter.a.LevelMax=WARN
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=%d %d{Z} [%t] %-5p (%F:%L) - %m%n



# DEFINIMOS EL METODO PARA SACAR POR ARCHICO ROLLINGFILEAPPENDER
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.filter.B=org.apache.log4j.varia.LevelRangeFilter
log4j.appender.file.filter.B.LevelMin=ERROR
log4j.appender.file.filter.B.LevelMax=ERROR
log4j.appender.file.File= spring-logging-{$1}.log
log4j.appender.file.MaxFileSize=10MB
log4j.appender.file.MaxBackupIndex=5
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d %d{Z} [%t] %-5p (%F:%L) - %m%n


