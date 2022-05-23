pipeline {
    agent any
    parameters {
        string(name: 'TENANT_ID', description: 'Tenant ID for the test', defaultValue: '', trim: true)
    }
    stages {
        stage('Build') {
            steps{
                script{
                    previousBuild = currentBuild.getPreviousBuild().getResult()
                    currentBuild = currentBuild.getCurrentResult()
                    sh 'echo ${previousBuild}'
                    sh 'echo ${currentBuild}'
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
