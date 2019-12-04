import smtplib

def send_email(email_data, code):
    server = smtplib.SMTP('smtp-mail.outlook.com', 587)
    server.ehlo()
    server.starttls()
    server.ehlo()

    server.login('dgubala@luc.edu', 'Save_load0727')
    # codes will come in as a number 0-4
    # 0 = NoRoomError
    # 1 = InvalidRoomNumberError
    # 2 = InvalidSubjectError
    # 3 = NotOnEmailListError
    # 4 = Success
    format = "To: DoyleHall@luc.edu\nSubject :" + email_data[1].upper() + "\nBody: 201 " \
                                                                          "\nThe Subject of the email should be " \
                                                                          "your Room Status: IN, OUT, or BUSY. The " \
                                                                          "Body of the email should include a room " \
                                                                          "number unless you are changing your " \
                                                                          "status to OUT."
    if code == 0:
        subject = 'Error: No Room Number'
        body = 'Hello, \n\t ' \
               'Unfortunately, it looks like Doyle Hall\'s SmartMap has encountered an issue. The system recognizes' \
               'that you are ' + email_data[1].upper() + ', but we don\'t know you\'re room number. ' \
                                                         'Please, send another email following this example.' \
                                                         '\n\n' + format + '\n\n-SucculentPie'
        msg = "Subject: {0}\n\n{1}".format(subject, body)
        server.sendmail('dgubala@luc.edu', email_data[0], msg)
        print('Email Sent')
        server.quit()
        return 'NoRoomError'
    elif code == 1:
        subject = 'Error: Invalid Room Number'
        body = 'Hello, \n\t ' \
               'Unfortunately, it looks like Doyle Hall\'s SmartMap has encountered an issue. The system recognizes' \
               'that you are ' + email_data[1].upper() + ', but ' + email_data[2] + ' is not a valid room number. ' \
                                                                                    'Please, send another email ' \
                                                                                    'following this example.' \
                                                                                    '\n\n' + format + '\n\n-SucculentPie'
        msg = "Subject: {0}\n\n{1}".format(subject, body)
        server.sendmail('dgubala@luc.edu', email_data[0], msg)
        print('Email Sent')
        server.quit()
        return 'InvalidRoomNumberError'
    elif code == 2:
        subject = 'Error: Invalid Room Status'
        body = 'Hello, \n\t ' \
               'Unfortunately, it looks like Doyle Hall\'s SmartMap has encountered an issue. The system does ' \
               'not recognize your room status: ' + email_data[1] + '. Please, send another email following ' \
                                                                    'this example.\n\n' + format + '\n\n-SucculentPie'
        msg = "Subject: {0}\n\n{1}".format(subject, body)
        server.sendmail('dgubala@luc.edu', email_data[0], msg)
        print('Email Sent')
        server.quit()
        return 'InvalidSubjectError'
    elif code == 3:
        subject = 'Error: Invalid User'
        body = 'Hello, \n\t ' \
               'Unfortunately, it looks like Doyle Hall\'s SmartMap has encountered an issue. The system does ' \
               'not recognize you as a registered email address. Please contact the admin to be added to the list.' \
               '\n\n-SucculentPie'
        msg = "Subject: {0}\n\n{1}".format(subject, body)
        server.sendmail('dgubala@luc.edu', email_data[0], msg)
        print('Email Sent')
        server.quit()
        return 'NotOnEmailListError'
    elif code == 4:
        subject = 'Success'
        body = 'Hello, \n\t ' \
               'It looks like you have successfully updated your status to '+ email_data[1].upper() + ' on ' \
                'Doyle Hall\'s SmartMap. Please DO NOT forget to update your status to OUT before you leave. ' \
                'Just in case you need a refresher on the formatting of these emails, there will be an example below.' \
                '\n\n' + format + '\n\n-SucculentPie'
        msg = "Subject: {0}\n\n{1}".format(subject, body)
        server.sendmail('dgubala@luc.edu', email_data[0], msg)
        print('Email Sent')
        server.quit()
        return 'Success'

    subject = ''
    body = 'test'
    msg = "Subject: {0}\n\n{1}".format(subject, body)
    server.sendmail('dgubala@luc.edu', 'dgubala727@gmail.com', msg)
    print('Email Sent')
    server.quit()
