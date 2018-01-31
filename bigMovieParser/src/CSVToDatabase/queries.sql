
CREATE TABLE movies (
    MOVIE_ID INTEGER not NULL,
    title VARCHAR(255) not NULL,
    director VARCHAR(100) not NULL,
    producer VARCHAR(100) not NULL,
    writer VARCHAR(100) not NULL,
    genre VARCHAR(100) not NULL,
    duration INTEGER,
    productionTime INTEGER,
    PRIMARY KEY ( MOVIE_ID )
 );

CREATE TABLE persons (
    PERSON_ID INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    biography VARCHAR(1000),
    aka VARCHAR(100),
    dob DATE NOT NULL,
    birthplace VARCHAR(100),
    role VARCHAR(100),
    type VARCHAR(100),
    PRIMARY KEY ( PERSON_ID )
);


CREATE TABLE series (
    SERIE_ID INTEGER not NULL,
    title VARCHAR(255) not NULL,
    seasons INTEGER,
    PRIMARY KEY ( SERIE_ID )
);

CREATE TABLE seasons (
  SEASON_ID INTEGER not NULL PRIMARY KEY,
  seasonnumber INTEGER not NULL,
  SERIE_ID INTEGER not NULL ,
  FOREIGN KEY (SERIE_ID),
  REFERENCES series (SERIE_ID),
  PRIMARY KEY ( SEASON_ID )
);

String sql = "CREATE TABLE afleveringVan " +
		"(afleveringV_ID INTEGER not NULL PRIMARY KEY , " +
		" seizoen_ID INTEGER not NULL, " +
		" film_ID INTEGER not NULL , " +
		"FOREIGN KEY (seizoen_ID)" +
		"REFERENCES seizoen (seizoen_ID)," +
		"FOREIGN KEY (film_ID)" +
		"REFERENCES film (film_ID))";

String sql = "CREATE TABLE gewerktAan " +
		"(gewerktAan_ID INTEGER not NULL PRIMARY KEY , " +
		"persoon_ID INTEGER not NULL, " +
		"film_ID INTEGER not NULL, " +
		"rol VARCHAR(100) not NULL , " +
		"FOREIGN KEY (persoon_ID)" +
		"REFERENCES persoon (persoon_ID)," +
		"FOREIGN KEY (film_ID)" +
		"REFERENCES film (film_ID))";
