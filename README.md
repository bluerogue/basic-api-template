# Basic Java API Template

<p>
This project is configured to deploy in a Tomcat servlet container, but can easily be used in other application servers with very little modification.
</p>
<p>
It is built in the Eclipse IDE and the various configuration files are included for import and/or reference (since this is to serve as a project template after all). In general, the .classpath and .project files along with the .settings directory are unnecessary. A war file is also available in the target directory.
</p>

## To Run:

<p>
You will need Tomcat7 and Maven. From the project root, run:<br>
`mvn tomcat7:deploy -e`<br>
or to redeploy:<br>
`mvn tomcat7:redeploy -e`<br>
</p>

## Notes:

<p>
This application expects a Tomcat user:pass of `admin:admin` for deployment. This can easily be changed in the `pom.xml` to meet your needs.	
</p>
<p>
The default application context is:
[http://localhost:8080/api-template/](http://localhost:8080/api-template/)
and you can test the API at:
[http://localhost:8080/api-template/1.0/api?email=apiuser@test.com](http://localhost:8080/api-template/1.0/api?email=apiuser@test.com)
</p>
<p>
The default user:pass to access the API over http is `api:api`.
</p>
<p>
Basic Auth is set up for this API application and can be found in`securityContext.xml`.
</p>
<p>
Also note that `jdbc.properties` is placed in the classes directory and preconfigured code is commented out in `applicationContext.xml` to help you easily connect to a database.
</p>
<p>
Have fun!
<br>
Matthew
</p>