[![verify](https://github.com/bootique-examples/bootique-shiro-examples/actions/workflows/verify.yml/badge.svg)](https://github.com/bootique-examples/bootique-shiro-examples/actions/workflows/verify.yml)
# Bootique 4.x Shiro Examples

Simple [Bootique](http://bootique.io) app demonstrating the Bootique Shiro Module with Jersey.

You can find different versions of framework in use at
* [4.x](https://github.com/bootique-examples/bootique-shiro-examples/tree/4.x)
* [2.x](https://github.com/bootique-examples/bootique-shiro-examples/tree/2.x)
* [1.x](https://github.com/bootique-examples/bootique-shiro-examples/tree/1.x)

# Prerequisites
* Java 21 or newer.
* Apache Maven.

# Build the demo

```bash
git clone git@github.com:bootique-examples/bootique-shiro-examples.git
cd bootique-shiro-examples
mvn clean package
```

Enter the following to launch the app:

```bash
java -jar target/bootique-shiro-examples-4.0.jar
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
