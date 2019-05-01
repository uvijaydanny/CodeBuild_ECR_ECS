pipeline {
agent any
    tools {
        maven 'localMaven'
    }
    parameters {
        string(name: 'Greeting', defaultValue: 'Hello', description: 'How should I greet the world?')
    }
stages{
        stage('Build'){
            steps {
                bat 'mvn clean package'
                bat "docker build . -t bookservice:${env.BUILD_ID}"
            }
        }
        stage('Run') {
        	steps {
        		bat "docker run -p 8081:8081 -d bookservice:${env.BUILD_ID}"
        	}
        }
    }
}