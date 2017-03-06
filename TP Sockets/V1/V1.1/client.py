#!/usr/bin/python

from socket import *

HOST  = 'localhost'
PORT = 50007
#s = socket(AF_INET, SOCK_STREAM)
s = socket()
s.connect((HOST, PORT))

i = 1
while i <= 20:
    s.send(b'Bonjour Vieux Serveur')
    i = i + 1
    data = s.recv(1024)
    print 'ok :', data

s.close()

print 'Client> j ai recu ', data
