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
          while(previousBuild && previousBuild.getRawBuild().actions.find{ it instanceof ParametersAction }?.parameters.find{it.name == 'CLUSTER'}?.value != params.CLUSTER){
            previousBuild = previousBuild.getPreviousBuild() ?: previousBuild.getPreviousBuild()
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
  if (1==2){
    echo "Hello,"
  }else{
    return
  }
  echo "yiiyiyiii"
    
}
