name := "hangman"
 
version := "1.0"
 
scalaVersion := "2.12.11"
 
fork := true


// https://mvnrepository.com/artifact/org.scalafx/scalafx
libraryDependencies += "org.scalafx" %% "scalafx" % "18.0.1-R27"

// https://mvnrepository.com/artifact/org.scalafx/scalafxml-core-sfx8
libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.5"


addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full) 


