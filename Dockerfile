FROM ubuntu

#Installation des outils necessaire
RUN apt-get update

RUN apt-get install -y git

RUN echo "8" | apt-get install -y maven

#Recuperation des sources
RUN git clone "https://github.com/Morgane-hen/devopsProjet"

WORKDIR "/devopsProjet"

#Compile et run
RUN mvn install

CMD java -jar devopsProjet.jar
