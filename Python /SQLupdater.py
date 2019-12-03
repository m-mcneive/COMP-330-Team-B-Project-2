import mysql.connector
from mysql.connector import Error

def mysql_update(email_data):
    try:
        connection = mysql.connector.connect(host='localhost',
                                             database='DoyleHall',
                                             user='root',
                                             password='GroupB171110')
        if connection.is_connected():
            db_Info = connection.get_server_info()
            print("Connected to MySQL Server version ", db_Info)
            cursor = connection.cursor()
            cursor.execute("select database();")
            record = cursor.fetchone()
            print("You're connected to database: ", record)

            address_check = False
            mysql_command = """SELECT Email_Address FROM faculty;"""
            cursor.execute(mysql_command)
            for i in cursor.fetchall():
                if email_data[0] in i:
                    address_check = True
                    # now check subject and body
            if address_check:

                if email_data[1].lower() == "in":
                    # check the room number is there and valid
                    ###### POSSIBLE ERROR must check is the body of the email was empty and ask for room number
                    if email_data[2].isdigit():
                        floor = int(email_data[2][0])
                        room = int(email_data[2][1:])
                        mysql_command = "SELECT * FROM doyle_rooms"
                        cursor.execute(mysql_command)
                        if (floor, room) in cursor.fetchall():
                            mysql_command = 'UPDATE faculty SET Room_Num = \'' + email_data[
                                2] + '\', Room_Status = \'' + \
                                            email_data[1] + '\' WHERE Email_Address = \'' + email_data[0] + '\';'
                            cursor.execute(mysql_command)
                            print "updating in and room number"
                        else:
                            print "ERROR, no such room number " + email_data[2]
                    else:
                        print "ERROR, you said you were in but didn't list a valid room number in the body"

                elif email_data[1].lower() == "busy":
                    if email_data[2] == '':  # check to see if body is empty
                        mysql_command = 'SELECT Room_Num FROM faculty WHERE Email_Address = \'' + email_data[0] + '\';'
                        cursor.execute(mysql_command)
                        if cursor.fetchall() != '0':  # check to see if the prof is already in a room
                            mysql_command = 'UPDATE faculty SET Room_Status = \'' + email_data[1] + \
                                            '\' WHERE Email_Address = \'' + email_data[0] + '\';'
                            cursor.execute(mysql_command)
                            print "updating busy, no room in email"
                        else:
                            print "Error, you said you're busy but we have no clue what room you should be in"
                    elif email_data[2].isdigit():  # if it's not empty, then check to see if body is a number
                        floor = int(email_data[2][0])
                        room = int(email_data[2][1:])
                        mysql_command = "SELECT * FROM doyle_rooms"
                        cursor.execute(mysql_command)
                        if (floor, room) in cursor.fetchall():
                            mysql_command = 'UPDATE faculty SET Room_Num = \'' + email_data[
                                2] + '\', Room_Status = \'' + \
                                            email_data[1] + '\' WHERE Email_Address = \'' + email_data[0] + '\';'
                            cursor.execute(mysql_command)
                            print "updating busy and room number"  # this will run if the email contains something in the body
                        else:
                            print "ERROR, no such room number " + email_data[2]
                    else:
                        print "we see you are busy, but unfortunately there is no room number " + email_data[2]

                elif email_data[1].lower() == "out":
                    mysql_command = 'UPDATE faculty SET Room_Num = \'0\', Room_Status = \'out\' WHERE Email_Address = ' \
                                    '\'' + email_data[0] + '\';'
                    cursor.execute(mysql_command)
                    print "updating out"
                else:
                    print 'input'

                connection.commit()
                print "DB has been updated"

            else:
                print "looks like you\'re not on the email list"

    except Error as e:
        print("Error while connecting to MYSQL", e)

    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")