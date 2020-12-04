# Ergodecks
A deck builder for Magic: The Gathering

Many of the deck builders I've tried have felt unnatural to use, so I'm creating one that is built around drag and drop functionality.

This web app uses [Jackson](https://github.com/FasterXML/jackson) to write 55k entries(183mb .json file) to a SQL database. The database is accessed through a Spring API using [Hibernate](https://github.com/hibernate), and the frontend is a React app.

![Current State](/currentstate.png)
