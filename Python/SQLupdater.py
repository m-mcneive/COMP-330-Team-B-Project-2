import mysql.connector
from mysql.connector import Error
import os
import EmailReturn

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
            email_data = ['dgubala727@gmail.com', 'out', '']

            mysql_command = """SELECT Email_Address FROM faculty;"""
            cursor.execute(mysql_command)
            for i in cursor.fetchall():
                if email_data[0] in i:
                    address_check = True

            mysql_command = "SELECT * FROM doyle_rooms;"
            cursor.execute(mysql_command)
            rooms_list = list(sum(cursor.fetchall(), ()))
            if address_check:
                if email_data[1].lower() == "in":
                    if email_data[2] == '':
                        mysql_command = 'SELECT Room_Num FROM faculty WHERE Email_Address = \'' + email_data[0] + '\';'
                        cursor.execute(mysql_command)
                        if cursor.fetchall() != '0':
                            mysql_command = 'UPDATE faculty SET Room_Status = \'' + email_data[1] + \
                                            '\' WHERE Email_Address = \'' + email_data[0] + '\';'
                        else:
                            mysql_command = ''
                            EmailReturn.send_email(email_data, 0)  # Error code 0 means no room number was given
                    elif email_data[2].isdigit():
                        if int(email_data[2]) in rooms_list:
                            mysql_command = 'UPDATE faculty SET Room_Num = \'' + email_data[2][1:] + \
                                            '\', Room_Floor = \'' + email_data[2][0] + '\', Room_Status = \'' + \
                                            email_data[1] + '\' WHERE Email_Address = \'' + email_data[0] + '\';'
                        else:
                            mysql_command = ''
                            EmailReturn.send_email(email_data, 1)  # Error code 1 means an invalid room number was given
                    else:
                        mysql_command = ''
                        EmailReturn.send_email(email_data, 1)

                elif email_data[1].lower() == "busy":
                    if email_data[2] == '':
                        mysql_command = 'SELECT Room_Num FROM faculty WHERE Email_Address = \'' + email_data[0] + '\';'
                        cursor.execute(mysql_command)
                        if cursor.fetchall() != '0':
                            mysql_command = 'UPDATE faculty SET Room_Status = \'' + email_data[1] + \
                                            '\' WHERE Email_Address = \'' + email_data[0] + '\';'
                        else:
                            mysql_command = ''
                            EmailReturn.send_email(email_data, 0)
                    elif email_data[2].isdigit():
                        if int(email_data[2]) in rooms_list:
                            mysql_command = 'UPDATE faculty SET Room_Num = \'' + email_data[2][1:] + \
                                            '\', Room_Floor = \'' + email_data[2][0] + '\', Room_Status = \'' + \
                                            email_data[1] + '\' WHERE Email_Address = \'' + email_data[0] + '\';'
                        else:
                            mysql_command = ''
                            EmailReturn.send_email(email_data, 1)
                    else:
                        mysql_command = ''
                        EmailReturn.send_email(email_data, 1)

                elif email_data[1].lower() == "out":
                    mysql_command = 'UPDATE faculty SET Room_Num = \'0\', Room_Floor = \'0\', Room_Status = \'out\' ' \
                                    'WHERE Email_Address = \'' + email_data[0] + '\';'
                else:
                    mysql_command = ''
                    EmailReturn.send_email(email_data, 2)  # Error Code 2 means the subject of the email was invalid
                    print 'ERROR, incorrect subject, either IN, OUT, or BUSY'

                if mysql_command != '':
                    cursor.execute(mysql_command)
                    connection.commit()
                    EmailReturn.send_email(email_data, 4)  # Code 4 means success
                    print "DB has been updated"
                    s = os.system('javac DBMS.java;java DBMS;')
                else:
                    print "nothing updated"

            else:
                EmailReturn.send_email(email_data,
                                       3)  # Error Code 3 means the address that had sent the message is valid
                print "looks like you\'re not on the email list"

    except Error as e:
        print("Error while connecting to MYSQL", e)

    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")