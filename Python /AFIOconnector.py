import time
import SQLupdater
from Adafruit_IO import Client, Feed, RequestError


def split_and_send(email_data):
    list_data = str(email_data).split("#")
    print list_data
    SQLupdater.mysql_update(list_data)

ADAFRUIT_IO_USERNAME = "dgubala"
ADAFRUIT_IO_KEY = "a65a0efced604e27b3f357e48aaa7210"

aio = Client(ADAFRUIT_IO_USERNAME, ADAFRUIT_IO_KEY)

try:    # if we have a 'email' feed
    email = aio.feeds('email')
except RequestError:    # create a email feed
    feed = Feed(name="email")
    email = aio.create_feed(feed)

data = aio.receive('email')
split_and_send(data.value)
while True:
    print data.value
    time.sleep(1)
    previous_data = data
    data = aio.receive('email')

    if previous_data != data:
        split_and_send(data.value)

