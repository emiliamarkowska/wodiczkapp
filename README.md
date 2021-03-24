<!-- # wodiczkapp -->
# Wodiczka

This fullstack web application was written in Spring and React. Our product was designed in mind with people who were enviroment conscious and wanted to become more resourceful with water at home. Application presents water usage reports in a friendly and enjoyable way. It is full of fun facts and tips how to become aware of water-waste problem and enables to keep track of the amount of water used.

<p align="center">
  <img width="269" src="images/2.png">
  <img width="267" src="images/3.png">
</p>

## Prerequisites
* Node.js
* Java JDK 11
* [Docker](https://docs.docker.com/get-docker/) & [docker compose](https://docs.docker.com/compose/)

## Installation
* Clone repository to desired directory
`git clone https://github.com/emiliamarkowska/wodiczkapp.git`
* `cd wodiczkapp`

## Run with docker

```dockerfile
docker-compose up
```
This will start Java backend, React frontend and MySQL database in separate Docker containers, ready to communicate with each other and be used by developer and a user.

Visit http://127.0.0.1:9090 to access the application.

## Sensor ESP32 board
To enable sensor correct work and connection with the database, IP address and port of the machine it's running on, eg. in local network, is needed. As for now, unfortunately it needs to be put manually in code and compiled onto the ESP32 board.

## Local address
Use `ifconfig` (or `ipconfig` on Windows) command to find your machine's address in local network. It will be used by sensor board, but also can be used by any other device connected to the same network (eg. mobile phone) to access wodiczkapp.

## Contributors
* [emiliamarkowska](https://github.com/emiliamarkowska)
* [michalsuliborski](https://github.com/michalsuliborski)
* [adamnapieralski](https://github.com/adamnapieralski)
* [szymonrucinski](https://github.com/szymonrucinski)
* [217868](https://github.com/) (Arkadiusz Zasina)
