#!/usr/bin/env groovy
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import groovy.json.JsonSlurper

def call(buildInfoJsonFilePath="build/buildInfo.json") {
    assert GIT_BRANCH != null
    assert BUILD_NUMBER != null
 
    def gitBranch = GIT_BRANCH.toLowerCase()
    def buildInfo = readFile buildInfoJsonFilePath
    def slurper = new JsonSlurper()
    def buildInfoJson = slurper.parseText(buildInfo)
    def buildSuffix = (gitBranch=="master"||gitBranch.startsWith("release")) ? "" : "-beta"  
    def datePart = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyQ.MMdd"))
    def buildVersion = buildInfoJson.buildVersion + "." + datePart + "." + BUILD_NUMBER + buildSuffix
    echo buildVersion
    return buildVersion
    //  def jsonSlurper = new JsonSlurper()
    //  echo "${env.WORKSPACE}"
    // def buildInfo = jsonSlurper.parse(new File("${env.WORKSPACE}/build/buildInfo.json"))
    // println "buildInfo = $buildInfo"
    // echo "Hello, ${buildInfo.buildVersion}."
    // def date = new Date()
    // echo LocalDate.now().get(IsoFields.QUARTER_OF_YEAR).toString();
    // echo this.currentBuild.displayName
}