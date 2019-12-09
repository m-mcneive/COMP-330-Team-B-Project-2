# COMP-330-Team-B-Project-2
This project is our attempt to add create a living map of Doyle Hall 
which would allow professors to update their status in the building while 
students would be able to view this information.

It is a work-in-progress at this point. 
An email sent by the professor would be processed by IFTTT and sent to adafruit io which the rapberry pi
is pinging constantly to get updated information. Once a new email is sent, the process begins and the database is updated by the 
Python scripts. The Python script then triggers DBMS to manipulate FloorLayout to edit and save an updated map with colored rectangles indicating
the status of the professor with green as open, yellow as busy, and red as closed. The website front end is built with basic
php and HTML. The HTML pulls the images and the php displays all professors in the database that are not out. 

The only issue was setting up an email to work with IFTTT as it only work with David's own luc.edu email instead of a cs.luc.edu email.
The project was also scaled back to have the rapberry pi hooked up to a monitor that could display this information at Doyle or through a website instead
of the student being able to access it on their phone

Programs and chief creators
Alex Chan-FloorLayout.java  - in collaboration with Matt
Matt McNeive-DBMS.java
David Gubala-AFIOConnector.py
             EmailReturn.py - in collaboration with Matt
             SQLupdater.py
             Doyle Hall.sql
