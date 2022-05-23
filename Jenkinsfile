pipeline {
    agent any
    parameters {
        string(name: 'TENANT_ID', description: 'Tenant ID for the test', defaultValue: '', trim: true)
    }
    stages {
        stage('Build') {
            steps{
                script{
                    previousBuild = currentBuild.getPreviousBuild()
                    sh 'echo ${previousBuild.currentResult}'
                    sh 'echo ${previousBuild.getCurrentResult()}'
                    sh 'echo ${previousBuild.getResult()}'
                }
                sh 'echo ${TENANT_ID}'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
            }
        }
    }
