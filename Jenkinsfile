pipeline {
  agent any
  parameters {
    string(name: 'CLUSTER', description: 'Cluster for the test', defaultValue: '', trim: true)
  }
  stages {
    stage('Build') {
      steps {
        script{
         
          acall()
          previousBuild=currentBuild.getPreviousBuild()
          while(previousBuild.getRawBuild().actions.find{ it instanceof ParametersAction }?.parameters.find{it.name == 'CLUSTER'}?.value != params.CLUSTER){
            previousBuild=previousBuild.getPreviousBuild()
            echo "ururururb"
          }
          
          b = currentBuild.currentResult != previousBuild.result
        if (b) {
          echo "notify!"
        }
          else{
            echo "not notify!"
          }
      }
      }
    }
  }

}

def acall() {
    echo "Hello,"
}
