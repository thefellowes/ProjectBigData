package csv.to.sql;

import java.io.*;

public class Main {

    public static void main( String[] args ) throws IOException
    {
        Converter c = new Converter();

        // UNCOMMENT c.Convert lines to run parser

        // name.basics(DONE)
        //c.Convert( "name.basics", "((.+?)\\s+)((([A-Za-z\\'\\.\\-]+?)\\s+)(([A-Za-z\\'\\.\\-]+?)\\s+)(([A-Za-z\\'\\.\\-]+?)\\s+)?(([A-Za-z\\'\\.\\-]+?)\\s+)?(([A-Za-z\\'\\.\\-]+?)\\s+)?)((.+?)\\s+)?((.+?)\\s+)?((.+?)\\t)?(.+)", "$1$3$14$16$18$20" );

        // title.episodes(DONE)
        //c.Convert( "title.episode", "((.+?)\\s+)((.+?)\\s+)((.+?)\\s+)((.+?)\\s+)", "'$1','$3','$5','$7'" );

        // title.crew(DONE)
        //c.Convert( "title.crew", "((.+?)\\s+)((.+?)\\s+)((.+?)\\s+)", "'$1','$3','$5'" );

        // title.principals(DONE)
        //c.Convert( "title.principals", "(.+?\\s+)?((.+?)\\s+)?", "$1$3" );

        // title.ratings(DONE)
        //c.Convert( "title.ratings", "(.+?\\s+)?(.+?\\s+)?(.+?\\s+)?", "$1$2$3" );

        // title.akas
        //c.Convert( "title.akas", "((.+?)\\s+)((([A-Za-z\\'\\.\\-]+?)\\s+)(([A-Za-z\\'\\.\\-]+?)\\s+)(([A-Za-z\\'\\.\\-]+?)\\s+)?(([A-Za-z\\'\\.\\-]+?)\\s+)?(([A-Za-z\\'\\.\\-]+?)\\s+)?)((.+?)\\s+)?((.+?)\\s+)?(.+)", "$1$3$17$18" );

        // title.basics
        //c.Convert(  "title.basics", "((.+?)\\s+)", "$1" );



        ToSQL ts = new ToSQL();

        // actors(name.basics.csv)
        //ts.write( "LOAD DATA LOCAL INFILE 'c:/users/niels/ideaprojects/CSVToDatabase/csv/name.basics.csv' INTO TABLE actors FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' (nconst,primaryName,birthYear,deathYear,primaryProfession,knownForTitles)", "CREATE TABLE `actors` (nconst VARCHAR(64) NOT NULL,primaryName VARCHAR(512) NOT NULL,birthYear VARCHAR(16) NOT NULL,deathYear VARCHAR(16) NOT NULL,primaryProfession VARCHAR(512),knownForTitles VARCHAR(512) NOT NULL);" );

        // (akas)title.akas.csv
        //ts.write( "LOAD DATA LOCAL INFILE 'c:/users/niels/ideaprojects/CSVToDatabase/csv/title.akas.csv' INTO TABLE akas FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' (titleId, ordering, title, region, language, types, isOriginalTitle)", "CREATE TABLE akas ( titleId VARCHAR(64) NOT NULL, ordering VARCHAR(16) NOT NULL, title VARCHAR(512) NOT NULL, region VARCHAR(64) NOT NULL, language VARCHAR(128) NOT NULL, types VARCHAR(256) NOT NULL, isOriginalTitle VARCHAR(16) NOT NULL );" );

        // (movies)title.basics.csv
        //ts.write( "LOAD DATA LOCAL INFILE 'c:/users/niels/ideaprojects/CSVToDatabase/csv/title.basics.csv' INTO TABLE movies FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' ( tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres )", "CREATE TABLE movies ( tconst VARCHAR(64) NOT NULL, titleType VARCHAR(64) NOT NULL, primaryTitle VARCHAR(512) NOT NULL, originalTitle VARCHAR(512) NOT NULL, isAdult VARCHAR(16) NOT NULL, startYear VARCHAR(16) NOT NULL, endYear VARCHAR(16) NOT NULL, runtimeMinutes VARCHAR(16) NOT NULL, genres VARCHAR(512) NOT NULL )" );

        // (crews)title.crew.csv
        //ts.write( "LOAD DATA LOCAL INFILE 'c:/users/niels/ideaprojects/CSVToDatabase/csv/title.crew.csv' INTO TABLE crew FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' ( tconst, directors, writers )", "CREATE TABLE crew ( tconst VARCHAR(64) NOT NULL, directors VARCHAR(512), writers VARCHAR(512) );");

        // (episodes)title.episode.csv
        //ts.write( "LOAD DATA LOCAL INFILE 'c:/users/niels/ideaprojects/CSVToDatabase/csv/title.episode.csv' INTO TABLE episodes FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' ( tconst,parentTconst,seasonNumber,episodeNumber )", "CREATE TABLE episodes ( tconst VARCHAR(64) NOT NULL, parentTconst VARCHAR(64) NOT NULL, seasonNumber VARCHAR(16), episodeNumber VARCHAR(16) );");

        // (principals)title.principals.csv
        //ts.write( "LOAD DATA LOCAL INFILE 'c:/users/niels/ideaprojects/CSVToDatabase/csv/title.principals.csv' INTO TABLE principals FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' ( tconst,principalCast )", "CREATE TABLE principals ( tconst VARCHAR(64) NOT NULL,principalCast VARCHAR(512) NOT NULL );");

        // (ratings)title.ratings.csv
        //ts.write( "LOAD DATA LOCAL INFILE 'c:/users/niels/ideaprojects/CSVToDatabase/csv/title.ratings.csv' INTO TABLE ratings FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' ( tconst,averageRating,numVotes )", "CREATE TABLE ratings ( tconst VARCHAR(64) NOT NULL,averageRating VARCHAR(16) NOT NULL,numVotes VARCHAR(16) NOT NULL );");
    }
}