FROM ubuntu

#Installation des outils necessaire
RUN apt-get update

RUN apt-get install -y git

RUN apt-get install -y maven

#Recuperation des sources
RUN git clone "https://github.com/Morgane-hen/devopsProjet"

RUN cd devopsProjet

#Compile et run
RUN mvn install

RUN java -jar devopsProjet*.jar
