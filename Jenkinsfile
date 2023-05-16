pipeline {
    agent {
        node {
            label 'java17'
        }
    
    }

    options {
                timestamps()
                buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '2'))
                timeout(time: 240, unit: 'MINUTES')
                disableConcurrentBuilds()
                }

        stages {

            stage ('AppCodeCheckout') {
                steps {

                    git 'https://github.com/Anushalokiny/anusha-devops-maven1.git'

                }
            }
            stage ('CI Build') {

                steps {
                    
                        sh 'ls -l'
                        
                        sh 'pwd'
                        sh 'mvn clean package'

                    

                     }
    
            }

             stage ('Docker Build && Push && DEPLOY ') {
               

                steps {
                    
                    withCredentials([string(credentialsId: 'DOCKER_PWD', variable: 'DOCKER_TOKEN')]) {
    


                    sh 'docker build . -t anushalokiny/app31:latest'
                    sh 'docker login -u anushalokiny -p ${DOCKER_TOKEN}'
                    sh 'docker push anushalokiny/app31:latest'
                    sh 'docker run -p 99:8080 -d anushalokiny/app31:latest'
                    
                }

                }
             }

            stage('Archive and clean workspace') {
                steps {
                    
                    archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
                    cleanWs()
                }

            }
    }
}