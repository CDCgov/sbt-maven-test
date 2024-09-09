inThisBuild(
  List(
    organization := "gov.cdc",
    organizationName:= "CDC",
  )
)

// Repository for releases on Maven Central using Sonatype
publishTo := sonatypePublishToBundle.value
publishMavenStyle := true

sonatypeProfileName := "gov.cdc" // Your sonatype groupID
// Reference the project OSS repository

import xerial.sbt.Sonatype.GitHubHosting
sonatypeProjectHosting := Some(
  GitHubHosting(user = "boris-ning-usds", repository = "sbt-maven-test", email = "tpz7@cdc.gov")
)

licenses:= Seq(
  "APL2" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://cdc.gov"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/cdcgov/sbt-maven-test"),
    "scm:git@github.com:cdcgov/sbt-maven-test.git"
  )
)

sonatypeRepository := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) nexus + "content/repositories/snapshots"
  else nexus + "service/local"
}

import xerial.sbt.Sonatype.sonatypeCentralHost
ThisBuild / sonatypeCredentialHost := sonatypeCentralHost
ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")
