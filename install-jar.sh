#!/bin/sh

if [ "$MAVEN_HOME" = "" ]
then
  echo "set MAVEN_HOME for your Maven"
  exit 1
fi

if [ ! -f "$MAVEN_HOME/bin/mvn" ]
then
  echo "couldn't find $MAVEN_HOME/bin/mvn."
  echo "MAVEN_HOME seems invalid."
  exit 1
fi

$MAVEN_HOME/bin/mvn install:install-file -Dfile=contrib/lib/jdnc-0_7-all.jar -DgroupId=jdnc -DartifactId=jdnc -Dversion=0.7  -Dpackaging=jar
$MAVEN_HOME/bin/mvn install:install-file -Dfile=contrib/lib/exchange/mpxj.jar -DgroupId=net.sf.mpxj -DartifactId=mpxj -Dversion=custom  -Dpackaging=jar 
$MAVEN_HOME/bin/mvn install:install-file -Dfile=contrib/lib/nachocalendar-0_23.jar -DgroupId=net.sf.nachocalendar -DartifactId=nachocalendar -Dversion=0.23  -Dpackaging=jar 
$MAVEN_HOME/bin/mvn install:install-file -Dfile=contrib/lib/l2fprod-common-totd-7_3.jar  -DgroupId=com.l2fprod.common -DartifactId=l2fprod-common -Dversion=7.3 -Dpackaging=jar

 


