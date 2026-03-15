[![verify](https://github.com/bootique-examples/bootique-shiro-examples/actions/workflows/verify.yml/badge.svg)](https://github.com/bootique-examples/bootique-shiro-examples/actions/workflows/verify.yml)
# Bootique 4.x Shiro Examples

This is an example Bootique Jetty app.

Different Git branches contain example code for different versions of Bootique:
* [4.x](https://github.com/bootique-examples/bootique-shiro-examples/tree/4.x)
* [2.x](https://github.com/bootique-examples/bootique-shiro-examples/tree/2.x)
* [1.x](https://github.com/bootique-examples/bootique-shiro-examples/tree/1.x)

## Prerequisites
To build and run the project, ensure you have the following installed on your machine:

* Java 21 or newer
* Maven

and then follow these steps:

## Checkout
```
git clone git@github.com:bootique-examples/bootique-shiro-examples.git
cd bootique-shiro-examples
```

## Build, test and package
Run the following command to build the code, run the tests and package the app:
```
mvn clean package
```

## Run
Start the server with the `-s` (`--server`) command and configuration file: 
```bash
java -jar target/bootique-shiro-examples-4.0.jar --server --config=config.yml
```

First, go to http://localhost:8080/public in the browser. You should see the text `Hi! This API is public, and you are 
not logged in.`

Now go to http://localhost:8080/private . You should see a login prompt. Enter `user1` / `password` as credentials, and 
then the following response should appear: `Hi, user1! This API is protected. You are logged in as 'user'.`

Finally, open new private browser window and go to the same URL (http://localhost:8080/private) but login as `user2` / 
`password`. The following response should appear: `Hi, user2! This API is protected. You are logged in as 'admin'.`
