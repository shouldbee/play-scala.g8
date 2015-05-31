resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "$play_version$")

// Web plugins
//addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.6")

//addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")

//addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")

//addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.0")

//addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")

addSbtPlugin("com.slidingautonomy.sbt" % "sbt-filter" % "1.0.1")

// Code beauty plugins
resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")

addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.0.0")

// Packing plugins
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.13.0")
