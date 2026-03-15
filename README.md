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

After launching the app, go to

1. `http://localhost:8080/login.jsp` check for permissions to have role 'admin', if have no permissions will redirect to `/denied` page, otherwise to public page
2. `http://localhost:8080/pub` get public page returns hello
3. `http://localhost:8080/login?username=username&password=password` log in the user with specified username and password.
    There is two users:
    * user/password - has role 'user'
    * adminuser/password - has role 'admin'
    After succes login you will be redirected to '/login.jsp' page. If you will specify wrong credentials you will see the 404 error.
4.  `http://localhost:8080/logout` logges out. After logout you will see 'Logged out' message.
5.  `http://localhost:8080/private` endpoint with configured  permissions in `bootique.yml` file.
If you logged in with 'admin' role you will see 'admin' message otherwise you will be redirected to `/login.jsp`
