pipeline{
    agent any 
    stages {
        stage('pull'){
            steps{
                git branch: 'dev', url: 'https://github.com/mayurmwagh/ONCDEC-B13-Frontend.git'
            }
        }
        stage('build'){
            steps{
                sh '''
                    npm install
                    ng build 
                '''
            }
        }
        stage('deploy'){
            steps{
                sh '''
                    aws s3 cp --recursive dist/angular-frontend s3://oncdec-13-new-cbz-frontend-project-bux/
                '''
            }
        }
    }
}