**This is a template README.md.  Be sure to update this with project specific content that describes your ui test project.**

# single-cust-account-wrapper-acceptance-ui-tests
UI test suite for the `<digital service name>` using WebDriver and `<scalatest/cucumber>`.  

## Running the tests

## Running SCA Wrapper tests
1. Clone the project [https://github.com/hmrc/single-cust-account-wrapper-acceptance-ui-tests]  to a directory of your choice
2. Clone the local-selenium-grid [https://github.com/hmrc/local-selenium-grid ] to a directory of your choice
3. On a terminal instance run: `sm2 --start SCA_FUTURES_ALL`
4. Make sure all  you services are running: `sm2 -s`
5. Navigate to the directory where you cloned local-selenium-grid
6. Start local-selenium-grid: `./start.sh`
7. Navigate to the directory where you cloned the tests
8. Run: `./run_tests.sh`

## Running Integration Services SCA wrapper

Then execute the `./run_integration_serivce.sh` script:

## Running NINO tests

-  FindMyNinoJourney.feature 
   cd sca-webApp
   Then execute the `sm2 --start SCA_FUTURES_ALL` in sca-webApp
   cd find-my-nino-add-to-wallet-frontend
   Then execute the `sbt run` in find-my-nino-add-to-wallet-frontend
   cd find-my-nino-add-to-wallet:
   Then execute the `sbt run` in find-my-nino-add-to-wallet
   Then execute the ` ./run_local.sh` script:

## Running CHOCS tests

- clone repo: sca-change-of-circumstances-frontend
  cd SCA_CHANGE_OF_CIRCUMSTANCES_FRONTEND
  Then execute 
  `  sbt run SCA_CHANGE_OF_CIRCUMSTANCES_FRONTEND --appendArgs '{"SCA_CHANGE_OF_CIRCUMSTANCES_FRONTEND":["-Dfeatures.pta-mode=true"]}'

sm2 --start SCA_CHANGE_OF_CIRCUMSTANCES_ALL  `  in SCA_CHANGE_OF_CIRCUMSTANCES_FRONTEND

## Running ActionsComponent.feature tests

- clone repo: single-customer-account-capabilities
  Then execute the `sbt run` single-customer-account-capabilities
  
- clone repo: single-customer-account-stub
  Then execute the `sbt run` single-customer-account-stub
  
- clone repo: single-customer-account-frontend
  Then execute the `sbt run` single-customer-account-frontend

- sm2 --start SCA_FUTURES_ALL
  Then execute the `./run_tests.sh` script

## Running ActivitiesComponent.feature tests

Then execute the `./run_tests.sh` script


## Running tests against a containerised browser - on a developer machine

The script `./run_browser_with_docker.sh` can be used to start a Chrome, Firefox or Edge container on a developer machine. 
The script requires `remote-chrome`, `remote-firefox` or `remote-edge` as an argument.

Read more about the script's functionality [here](run_browser_with_docker.sh).

To run against a containerised Chrome browser:

```bash
./run_browser_with_docker.sh remote-chrome 
./run_tests.sh remote-chrome local
```

`./run_browser_with_docker.sh` is **NOT** required when running in a CI environment. 

> :warning: **SM2 **: If you use [SM2](https://github.com/hmrc/sm2) rather than [service manager](https://github.com/hmrc/service-manager) please note that this is **NOT** currently supported in build Jenkins.

#### Running the tests against a test environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf). 

For example, to execute the `run_tests.sh` script using Chrome remote-webdriver against QA environment 

    ./run_tests.sh remote-chrome qa

## Running ZAP tests

ZAP tests can be automated using the HMRC Dynamic Application Security Testing approach. Running 
automated ZAP tests should not be considered a substitute for manual exploratory testing using OWASP ZAP.

#### Tagging tests for ZAP

It is not required to proxy every journey test via ZAP. The intention of proxying a test through ZAP is to expose all the
 relevant pages of an application to ZAP. So tagging a subset of the journey tests or creating a 
 single ZAP focused journey test is sufficient.

#### Configuring the browser to proxy via ZAP 

Setting the system property `zap.proxy=true` configures the browser specified in `browser` property to proxy via ZAP. 
This is achieved using [webdriver-factory](https://github.com/hmrc/webdriver-factory#proxying-trafic-via-zap).

#### Executing a ZAP test

The shell script `run_zap_tests.sh` is available to execute ZAP tests. The script proxies a set of journey tests, 
tagged as `ZapTests`, via ZAP.  

For example, to execute ZAP tests locally using a Chrome browser

```
./run_zap_test.sh chrome local
```

To execute ZAP tests locally using a remote-chrome browser

```
./run_browser_with_docker.sh remote-chrome 
./run_zap_test.sh remote-chrome local
``` 

`./run_browser_with_docker.sh` is **NOT** required when running in a CI environment.

### Running tests using BrowserStack
If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/main/README.md/#user-content-running-tests-using-browser-stack) project.

## Installing local driver binaries

This project supports UI test execution using Firefox (Geckodriver) and Chrome (Chromedriver) browsers. 

See the `drivers/` directory for some helpful scripts to do the installation work for you.  They should work on both Mac and Linux by running the following command:

    ./installGeckodriver.sh <operating-system> <driver-version>
    or
    ./installChromedriver <operating-system> <driver-version>

- *<operating-system>* defaults to **linux64**, however it also supports **macos**
- *<driver-version>* defaults to **0.21.0** for Gecko/Firefox, and the latest release for Chrome.  You can, however, however pass any version available at the [Geckodriver](https://github.com/mozilla/geckodriver/tags) or [Chromedriver](http://chromedriver.storage.googleapis.com/) repositories.

**Note 1:** *You will need to ensure that you have a recent version of Chrome and/or Firefox installed for the later versions of the drivers to work reliably.*

**Note 2** *These scripts use sudo to set the right permissions on the drivers so you will likely be prompted to enter your password.*

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
