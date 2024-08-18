# Automation project for [Duolingo app](https://www.duolingo.com/) [<img width="10%" title="Duolingo" src="media/icons/Duolingo.svg"/>](https://www.duolingo.com/)
>With more than 500 million learners, Duolingo has the world's largest collection of language-learning data at its fingertips. This allows us to build unique systems, uncover new insights about the nature of language and learning, and apply existing theories at scales never before seen.

## :scroll: Table of contents
- [Technology stack](#computer-technology-stack)
- [Automated tests](#heavy_check_mark-automated-tests)
- [Jenkins build](#-jenkins-build)
- [Allure report](#-allure-report)
- [Allure TestOps](#-allure-testOps)
- [Jira](#-jira)
- [Telegram notifications](#-telegram-notifications)
- [Test execution](#movie_camera-test-execution)

## :computer: Technology stack
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg"/></a> 
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/icons/Java.svg"/></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/icons/Selenide.svg"/></a>
<a href="https://appium.io/"><img width="6%" title="Appium" src="media/icons/Appium.svg"/></a> 
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/icons/Allure_Report.svg"/></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/icons/Gradle.svg"/></a> 
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/icons/JUnit5.svg"/></a> 
<a href="https://rest-assured.io/"><img width="6%" title="RestAssured" src="media/icons/RestAssured.svg"/></a> 
<a href="https://qameta.io/"><img width="6%" title="Allure TestOps" src="media/icons/Allure_TO.svg"/></a> 
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/icons/GitHub.svg"/></a> 
<a href="https://www.browserstack.com/"><img width="6%" title="Browserstack" src="media/icons/Browserstack.svg"/></a> 
<a href="https://developer.android.com"><img width="6%" title="Andriod Studio" src="media/icons/Android_Studio.svg"/></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg"/></a>
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/icons/Telegram.svg"/></a> 
<a href="https://www.atlassian.com/ru/software/jira"><img width="6%" title="Jira" src="media/icons/Jira.svg"/></a>
</p>

Automated tests:
- Implemented in ```Java``` language
- ```Gradle``` is used as a collector
- The frameworks used are ```JUnit 5``` and ```Selenide```
- For making flexible tests ```Owner``` technology is used
- ```Faker``` is used to generate data
- ```Lombok``` is used for models in API tests
- ```Jenkins``` is used for remote launch
- Integration with ```Jira``` and ```Allure TestOps``` created
- ```Allure Report``` is generated for the build
- Sending ```Telegram``` notifications about results is configured
- ```Browserstack``` is used to run mobile tests remotely
- To run mobile tests locally on emulator or real device, ```Appium``` and ```Android Studio``` are used


Based on results of passing autotests, an Allure report is generated. Contents of the report:
* Test steps
* Screenshot of the page at the last step
* Source code
* Browser console logs
* Test execution video

## :heavy_check_mark: Automated tests

### *Mobile:*
- Check Forgot Password feature with correct email address
- Check Forgot Password feature with invalid email address shows error message
- Check Send Email button is not clickable until email is entered
- Check Quit button returns to login screen
- Check successful login
- Check Sign In button is not clickable until login and password are entered
- Check Facebook button is visible
- Check Google button is visible

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/icons/Jenkins.svg"> [Jenkins build](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/)
[<img width="100%" title="Jenkins" src="media/img/Jenkins.PNG"/>](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/)
### *Launch commands*

***Locally:***

By default, autotests run remotely in Browserstack, and there is no need to additionally configure local devices and Appium server.
To run autotests on local devices:
1. Launch Appium Server, Appium Inspector and a real device/emulator on which the tests will be run.
2. Update device settings in ```resources/real.properties``` or ```resources/emulation.properties``` files.

To run all mobile autotests locally on a real device (need login and password to log in to Duolingo account):
```bash
gradle clean test -DdeviceHost=real -Dlogin='' -Dpassword=''
or
gradle clean mobile -DdeviceHost=real -Dlogin='' -Dpassword=''
```

To run all mobile autotests locally on an emulator:
```bash
gradle clean test -DdeviceHost=emulation -Dlogin='' -Dpassword=''
or
gradle clean mobile -DdeviceHost=emulation -Dlogin='' -Dpassword=''
```

To run mobile autotests with tag <code>login</code> (or <code>forgot</code>):
```bash
gradle clean login -Dlogin='' -Dpassword=''
gradle clean forgot -Dlogin='' -Dpassword=''
```

***Via Jenkins:***
Tests are launched in Browserstack by default:
```bash
clean 
${TASK}
-"Dlogin=${LOGIN}"
-"Dpassword=${PASSWORD}"
```

To start the build:
1. Go to the build
2. Click on ```Build```

## <img width="4%" style="vertical-align:middle" title="Allure_Report" src="media/icons/Allure_Report.svg"> [Allure report](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/allure/)
After the build is completed the icons [<img width="2%" title="Allure" src="media/icons/Allure_Report.svg"/>](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/allure/) and [<img width="2%" title="Allure TestOps" src="media/icons/Allure_TO.svg"/>](https://allure.autotests.cloud/project/4389/dashboards) are displayed in ```Build History```.
When clicking on the [<img width="2%" title="Allure" src="media/icons/Allure_Report.svg"/>](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/allure/) icon, a page with a generated html report and test documentation opens. When clicking on the [<img width="2%" title="Allure TestOps" src="media/icons/Allure_TO.svg"/>](https://allure.autotests.cloud/project/4389/dashboards) icon a project page in Allure TestOps opens.
### *Main report page*
[<img width="100%" title="Main report page" src="media/img/Allure_main_report_page.PNG"/>](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/allure/)

### *Test cases*
[<img width="100%" title="Test cases" src="media/img/Allure_test_cases.PNG"/>](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/allure/#suites)

### *Graphs*
[<img width="100%" title="Graphs" src="media/img/Allure_graphs.PNG"/>](https://jenkins.autotests.cloud/job/027-wqmnzx-duolingo_mobile_diplom/allure/#graph)

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/icons/Allure_TO.svg"> [Allure TestOps](https://allure.autotests.cloud/project/4389/dashboards)

```Allure TestOps``` is a test management platform that provides a comprehensive set of tools for organizing, executing, and analyzing tests in projects.

### *Dashboard*
Summary information about the current testing status of the project:
[<img width="100%" title="Dashboard" src="media/img/Allure_TO_dashboards.PNG"/>](https://allure.autotests.cloud/project/4389/dashboards)

### *Launches*
This section displays test runs launched from Jenkins and Allure TestOps:
[<img width="100%" title="Launches" src="media/img/Allure_TO_launches.PNG"/>](https://allure.autotests.cloud/project/4389/launches)

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/icons/Jira.svg"> [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1329)

Integration of Jira and Allure TestOps allows to link tasks and test documentation, which helps manage product quality effectively.
### *Jira task*
[<img width="100%" title="Jira task" src="media/img/Jira_task.PNG"/>](https://jira.autotests.cloud/browse/HOMEWORK-1329)

### *Allure: Launches*
[<img width="100%" title="Allure: Test Cases" src="media/img/Jira_launches.PNG"/>](https://jira.autotests.cloud/browse/HOMEWORK-1329)

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Telegram notifications

After the build is completed, a special bot created in ```Telegram``` automatically processes and sends a message with a test run report.

[<img width="60%" title="Telegram Notifications" src="media/img/Telegram_notification.PNG">]()

## :movie_camera: Test execution

[<img width="50%" title="Test Run Gif" src="media/img/Mobile_test.gif">]()
