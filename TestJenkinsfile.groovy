pipeline {

    agent {
        label "${Machine}"
    }
    stages {
        stage('Cloning') {
            steps {
                git branch: 'main',
                        credentialsId: '7b6d439f-1c79-416a-9192-eede38b0af48',
                        url: "git@github.com:wagih-essam/RestAssuredTraining.git"
            }
        }


        stage('Executing') {


            parallel {

                stage('run maven')

                        {
                            steps
                                    {

                                        echo 'starting maven build'

                                        dir('RestAssuredTraining'){

                                            bat """
                    set http_proxy=http://10.230.189.34:3128
                set https_proxy=http://10.230.189.34:3128
                  echo %http_proxy%
                    mvn clean test
                    """
                                        }
                                    }

                        }
            }

        }


    }
    post ("Post Actions"){
        always {

            echo 'Archiving reports'
            powershell '''
                $file = Get-ChildItem -Path . -Filter "Website-Framework/resources/reports/*.html"
                $file | Compress-Archive -Update -DestinationPath Website-Framework/resources/reports/report.zip
                '''
            archiveArtifacts artifacts: 'Website-Framework/resources/reports/report.zip'


            echo 'Sending email with build-log and tests-report files'

            emailext attachLog: true ,body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}\n Report link: https://jenkins.vf-eg.internal.vodafone.com/job/Testing/job/Enterprise_Digital_Website_Pipeline/${env.BUILD_NUMBER}/artifact/Website-Framework/resources/reports/report.zip", to: 'omar.emad@vodafone.com,aya.shehata@vodafone.com', subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}", mimeType: 'text/html'


            bat """
                del /Q "Website-Framework/resources/reports/"
                del /Q "Website-Framework/reports/"
                """

        }
    }
}