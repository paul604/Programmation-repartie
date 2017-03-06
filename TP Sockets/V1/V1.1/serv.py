#!/usr/bin/python3
# serveur en python 3

from socket import *

HOST = ''
PORT = 50007

s = socket()
s.bind((HOST, PORT))
s.listen(7)

conn, addr = s.accept()
print ('connecte par ', addr)
while 1:
    data = conn.recv(1024)
    if not data:
        break
    conn.send('serv '+data)
conn.close()
