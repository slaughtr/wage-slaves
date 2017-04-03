# _wage-slaves_

#### _wage-slaves, 04-03-2017_

#### By _**Dallas Slaughter and Alex Lee**_

## Description
_Example text for the description of the project_


## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|



## Setup/Installation Requirements

* _Clone the repository_
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_

CREATE DATABASE wage_slaves;
CREATE TABLE jobs (id serial PRIMARY KEY, name varchar, salary int, difficulty varchar, hours int, started timestamp, type varchar);
CREATE TABLE workers (id serial PRIMARY KEY, name varchar, race varchar);
CREATE database wage_slaves_test WITH TEMPLATE wage_slaves;

### License

Copyright (c) 2017 **_Dallas Slaughter and Alex Lee_**

This software is licensed under the MIT license.
