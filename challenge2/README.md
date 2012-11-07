Challenge 2
===========

This is a version of the famous game "triqui", developed with a distributed arquitecture.

the players can play in different machines and the set ends when one of them complete a consecutive sequence of three "O" or "X".

Clone the repository:

````bash
$ git clone git@github.com:Tille/Network-Algorihtms.git
$ cd Network-Algorihtms
````

Compile the files:

````bash
$ ant init
$ ant compile
````

Run the server:

````bash
$ ant server-run
````

Run a client (there must be almost two players/clients for play):

````bash
$ ant client-run
````

Clean the folder:

````bash
$ ant clean
````