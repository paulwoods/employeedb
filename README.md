# Employee Database
Sample application for teaching spring security

### Start with unsecured application

2. Run the application

Note that none of the pages requires an authenticated user, and
any use is able to change any data.

### Step 1: Add the Security Starter

1. Checkout the tag initial-app
2. In build.gradle dependencies block, add

        ...
        dependencies {
            ...
            compile('org.springframework.boot:spring-boot-starter-security')
            ...
        }
        ...

3. If necessary, refresh your IDE's gradle dependencies.
4. Run the application.

Adding this starter adds spring security to the classpath of the
application, and configures it with a default configuration.
When any page is accessed, spring will ask for the user and password.
The default user is 'user'. The password can be found by looking
through the logs:


    2016-03-14 19:34:09.256  INFO 11952 --- [ost-startStop-1] b.a.s.AuthenticationManagerConfiguration :

    Using default security password: 16a01371-b881-4a40-b9f7-288e3e4ee7b2

    2016-03-14 19:34:09.469  INFO 11952 --- [ost-startStop-1] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: OrRequestMatcher [requestMatchers=[Ant [pattern='/css/**'], Ant [pattern='/js/**'], Ant [pattern='/images/**'], Ant [pattern='/**/favicon.ico'], Ant [pattern='/error']]], []

This password will change every time the application is ran.


### Set the Username and Password

After running the application a few times, you will grow tired of
searching for the password, and you will want hard code it
(atleast during development).

1. Checkout the tag spring-starter
1. Edit the src\main\resources\application.properties file
2. Add security.user.name and security.user.password and set their
   values to the username and password.

        security.user.name=paul
        security.user.password=123456

3. Now, when you login, your username and password are fixed values.

### Accessing the Principal

When someone logs in (the Principal), you can access this data
in your controllers.

1. Add Principal principal to the methods of your controller(s).





* Add & Explain
  * User (UserDetails)
  * Role (Enum)
  * Authority (GrantedAuthority)
  * UserDetailsService
  * SecurityConfig (WebSecurityConfigurerAdapter)
* Encrypting password in database
  * Authorization  
* Logging in:
  * Basic Digest Login
  * Form Login
* 
* External Authentication (SSO)
* 
* @PreAuthorize
* 
* JWT
*
