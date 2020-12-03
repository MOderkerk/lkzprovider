# LKZProvider
![CodeQL](https://github.com/MOderkerk/lkzprovider/workflows/CodeQL/badge.svg)
![Maven Package](https://github.com/MOderkerk/lkzprovider/workflows/Maven%20Package/badge.svg?branch=1.1.0)

Applikation zum Lesen und Konvertierung von Ländernamen und Länderkennzeichen. 
Folgende Eingaben werden in der aktuellen Version untertsützt:
* Ländername (Case-Sensitiv)
* iso31661-2
* iso31661-3
* Kfz Länderkennzeichen
* Autocomplete funktion für Ländernamen (case insensitive)

# API Dokumentation

Die Anwendung bietet einen swagger-ui Endpunkt unter der folgenden URL an: <adresse/ip>:<port>/swagger-ui.html

(Beispiel: http://localhost:8080/swagger-ui.html) 

Die Open-Api Version 3 Dokumentation kann unter dem Endpunkt <adresse/ip>:port/v3/api-docs

(Beispiel: http://localhost:8080/v3/api-docs) abgerufen werden.

# DATENQUELLEN: 
Die enthaltenen Daten stammen von verschiedenen öffentlichen Datenquellen :
https://www.destatis.de/DE/Methoden/Klassifikationen/Staat-Gebietsystematik/Staatsangehoerigkeitsgebietsschluessel_pdf.pdf?__blob=publicationFile Stand 05.11.2020

Wikipedia.org

# Konfiguration 
In der Anwendung ist die folgende Standard Konfiguration hinterlegt, sofern Du nicht deine eigene application.properties / yml anlegst:
 
```
################################################################################################
## A U S W A H L   D A T E N Q U E L L E 
## Dateibasiert
#spring.datasource.url=jdbc:hsqldb:file:/lkzdb/lkzdb
#
## Arbeitsspeicherbasiert
spring.datasource.url=jdbc:hsqldb:mem:lkzdb

################################################################################################
##                  L O G G I N G 
################################################################################################
## Loglevel Config
logging.level.root=error
logging.level.de.oderkerk.tools.lkz=error
logging.level.de.oderkerk.tools.lkz.LkzProviderApplication=info

## Log pattern configuration
# Slf4jMDCFilter.UUID ist eine Log-Variable die eine eindeutige Request ID ausgibt. Diese ID wird in Fehlermeldungen und
# als Response Header zurückgegeben um ein Tracing , sofern ein entsprechendes Loglevel 
# (error nur fehlerlogs , debug mehr infos)
# eingestellt ist 
logging.pattern.console=[%-5p]|%d{ISO8601}[%X{Slf4jMDCFilter.UUID}]%logger{26}|%m%ex%n
logging.pattern.file=[%-5p]|%d{ISO8601}[%X{Slf4jMDCFilter.UUID}]%logger{26}|%m%ex%n
logging.file.name=./lkzprovider.log
logging.file.max-size=15MB
logging.file.max-history=3
logging.file.total-size-cap=100MB
logging.register-shutdown-hook=true
logging.exception-conversion-word=%ex

################################################################################################
## Falls Ihr eine Spring Boot atmin nutzt könnt ihr hier die Enstellungen configurieren
################################################################################################
spring.boot.admin.client.url=http://localhost:8081
## Client ein und aussschalten
spring.boot.admin.client.enabled=false
## Anzeige im Dashboard
spring.boot.admin.client.instance.name="Odins LKZ Provider"
## Tag zum Darstellen der Umgebung (Beispiel Test/SYSTEST/PROD oder Server 1, Server 2 ). Die Werte liegen bei dir ;)
spring.boot.admin.client.instance.metadata.tags.environment=PROD
management.endpoint.shutdown.enabled=false
management.endpoint.health.enabled=true
management.endpoint.health.show-details=always
management.endpoint.info.enabled=true
management.endpoint.metrics.enabled=true
management.endpoints.web.exposure.include=* 

################################################################################################
## A B    H I E R     N I C H T     Ä N D E R N  
############################################################################################### 
odin.slf4jfilter.request_header=X-Header-Token
spring.application.name=Odins LKZ Provider
spring.datasource.initialization-mode=always
spring.datasource.username=sa 
spring.datasource.password= 
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.HSQLDialect
spring.jpa.show-sql=false
spring.datasource.sql-script-encoding=UTF-8
spring.data.rest.detection-strategy=visibility

```

