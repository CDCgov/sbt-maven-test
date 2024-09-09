#!/bin/bash

set -eu

# Make sure Sonatype credentials are in $HOME/.sbt/sonatype_credentials

# Clean everything up before starting
sbt clean

# Build the project locally
# This requires your PGP password
sbt publishSigned

# Deploy to Sonatype Maven Central
sbt sonatypeBundleRelease

