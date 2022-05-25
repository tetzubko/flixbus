pipeline {
  agent any
  parameters {
    string(name: 'CLUSTER', description: 'Cluster for the test', defaultValue: '', trim: true)
  }
  stages {
    stage('Build') {
      steps {
        script{
         
          if (acall()){
            echo "yes print"
          }else{
            echo "no print"
          }
          
          previousBuild=currentBuild.getPreviousBuild()
          while(previousBuild && previousBuild.getRawBuild().actions.find{ it instanceof ParametersAction }?.parameters.find{it.name == 'CLUSTER'}?.value != params.CLUSTER){
            if(!previousBuild.getPreviousBuild()){
              break
            }
            previousBuild = previousBuild.getPreviousBuild()
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
  return false
}
