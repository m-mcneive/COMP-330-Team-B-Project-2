import time
import SQLupdater
from Adafruit_IO import Client, Feed, RequestError


def split_and_send(email_data):
    list_data = str(email_data).split("#")
    print list_data
    SQLupdater.mysql_update(list_data)

ADAFRUIT_IO_USERNAME = "doylehall"
ADAFRUIT_IO_KEY = "2dbfe71ae99245b7bfdf123242f3dce9"

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
