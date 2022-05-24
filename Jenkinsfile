pipeline {
  agent any
  parameters {
    string(name: 'TENANT_ID', description: 'Tenant ID for the test', defaultValue: '', trim: true)
  }
  stages {
    stage('Build') {
      steps {
        script{
          
          count = 0
          while(count<3){
            echo "count ${count}"
            count++
          }
          
          c = currentBuild.getPreviousBuild().getRawBuild().actions.find{ it instanceof ParametersAction }?.parameters.find{it.name == 'TENANT_ID'}?.value
          b = currentBuild.currentResult == currentBuild.getPreviousBuild().result
        if (c == params.TENANT_ID && b) {
          echo "Current build status ${currentBuild.currentResult}"
          echo "Previous build status ${currentBuild.getPreviousBuild().result}"
          echo "TENANT_ID ${currentBuild.getPreviousBuild().getRawBuild().actions.find{ it instanceof ParametersAction }?.parameters.find{it.name == 'TENANT_ID'}?.value}"
        }

        sh 'echo ${currentBuild}'
        sh 'echo ${TENANT_ID}'
      }
      }
    }
  }

}
