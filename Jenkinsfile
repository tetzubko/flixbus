pipeline {
    agent any
    parameters {
        string(name: 'TENANT_ID', description: 'Tenant ID for the test', defaultValue: '', trim: true)
    }
    stages {
        stage('Build') {
            steps {
                script{
                    def previousBuild = currentBuild.getPreviousBuild()
                }
            
                sh 'echo ${TENANT_ID}'
                sh 'echo ${previousBuild.result}'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
    }
}
