Skelton of Jubatus Client Application in Java
=============================================

Requirements
------------

* Jubatus 0.4.0 (server)
* [Eclipse IDE for Java Developers](http://www.eclipse.org/downloads/)
    * Tested with Indigo SR2 (3.7.2) and Juno SR1 (4.2.1).
    * Note: `Java EE Developers` edition does not support Git by default.

Usage
-----

To import a skelton project to Eclipse IDE:

1. Choose `Import...` from `File` menu.
2. Select `Git` > `Projects from Git`, then click `Next`.
3. Select `URI`, then click `Next`.
4. Fill `URI` field with `https://github.com/jubatus/jubatus-java-skelton.git`, then click `Next`.
5. Follow the instruction on the dialog and complete the wizard.

Once the import has been completed, Maven will automatically download Jubatus client library and other dependencies.

Now, direct to `src/main/java/` directory.
You will see `Client.java` in the `(default package)` tree.
`Client.java` is a simple example that illustrates the usage of Jubatus recommender.

To run the client program, right-click on the `Client.java` and select `Run As` > `Java Application`.
Make sure you start the `jubarecommender` process before running the client.
