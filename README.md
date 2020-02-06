# README

Dragon Breeder Game

## Introduction
The Dragon Breeder Game is an incomplete (read "not finished" and "not really a game") Java project written by Douglas Warren with art assets by Rowena 
Robin-Williams.  It simulates the 'genome' of fantasy dragons allowing you to
generate random unique genomes or combine existing ones to create new dragons
and to visually preview them through a UI and serialise them as protobufs.

It uses Java, Maven, Google protocol buffers and JUnit as the main technologies
underpinning the project and uses Java's Swing libraries to realise the
graphical components of the project.

## Compiling and Running
This is a Maven project which used google protocol buffers.In order to compile
this project you will require:

    Java 1.8, Maven and the protoc (protobuf) compiler.

If you do not have maven or protoc installed locally then you only require Java
to run the included jar-file (more later).  Assuming that you do have all of the prerequisites to compile this project please edit the **pom.xml** file so that
the protobuf compiler plugin references the location that your copy of the
compiler is installed in.  Then run the following:

    mvn clean package 

This will produce a jar-file from which the dragon breeder game can be run.
This jarfile will be stored at:

    target/dragonBreeder-1.0-SNAPSHOT.jar

If you cannot compile this project for any reason a premade jar file is 
available at the project root at

    dragonBreeder-1.0-DEMO.jar

However you obtain a jar file you may run the 'game' by running the following
command:

    java -cp [path to jar] dougrowena.games.dragonBreeder.basicui.DragonBreederFrame

## Opening as a project.

While developed in intelliJ all hidden **.idea/** project files have been
omitted from this project in version control.  If you wish to open this project
in intelliJ it should prompt you with a warning about an unmanaged POM file.
If it does then add the pom file to the project.  This should autogenerate all
of the files needed to view and edit the project in a sensible fashion.

## Project / package overview
### src/main/proto
The source files here define the google protocol buffers used to serialise 
objects, notably the genome and other vital statistics of the titular dragons

### src/main/resources 
A set of gif images representing backgrounds, dragon images and marking
textures used to render dragons visually.  Credit to Rowena Robin-Williams

### src/main/test
Unit tests protecting the functionality of the source-code.  Structure mirrors
that in src/main/java

### src/main/java

The actual Java source code of the project.  All packages in the project are
part of the main **dougrowena.games.dragonBreeder** package Main subdivisions 
include:

* genetics - This covers the genomes of individual dragons including gene loci,
  possible genes at loci, genome recombination code and phenotypic expression.
* dragon - non-genome characteristics of a dragon (name, age, etc).
* basicui - All of the UI components used to represent the dragons in-game.
  basically it is the game,  DragonBreederFrame contains the project's main()
  method.
* basicui/utilityComponents - contains custom subclasses of important Java
  Swing JComponent classes used to render the game in a more aesthetic manner.

##  Acknowledgements

(c) Douglas Warren and Rowena Robin-Williams 2016 - 2020     