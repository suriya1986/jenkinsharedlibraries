#!/usr/bin/env groovy
import java.time.LocalDate;
import java.time.temporal.IsoFields;
// import groovy.json.JsonSlurper

def call() {
    //  def jsonSlurper = new JsonSlurper()
    // def buildInfo = jsonSlurper.parse(new File('buildInfo.json'))
    // println "buildInfo = $buildInfo"
    // echo "Hello, ${buildInfo.buildVersion}."
    def date = new Date()
    echo LocalDate.now().get(IsoFields.QUARTER_OF_YEAR).toString();
    echo "Hello, ${name}."
    echo this.currentBuild.displayName
}